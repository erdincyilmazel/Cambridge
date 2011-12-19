package cambridge.forms;

/**
 * Author: Erdinc Yilmazel
 * Date: 9/23/11
 */
public class TextFormInput implements FormInput {
    final String name;
    final String type;
    String id;
    String label;

    public TextFormInput(String name, String type, String id, String label) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.label = label;
    }

    public TextFormInput(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
