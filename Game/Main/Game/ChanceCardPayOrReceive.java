public class ChanceCardPayOrReceive extends ChanceCard{
    private int moneyAmount;

    public ChanceCardPayOrReceive(int chanceCardAmount, String chanceCardText, int chanceCardID) {
        super(chanceCardAmount, chanceCardText, chanceCardID);
        this.moneyAmount = moneyAmount;
    }
    @Override
    public void DrawCard(Player myPlayer) {
    myPlayer.changeBalance(moneyAmount);
    }
}