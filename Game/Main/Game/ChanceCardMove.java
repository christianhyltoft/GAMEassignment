public class ChanceCardMove extends ChanceCard {

    private Field[] myFields;

    public ChanceCardMove(String chanceCardText, Field[] myFields, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.myFields = myFields;
    }

    @Override
    public void DrawCard(Player player, GUIController GUI) {
        super.DrawCard(player,GUI);
        String[] fieldname = chanceCardText.split("\"", 2);
        // move to non-ferry property.
        for (int i = 0; i < myFields.length; i++) {
            if (myFields[i].getName().equals(fieldname[1])) {
                player.setPosition(i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[i]);
                parent.getParent().getBoardAr()[i].landOn(player, GUI);
            }
        }
    }
}
