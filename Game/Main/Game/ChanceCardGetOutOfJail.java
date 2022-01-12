public class ChanceCardGetOutOfJail extends ChanceCard {


    public ChanceCardGetOutOfJail(String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        super.DrawCard(myPlayer, GUI);
        myPlayer.setEscapeJailCard(myPlayer.getEscapeJailCard() + 1);
    }
}
