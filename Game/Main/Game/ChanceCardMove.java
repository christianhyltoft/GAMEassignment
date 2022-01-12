public class ChanceCardMove extends ChanceCard {

    private Field[] myFields;
    String goToField;

    public ChanceCardMove(String chanceCardText, String goToField, Field[] myFields, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.myFields = myFields;
        this.goToField = goToField;
    }

    @Override
    public void DrawCard(Player player, GUIController GUI) {
        super.DrawCard(player,GUI);
        // move to non-ferry property.
        for (int i = 0; i < myFields.length; i++) {
            if (myFields[i].getName().equals(goToField)) {
                player.setPosition(i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[i]);
                parent.getParent().getBoardAr()[i].landOn(player, GUI);
            }
        }
    }
}
