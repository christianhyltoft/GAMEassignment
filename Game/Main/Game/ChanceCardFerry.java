public class ChanceCardFerry extends ChanceCard {

    private final Field[] myFields;

    public ChanceCardFerry(String chanceCardText, Field[] myFields, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.myFields = myFields;
    }

    @Override
    public void DrawCard(Player player, GUIController GUI) {
        super.DrawCard(player,GUI);
        // move to ferry property.
        for (int i = 0; i < myFields.length / 2; i++) {
            if (myFields[player.getPosition() + i].getFieldType().equals("Ferry")){
                player.setPosition(player.getPosition() + i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[player.getPosition()]);
                parent.getParent().getBoardAr()[player.getPosition()].landOn(player, GUI);
                break;
            }
            else if (myFields[player.getPosition() - i].getFieldType().equals("Ferry")){
                player.setPosition(player.getPosition() - i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[player.getPosition()]);
                parent.getParent().getBoardAr()[player.getPosition()].landOn(player, GUI);
                break;
            }
        }
    }
}
