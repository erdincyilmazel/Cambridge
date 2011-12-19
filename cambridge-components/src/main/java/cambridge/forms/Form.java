package cambridge.forms;

import java.util.ArrayList;

/**
 * @author Erdinc Yilmazel
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

    ArrayList<FormInput> inputs;

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

    public void setInputs(ArrayList<FormInput> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<FormInput> getInputs() {
        return inputs;
    }
}
