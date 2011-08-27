package cambridge.forms;

import java.util.ArrayList;

/**
 * User: erdinc
 * Date: Nov 13, 2009
 * Time: 3:41:19 PM
 */
public class Form {
    private String id;
    private String name;
    private String action;
    private String encType;

    enum Method {
        Post,
        Get
    }

    Method method;

    ArrayList<FormElement> elements;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public String getEncType() {
        return encType;
    }

    public Method getMethod() {
        return method;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setEncType(String encType) {
        this.encType = encType;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setElements(ArrayList<FormElement> elements) {
        this.elements = elements;
    }

    public ArrayList<FormElement> getElements() {
        return elements;
    }
}
