public abstract class ChanceCard {

    protected int chanceCardAmount;
    protected String chanceCardText;

    public ChanceCard(String chanceCardText) {
        this.chanceCardText = chanceCardText;
    }

    public void DrawCard(Player player, GUIController GUI) {

        System.out.println(chanceCardText);
    }

}