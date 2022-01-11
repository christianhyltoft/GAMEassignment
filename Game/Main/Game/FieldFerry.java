import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;

public class FieldFerry extends FieldPurchaseAble {
    private int rent;

    public FieldFerry(String name, String FieldType, int buyprice,int moortgageValue, int rent){
        super(name,FieldType,buyprice,moortgageValue);
        this.rent=rent;
    }


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public void landOn(Player player, GUIController gui){
        super.landOn(player, gui);

        GUI_Shipping ownable = (GUI_Shipping) gui.getMyGUI().getFields()[player.getPosition()];

        if (owner == null) {
            String buy = gui.getMyGUI().getUserButtonPressed("Do you want to buy this field", "yes", "no");

            if (buy.equals("yes")) {
                setOwner(player);
                player.changeBalance(-buyPrice);
                gui.getMyGUI().showMessage("You now own this field");
                ownable.setRent("The rent is: " + this.rent);
                ownable.setBorder(gui.getMyPlayers()[player.getNumber()].getPrimaryColor());
                gui.getMyPlayers()[player.getNumber()].setBalance(gui.getMyPlayers()[player.getNumber()].getBalance() - this.buyPrice);
            }

        } else {

            if (player == owner) {
                //Udskriv message+messageowned til GUI
            }
            else {
                owner.changeBalance(rent);
                player.changeBalance(-rent);
            }
        }

    }
    @Override
    public String toString(){
        return "Here at "+this.name + " we offer a wide variety of trips. ";
    }
}
