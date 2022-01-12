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
        int total = 0;

        int totalValue = 0;
        for(int i = 0; i < Settings.BOARD_SIZE; i++){
            if(parent.getBoardAr()[i].getFieldtype().matches("Property|Ferry|Beverage")){
                FieldPurchaseAble myField = (FieldPurchaseAble) parent.getBoardAr()[i];
                totalValue += myField.getBuyprice();
            }
        }

        totalValue = ((totalValue + player.getBalance()) / 10);

        if ((player.getBalance() * taxDecimal) / 100 > taxAmount) {
            total = (-player.getBalance() * taxDecimal) / 100;
            gui.getMyGUI().showMessage("You are quite rich and must therefore pay: " + -total);
            player.changeBalance(total);
            gui.getMyPlayers()[player.getNumber()].setBalance(gui.getMyPlayers()[player.getNumber()].getBalance());
        } else {
            total = -taxAmount;
            player.changeBalance(-taxAmount);
            gui.getMyGUI().showMessage("You must pay: " + taxAmount);
            gui.getMyPlayers()[player.getNumber()].setBalance(gui.getMyPlayers()[player.getNumber()].getBalance());
        }

        for(int i = 0; i < Settings.BOARD_SIZE; i++){
            if(parent.getBoardAr()[i].getFieldtype().equals("Parking")){
                FieldParking myParking = (FieldParking) parent.getBoardAr()[i];
                myParking.addMoney(-total);
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " If you land on this field, you will feel the wrath of the danish tax authorities!";
    }
}
