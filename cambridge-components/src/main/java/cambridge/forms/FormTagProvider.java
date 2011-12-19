package cambridge.forms;

import cambridge.Cambridge;
import cambridge.DynamicTagCreator;
import cambridge.DynamicTagProvider;
import cambridge.FileTemplateLoader;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.TemplateLoadingException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Author: Erdinc Yilmazel
 * Date: 8/27/11
 */
public class FormTagProvider implements DynamicTagProvider {

    @Override
    public FormTag getInstance() {
        DynamicTagCreator creator = new DynamicTagCreator();
        try {
            return creator.createTag(FormTag.class.getResourceAsStream("form.html"), FormTag.class);
        } catch (TemplateLoadingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String template = "<div>" +
                "<a:form form=\"f\"/>" +
                "</div>";

        Cambridge.getInstance().bindTag(Cambridge.DefaultNamespaceURI, "form").toProvider(new FormTagProvider());

        FileTemplateLoader loader = new FileTemplateLoader();
        TemplateFactory templateFactory = loader.parseAndCreateTemplateFactory(template);

        Template t = templateFactory.createTemplate();

        Form form = new Form();
        form.setAction("/test");
        form.setMethod(Form.Method.Post);
        form.setName("testForm");

        ArrayList<FormInput> formInputs = new ArrayList<FormInput>();
        formInputs.add(new TextFormInput("username", "text", "username", "User Name"));
        form.setInputs(formInputs);

        t.setProperty("f", form);

        PrintWriter writer = new PrintWriter(System.out);
        try {
            t.printTo(writer);
            writer.flush();
            System.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
