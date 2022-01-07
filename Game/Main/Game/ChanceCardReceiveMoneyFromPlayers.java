public class ChanceCardReceiveMoneyFromPlayers extends ChanceCard {
    private int moneyAmount;
    private Player[] players;

    public ChanceCardReceiveMoneyFromPlayers(int chanceCardAmount, String chanceCardText, int chanceCardID, int moneyAmount, Player[] players) {

        super(chanceCardAmount, chanceCardText, chanceCardID);
        this.moneyAmount = moneyAmount;
        this.players = players;

    }

    public void DrawCard(Player myPlayer) {
       super.DrawCard(myPlayer);
        for (int i = 0; i < players.length; i++) {
            if (players[i] != myPlayer){
                myPlayer.changeBalance(moneyAmount);
                players[i].changeBalance(-moneyAmount);
            }
        }
    }
}
