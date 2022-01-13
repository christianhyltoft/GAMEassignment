public class FieldStart extends Field {

    public FieldStart(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        gui.getMyGUI().showMessage(Settings.gameHandlerText[77] + name + "." + fieldType);
    }

    public String toString() {
        return Settings.gameHandlerText[78] + this.name + Settings.gameHandlerText[79];
    }
}
