import gui_fields.GUI_Brewery;

import java.awt.*;
public class FieldBeverage extends FieldPurchaseAble {
    private int rollAmount;
    private int ownedAmount;

    public FieldBeverage(String name, String FieldType, Board parent, int buyprice, int mortgageValue, int pairNumber) {
        super(name, FieldType, parent, buyprice, mortgageValue, pairNumber);
        this.rollAmount = rollAmount;
        this.ownedAmount = ownedAmount;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        GUI_Brewery ownable = (GUI_Brewery) gui.getMyGUI().getFields()[player.getPosition()];

        if (owner == null) {
            //GUI skal spørge om man vil købe grunden eller ej
            String buy = gui.getMyGUI().getUserButtonPressed("Do you want to buy this field for: " + this.buyPrice, "yes", "no");
            if (buy.equals("yes")) {
                setOwner(player);
                ownable.setOwnerName(player.getName());
                player.changeBalance(-this.buyPrice);
                gui.getMyGUI().showMessage("You now own this field");
                ownable.setRent("The rent is: " + this.currentRent());
                ownable.setBorder(gui.getMyPlayers()[player.getNumber()].getPrimaryColor(), Color.BLACK);
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
            }
        } else {
            if (player == owner) {
                gui.getMyGUI().showMessage("You own this field so nothing happens");
            } else {
                if (owner.isJailed()) {
                    gui.getMyGUI().showMessage("The owner is in jail, so you don't have to pay");
                } else {


                    int beverages = 0;
                    int beveragesOwned = 0;

                    for (int i = 0; i < 40; i++) {
                        if (parent.getBoardAr()[i].getFieldType().equals("Beverage")) {
                            FieldBeverage check = (FieldBeverage) parent.getBoardAr()[i];
                            if (check.getPairNumber() == pairNumber) {
                                beverages++;
                                if (check.getOwner() == player) {
                                    beveragesOwned++;
                                }
                            }
                        }
                    }

                    if (beverages == beveragesOwned) {
                        int rentNow = parent.getParent().GetRafflecup().sum() * 200;
                        owner.changeBalance(rentNow);
                        player.changeBalance(-rentNow);
                        gui.getMyGUI().showMessage(this.owner.getName() + " owns all the beverages, you now owe him " + this.BigRent());
                        gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                        gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                    } else {
                        int rentNow = parent.getParent().GetRafflecup().sum() * 100;
                        owner.changeBalance(rentNow);
                        player.changeBalance(-rentNow);
                        gui.getMyGUI().showMessage(this.owner.getName() + " owns this field, you now owe him " + this.currentRent());
                        gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                        gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                    }
                }
            }
        }
    }

    private String currentRent() {
        return "100 times the eyes on the dies rolled when landing on the field";
    }

    private String BigRent() {
        return "100 times the eyes on the dies rolled when landing on the field";
    }

    @Override
    public void auction(Player player, Player[] players, GUIController gui) {
        if (this.owner != null)
            return;
        gui.getMyGUI().showMessage("This property is now up for auction");
        GUI_Brewery ownable = (GUI_Brewery) gui.getMyGUI().getFields()[player.getPosition()];

        String buyer;
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



    @Override
    public String toString() {
        return "This is a danish classic, come and try a " + this.name + " and enjoy";
    }


}
