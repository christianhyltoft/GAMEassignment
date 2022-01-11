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

        if ((player.getBalance() * taxDecimal) / 100 > taxAmount) {
            gui.getMyGUI().showMessage("You are quite rich and must therefore pay: " + (-player.getBalance() * taxDecimal) / 100);
            player.changeBalance((-player.getBalance() * taxDecimal) / 100);
            gui.getMyPlayers()[player.getNumber()].setBalance(gui.getMyPlayers()[player.getNumber()].getBalance() - (player.getBalance() * taxDecimal / 100));
        } else {
            player.changeBalance(-taxAmount);
        }
        gui.getMyGUI().showMessage("You must pay: " + taxAmount);

        gui.getMyPlayers()[player.getNumber()].setBalance(gui.getMyPlayers()[player.getNumber()].getBalance() - taxAmount);

    }

    @Override
    public String toString() {
        return this.name + " If you land on this field, you will feel the wrath of the danish tax authorities!";
    }
}
