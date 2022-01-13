public class ChanceCardMoveBackOrForward extends ChanceCard {

    private final int moveAmount;

    public ChanceCardMoveBackOrForward(int moveAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.moveAmount = moveAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        super.DrawCard(myPlayer,GUI);
        myPlayer.changePosition(moveAmount);
        GUI.getMyPlayers()[myPlayer.getNumber()].getCar().setPosition(GUI.getMyGUI().getFields()[myPlayer.getPosition()]);
        parent.getParent().getBoardAr()[myPlayer.getPosition()].landOn(myPlayer, GUI);
    }
}
