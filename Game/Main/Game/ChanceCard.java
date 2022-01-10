public abstract class ChanceCard {

    protected int chanceCardAmount;
    protected String chanceCardText;

    public ChanceCard(String chanceCardText) {
        this.chanceCardText = chanceCardText;
    }

    public void DrawCard(Player player) {
        System.out.println(chanceCardText);
    }

}