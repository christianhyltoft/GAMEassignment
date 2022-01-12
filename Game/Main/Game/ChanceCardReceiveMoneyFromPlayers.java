public class ChanceCardReceiveMoneyFromPlayers extends ChanceCard {
    private int moneyAmount;

    public ChanceCardReceiveMoneyFromPlayers(int moneyAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        Player[] myPlayers = parent.getParent().getParent().getPlayers();

        for (int i = 0; i < myPlayers.length; i++) {
            if (myPlayers[i] != myPlayer) {
                myPlayer.changeBalance(moneyAmount);
                myPlayers[i].changeBalance(-moneyAmount);
            }
        }
    }
}
