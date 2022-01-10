public class ChanceCardReceiveMoneyFromPlayers extends ChanceCard {
    private int moneyAmount;
    private Player[] players;

    public ChanceCardReceiveMoneyFromPlayers(String chanceCardText, int moneyAmount, Player[] players) {

        super(chanceCardText);
        this.moneyAmount = moneyAmount;
        this.players = players;

    }
    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != myPlayer){
                myPlayer.changeBalance(moneyAmount);
                players[i].changeBalance(-moneyAmount);
            }
        }
    }
}
