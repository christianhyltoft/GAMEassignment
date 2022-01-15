public class ChanceCardMove extends ChanceCard {

    private final Field[] myFields;
    String goToField;
    int passStart;

    public ChanceCardMove(String chanceCardText, int passStart, String goToField, Field[] myFields, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.passStart = passStart;
        this.myFields = myFields;
        this.goToField = goToField;
    }

    @Override
    public void DrawCard(Player player, GUIController GUI) {
        super.DrawCard(player,GUI);
        // move to non-ferry property.
        for (int i = 0; i < myFields.length; i++) {
            if (myFields[i].getName().equals(goToField)) {
                int position = player.getPosition();
                player.setPosition(i);
                GUI.getMyPlayers()[player.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[i]);
                if (position > player.getPosition()){
                    player.changeBalance(passStart);
                    GUI.getMyGUI().showMessage(Settings.gameHandlerText[43]);
                    GUI.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                }
                parent.getParent().getBoardAr()[i].landOn(player, GUI);
            }
        }
    }
}
