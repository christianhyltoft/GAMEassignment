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
            if(parent.getBoardAr()[i].getFieldtype().matches("Property|Ferry|Beverage")){
                FieldPurchaseAble myField = (FieldPurchaseAble) parent.getBoardAr()[i];
                totalValue += myField.getBuyprice();
            }
        }
        totalValue = ((totalValue + player.getBalance()) / 10);

        String choice = gui.getMyGUI().getUserSelection("Choose whether to pay the flat rate" + taxAmount +" or 10% of your total net worth which is " + totalValue, "Flat rate", "10%");

        int pay = 0;

        if(choice.equals("Flat rate")){
            pay = taxAmount;
        }
        else{
            pay = totalValue;
        }

        gui.getMyGUI().showMessage("You will now pay " + pay);
        player.changeBalance(-pay);
        gui.getMyPlayers()[player.getNumber()].setBalance(gui.getMyPlayers()[player.getNumber()].getBalance());

        for(int i = 0; i < Settings.BOARD_SIZE; i++){
            if(parent.getBoardAr()[i].getFieldtype().equals("Parking")){
                FieldParking myParking = (FieldParking) parent.getBoardAr()[i];
                myParking.addMoney(pay);
                gui.getMyGUI().showMessage(pay + " added to parking, total amount now " + myParking.g);
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " If you land on this field, you will feel the wrath of the danish tax authorities!";
    }
}
