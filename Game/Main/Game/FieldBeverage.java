import gui_fields.GUI_Brewery;
import gui_fields.GUI_Street;

public class FieldBeverage extends FieldPurchaseAble {
    private int rollAmount;
    private int ownedAmount;
    public FieldBeverage(String name, String FieldType, Board parent, int buyprice, int mortgageValue) {
        super(name, FieldType, parent, buyprice, mortgageValue);
        this.rollAmount = rollAmount;
        this.ownedAmount = ownedAmount;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        GUI_Brewery ownable = (GUI_Brewery) gui.getMyGUI().getFields()[player.getPosition()];

       /* if (owner == null) {
            //GUI skal spørge om man vil købe grunden eller ej
            String buy = gui.getMyGUI().getUserButtonPressed("Do you want to buy this field for: " + this.buyPrice, "yes", "no");
            if (buy.equals("yes")) {
                setOwner(player);
                ownable.setOwnerName(player.getName());
                player.changeBalance(-this.buyPrice);
                gui.getMyGUI().showMessage("You now own this field");
                ownable.setRent("The rent is: " + this.rent);
                ownable.setBorder(gui.getMyPlayers()[player.getNumber()].getPrimaryColor());
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
            }
        } else {
            if (player == owner) {
                gui.getMyGUI().showMessage("You own this field so nothing happens");
            } else {
                int rentNow = currentRent();
                owner.changeBalance(rentNow);
                player.changeBalance(-rentNow);
                gui.getMyGUI().showMessage(this.owner.getName() + " owns this field, you now owe him " + this.currentRent());
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
            }
        }*/

    }
    @Override
    public String toString(){
        return "This is a danish classic, come and try a "+this.name+" and enjoy";
    }



}
