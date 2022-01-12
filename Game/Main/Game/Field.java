public abstract class Field {
    protected String name;
    protected String Fieldtype;
    protected Board parent;

    public Field(String name, String FieldType, Board parent) {
        this.name = name;
        this.Fieldtype = FieldType;
        this.parent = parent;
    }

    public String getFieldtype() {
        return Fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.Fieldtype = fieldtype;
    }

    public String getName() {
        return name;
    }

    public void landOn(Player player, GUIController gui) {
        gui.getMyGUI().showMessage("You landed on" + this.name);
    }

    public String toString() {
        return "You landed on: " + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void auction(Player player, Player[] players, GUIController gui) {
    }

    ;
}


