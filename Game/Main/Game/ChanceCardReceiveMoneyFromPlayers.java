public class ChanceCardReceiveMoneyFromPlayers extends ChanceCard {
    private int moneyAmount;

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
                GUI.getMyPlayers()[i].setBalance(GUI.getMyPlayers()[i].getBalance() - moneyAmount);
                GUI.getMyPlayers()[myPlayer.getNumber()].setBalance((GUI.getMyPlayers()[myPlayer.getNumber()].getBalance() + moneyAmount));
            }
        }
    }
}
