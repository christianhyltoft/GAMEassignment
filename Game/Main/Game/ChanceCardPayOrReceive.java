public class ChanceCardPayOrReceive extends ChanceCard {

    private int moneyAmount;

    public ChanceCardPayOrReceive(int moneyAmount, String chanceCardText) {
        super(chanceCardText);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        myPlayer.changeBalance(moneyAmount);
    }
}