public class FieldGoToJail extends Field {

    public FieldGoToJail(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        for(int i = 0; i < parent.getBoardAr().length; i++){
            if(parent.getBoardAr()[i].getFieldType().equals("Jail")){
                player.setPosition(i);
                gui.getMyPlayers()[player.getNumber()].getCar().setPosition(gui.getMyGUI().getFields()[i]);
                player.setJailed(true);
            }
        }
    }

    public String toString() {
        return this.name + " could be your worst nightmare :o ";
    }
}
