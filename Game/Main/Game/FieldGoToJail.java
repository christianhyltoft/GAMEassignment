public class FieldGoToJail extends Field {

    public FieldGoToJail(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        for(int i = 0; i < parent.getBoardAr().length; i++){

        }
    }

    public String toString() {
        return this.name + " could be your worst nightmare :o ";
    }
}
