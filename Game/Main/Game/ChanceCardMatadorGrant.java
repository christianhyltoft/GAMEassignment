public class ChanceCardMatadorGrant extends ChanceCard {
    private int moneyAmount;

    public ChanceCardMatadorGrant(int moneyAmount, String chanceCardText) {
        super(chanceCardText);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        if (myPlayer.getBalance() <= 15000) {
            myPlayer.changeBalance(moneyAmount);
        } else {
            System.out.println("your total value exceeds 15000kr, therefore you will not receive the Matador grant of 40000kr. What a shame");
        }
    }
}
