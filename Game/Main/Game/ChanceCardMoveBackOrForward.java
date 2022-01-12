public class ChanceCardMoveBackOrForward extends ChanceCard {

    private int moveAmount;

    public ChanceCardMoveBackOrForward(int moveAmount, String chanceCardText) {
        super(chanceCardText);
        this.moveAmount = moveAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        myPlayer.changePosition(moveAmount);
        GUI.getMyPlayers()[myPlayer.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[myPlayer.getPosition()]);
    }
}
