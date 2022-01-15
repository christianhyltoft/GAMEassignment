public class ChanceCardMatadorGrant extends ChanceCard {
    private final int moneyAmount;

    public ChanceCardMatadorGrant(int moneyAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void DrawCard(Player myPlayer, GUIController GUI) {
        super.DrawCard(myPlayer, GUI);

        int totalValue = 0;
        for (int i = 0; i < Settings.BOARD_SIZE; i++) {
            if (parent.getParent().getBoardAr()[i].getFieldType().matches("Property|Ferry|Beverage")) {
                FieldPurchaseAble myField = (FieldPurchaseAble) parent.getParent().getBoardAr()[i];
                if (myField.getOwner() == myPlayer) {
                    totalValue += myField.getBuyprice();
                }
            }
        }
        totalValue = ((totalValue + myPlayer.getBalance()));

        if (totalValue <= 15000) {
            myPlayer.changeBalance(moneyAmount);
        } else {
            GUI.getMyGUI().showMessage(Settings.gameHandlerText[44]);
        }
    }

}
