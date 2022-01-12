public class ChanceCardFerry extends ChanceCard {

    private Field[] myFields;

    public ChanceCardFerry(String chanceCardText, Field[] myFields, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.myFields = myFields;
    }

    @Override
    public void DrawCard(Player player, GUIController GUI) {
        super.DrawCard(player,GUI);
        // move to ferry property.
        for (int i = 0; i < myFields.length / 2; i++) {
            if (myFields[player.getPosition() + i].getFieldtype().equals("Ferry")){
                player.setPosition(player.getPosition() + i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[player.getPosition() + i]);
                parent.getParent().getBoardAr()[player.getPosition() + i].landOn(player, GUI);
                break;
            }
            else if (myFields[player.getPosition() - i].getFieldtype().equals("Ferry")){
                player.setPosition(player.getPosition() - i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[player.getPosition() - i]);
                parent.getParent().getBoardAr()[player.getPosition() - i].landOn(player, GUI);
                break;
            }
        }
    }
}
