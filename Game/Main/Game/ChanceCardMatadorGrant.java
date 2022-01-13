public class ChanceCardMatadorGrant extends ChanceCard {
    private final int moneyAmount;

    public ChanceCardMatadorGrant(int moneyAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        super.DrawCard(myPlayer,GUI);
        if (myPlayer.getBalance() <= 15000) {
            myPlayer.changeBalance(moneyAmount);
        } else {
            GUI.getMyGUI().showMessage(Settings.gameHandlerText[44]);
        }
    }
}
