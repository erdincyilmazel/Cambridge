package cambridge;

import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;

import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/**
 * @author Erdinc Yilmazel
 *         Date: Nov 3, 2009
 *         Time: 4:03:22 PM
 */

class FileTemplateFactory extends TemplateFactory
{
    private final File templateFile;
    private final String encoding;
    private final TemplateModifier modifier;
    private final ExpressionLanguage expressionLanguage;
    private long lastReload;
    private HashSet<File> includes;

    private final int changeDetectionInterval;

    public FileTemplateFactory(TemplateLoader loader, FragmentList fragments, File templateFile, String encoding, TemplateModifier modifier, HashSet<File> includes, int changeDetectionInterval)
    {
        super(loader, fragments);
        this.templateFile = templateFile;
        this.encoding = encoding;
        this.modifier = modifier;
        this.includes = includes;
        this.changeDetectionInterval = changeDetectionInterval;
        this.expressionLanguage = fragments.getExpressionLanguage();
        this.lastReload = System.currentTimeMillis();
    }

    @Override
    public Template createTemplate()
    {
        checkForChanges();

        return new DynamicTemplate(fragments, expressionLanguage.createNewContext());
    }

    @Override
    public Template createTemplate(Locale locale)
    {
        checkForChanges();

        return new DynamicTemplate(fragments, expressionLanguage.createNewContext(locale));
    }

    private void checkForChanges()
    {
        if (changeDetectionInterval != -1 && !reloading && lastReload + changeDetectionInterval < System.currentTimeMillis())
        {
            if (templateFile.lastModified() > lastReload)
            {
                reload();
            }
            else if (includes != null)
            {
                for (File f : includes)
                {
                    if (f.exists() && f.lastModified() > lastReload)
                    {
                        reload();
                        break;
                    }
                }
            }
        }
    }

    private volatile boolean reloading;

    private synchronized void reload()
    {
        reloading = true;
        FileTemplateLoader l = (FileTemplateLoader) loader;
        try
        {
            TemplateDocument doc = l.parseTemplate(templateFile, encoding, expressionLanguage);
            if (modifier != null)
            {
                modifier.modifyTemplate(doc);
            }

            if (doc.getIncludes() != null)
            {
                includes = l.getFiles(doc.getIncludes());
            }

            fragments = doc.normalize();

            lastReload = System.currentTimeMillis();
        }
        catch (TemplateLoadingException e)
        {
            throw new TemplateReloadingException(e);
        }
        catch (BehaviorInstantiationException e)
        {
            e.printStackTrace();
            throw new TemplateReloadingException(e);
        }
        reloading = false;
    }
}
