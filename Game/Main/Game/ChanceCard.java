public abstract class ChanceCard {

    protected int chanceCardAmount;
    protected int chanceCardID;
    protected String chanceCardText;

    public ChanceCard(int chanceCardAmount, String chanceCardText, int chanceCardID) {
        this.chanceCardAmount = chanceCardAmount;
        this.chanceCardID = chanceCardID;
        this.chanceCardText = chanceCardText;
    }

    public void DrawCard(Player player) {
        System.out.println(chanceCardText);
    }
}