public abstract class ChanceCard {

    protected String chanceCardText;
    protected ChanceCardDeck parent;

    public ChanceCard(String chanceCardText, ChanceCardDeck parent) {
        this.parent = parent;
        this.chanceCardText = chanceCardText;
    }

    public void DrawCard(Player player, GUIController GUI) {
        GUI.getMyGUI().displayChanceCard(this.chanceCardText);
    }

    public String getChanceCardText() {
        return chanceCardText;
    }
}