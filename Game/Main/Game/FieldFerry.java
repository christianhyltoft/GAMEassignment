import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;

import java.awt.*;

public class FieldFerry extends FieldPurchaseAble {
    private int rent;

    public FieldFerry(String name, String FieldType, Board parent, int buyPrice, int mortgageValue, int rent, int pairNumber) {
        super(name, FieldType, parent, buyPrice, mortgageValue, pairNumber);
        this.rent = rent;
    }

    @Override
    public void auction(Player player, Player[] players, GUIController gui) {
        if (this.owner != null)
            return;
        gui.getMyGUI().showMessage("This property is now up for auction");
        GUI_Shipping ownable = (GUI_Shipping) gui.getMyGUI().getFields()[player.getPosition()];

        String buyer = "";
        while (true) {
            buyer = gui.getMyGUI().getUserString("Figure out amongst yourselves who will buy the field and for what price and enter the player who wants to buy: ");
            for (int i = 0; i < players.length; i++) {
                if (players[i].getName().equals(buyer)) {
                    int price = gui.getMyGUI().getUserInteger("Name the price you bargained for");
                    this.owner = players[i];
                    players[i].changeBalance(-price);
                    gui.getMyPlayers()[players[i].getNumber()].setBalance(players[i].getBalance());
                    ownable.setOwnerName(buyer);
                    ownable.setBorder(gui.getMyPlayers()[players[i].getNumber()].getPrimaryColor(), Color.BLACK);
                    gui.getMyGUI().showMessage(players[i].getName() + " now owns this field");
                    return;

                }

            }
        }

    }

    ;


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        GUI_Shipping ownable = (GUI_Shipping) gui.getMyGUI().getFields()[player.getPosition()];

        if (owner == null) {
            String buy = gui.getMyGUI().getUserButtonPressed("Do you want to buy this field", "yes", "no");

            if (buy.equals("yes")) {
                setOwner(player);
                player.changeBalance(-buyPrice);
                gui.getMyGUI().showMessage("You now own this field");
                ownable.setRent("The rent is: " + this.rent);
                ownable.setBorder(gui.getMyPlayers()[player.getNumber()].getPrimaryColor(), Color.BLACK);
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
            }

        } else {
            if (player == owner) {
                // Udskriv message + messageowned til GUI
                // Temp message
                gui.getMyGUI().showMessage("You own this field: " + name + " nothing happens");
            } else {
                int ferriesOwned = 0;

                for(int i = 0; i < 40; i++){
                    if(parent.getBoardAr()[i].getFieldtype().equals("Ferry")){
                        FieldFerry check = (FieldFerry) parent.getBoardAr()[i];
                        if(check.getPairNumber() == pairNumber){
                            if(check.getOwner() == player){
                                ferriesOwned++;
                            }
                        }
                    }
                }

                for(int i = 0; i < ferriesOwned - 1; i++){
                    rent = rent * 2;
                }

                owner.changeBalance(rent);
                player.changeBalance(-rent);
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                gui.getMyPlayers()[owner.getNumber()].setBalance(this.owner.getBalance());
            }
        }

    }

    @Override
    public String toString() {
        return "Here at " + this.name + " we offer a wide variety of trips. ";
    }
}
