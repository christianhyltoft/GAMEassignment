//This field is only really made, so you can initialise the field.
public class FieldJail extends Field {

    public FieldJail(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
    }

    @Override
    public void landOn(Player player, GUIController gui) {

    }

    public String toString() {
        return Settings.gameHandlerText[69] + this.name + Settings.gameHandlerText[70];
    }

}
