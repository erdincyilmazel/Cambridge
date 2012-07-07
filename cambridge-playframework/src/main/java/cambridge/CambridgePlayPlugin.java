package cambridge;

import cambridge.parser.*;
import play.PlayPlugin;
import play.mvc.ActionFunction;
import play.templates.Template;
import play.vfs.VirtualFile;

/**
 * Author: Erdinc Yilmazel
 * Since: 12/26/11
 */
public class CambridgePlayPlugin extends PlayPlugin {
    static {
        cambridge.parser.TemplateParser.registerExtensionPoint(new PlayActionsExtensionPoint(false));
        cambridge.parser.TemplateParser.registerExtensionPoint(new PlayActionsExtensionPoint(true));
        cambridge.parser.TemplateParser.registerExtensionPoint(new PlayMessagesExtensionPoint());

        Cambridge cambridge = Cambridge.getInstance();
        cambridge.registerFunction("Action", new ActionFunction(false));
        cambridge.registerFunction("AAction", new ActionFunction(true));
    }

    FileTemplateLoader templateLoader;

    @Override
    public void onLoad() {
        super.onLoad();
        templateLoader = new FileTemplateLoader();
    }

    @Override
    public Template loadTemplate(VirtualFile file) {
        TemplateFactory templateFactory = templateLoader.newTemplateFactory(file.getRealFile());
        return new CambridgePlayTemplate(templateFactory);
    }
}
