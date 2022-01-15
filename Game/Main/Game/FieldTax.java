public class FieldTax extends Field {

    private final int taxAmount;
    private final int taxDecimal;

    public FieldTax(String name, String FieldType, Board parent, int taxAmount, int taxDecimal) {
        super(name, FieldType, parent);
        this.taxAmount = taxAmount;
        this.taxDecimal = taxDecimal;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        int totalValue = 0;
        for(int i = 0; i < Settings.BOARD_SIZE; i++){
            if(parent.getBoardAr()[i].getFieldType().matches("Property|Ferry|Beverage")){
                FieldPurchaseAble myField = (FieldPurchaseAble) parent.getBoardAr()[i];
                if(myField.getOwner() == player){
                    totalValue += myField.getBuyprice();
                }
            }
        }
        totalValue = ((totalValue + player.getBalance()) / 10);

        String choice = gui.getMyGUI().getUserSelection(Settings.gameHandlerText[37] + taxAmount + Settings.gameHandlerText[38] + totalValue, Settings.gameHandlerText[39], "10%");

        int pay;

        if(choice.equals(Settings.gameHandlerText[39])){
            pay = taxAmount;
        }
        else{
            pay = totalValue;
        }

        gui.getMyGUI().showMessage(Settings.gameHandlerText[40] + pay);
        player.changeBalance(-pay);
        gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());

        for(int i = 0; i < Settings.BOARD_SIZE; i++){
            if(parent.getBoardAr()[i].getFieldType().equals("Parking")){
                FieldParking myParking = (FieldParking) parent.getBoardAr()[i];
                myParking.addMoney(pay);
                gui.getMyGUI().showMessage(pay + Settings.gameHandlerText[41] + " " + myParking.getTotalMoney());
            }
        }
    }

    @Override
    public String toString() {
        return this.name + Settings.gameHandlerText[42];
    }
}
