public class FieldStart extends Field {

    public FieldStart(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        gui.getMyGUI().showMessage("You landed on the field " + name + "." + Fieldtype);
    }

    public String toString() {
        return "This is the " + this.name + " and it all starts here.";
    }
}
