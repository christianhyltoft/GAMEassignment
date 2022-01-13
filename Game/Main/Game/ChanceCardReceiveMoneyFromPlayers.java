public class ChanceCardReceiveMoneyFromPlayers extends ChanceCard {
    private final int moneyAmount;

    public ChanceCardReceiveMoneyFromPlayers(int moneyAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        super.DrawCard(myPlayer, GUI);
        Player[] myPlayers = parent.getParent().getParent().getPlayers();

        for (int i = 0; i < myPlayers.length; i++) {
            if (myPlayers[i] != myPlayer) {
                GUI.getMyGUI().showMessage(myPlayers[i].getName() + " gives " + myPlayer.getName() + " " + moneyAmount);
                myPlayer.changeBalance(moneyAmount);
                myPlayers[i].changeBalance(-moneyAmount);
                GUI.getMyPlayers()[i].setBalance(myPlayer.getBalance());
                GUI.getMyPlayers()[myPlayer.getNumber()].setBalance((myPlayers[i].getBalance()));
            }
        }
    }
}
