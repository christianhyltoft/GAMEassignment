public class ChanceCardPayOrReceive extends ChanceCard {

    private int moneyAmount;

    public ChanceCardPayOrReceive(int moneyAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        myPlayer.changeBalance(moneyAmount);
        GUI.getMyPlayers()[myPlayer.getNumber()].setBalance(myPlayer.getBalance());
    }
}