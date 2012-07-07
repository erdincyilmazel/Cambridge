package cambridge;

import java.util.Map;

/**
 * Author: Erdinc Yilmazel
 * Since: 12/26/11
 */
public class CambridgePlayTemplate extends play.templates.Template {
    TemplateFactory factory;

    public CambridgePlayTemplate(TemplateFactory factory) {
        this.factory = factory;
    }

    @Override
    public void compile() {
    }

    @Override
    protected String internalRender(Map<String, Object> stringObjectMap) {
        Template template = factory.createTemplate();
        template.setAllProperties(stringObjectMap);
        return template.asString();
    }
}
