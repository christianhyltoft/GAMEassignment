public class ChanceCardMatadorGrant extends ChanceCard {
    private int moneyAmount;

    public ChanceCardMatadorGrant(int chanceCardAmount, String chanceCardText, int chanceCardID) {
        super(chanceCardAmount, chanceCardText, chanceCardID);
        this.moneyAmount = moneyAmount;
    }

    public void DrawCard(Player myPlayer) {
        if (myPlayer.getBalance()<= 15000){
            myPlayer.changeBalance(moneyAmount);
        }
        else {
           // her skal vi have en kommentar svarende til nedenstående ♥♥♥
            // System.out.println("your total value exceeds 15000kr, therefore you will not receive the Matador grant of 40000kr. What a shame");
        }
    }
}
