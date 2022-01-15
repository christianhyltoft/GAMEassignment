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
            String buy = gui.getMyGUI().getUserButtonPressed(Settings.gameHandlerText[47] + this.buyPrice, Settings.gameHandlerText[48], Settings.gameHandlerText[49]);
            if (buy.equals(Settings.gameHandlerText[48])) {
                setOwner(player);
                ownable.setOwnerName(player.getName());
                player.changeBalance(-this.buyPrice);
                gui.getMyGUI().showMessage(Settings.gameHandlerText[50]);
                ownable.setRent(Settings.gameHandlerText[51] + this.currentRent());
                ownable.setBorder(gui.getMyPlayers()[player.getNumber()].getPrimaryColor(), Color.BLACK);
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
            }
        } else {
            if (player == owner) {
                gui.getMyGUI().showMessage(Settings.gameHandlerText[52]);
            } else {
                if (owner.isJailed()) {
                    gui.getMyGUI().showMessage(Settings.gameHandlerText[53]);
                } else {


                    int beverages = 0;
                    int beveragesOwned = 0;

                    for (int i = 0; i < 40; i++) {
                        if (parent.getBoardAr()[i].getFieldType().equals("Beverage")) {
                            FieldBeverage check = (FieldBeverage) parent.getBoardAr()[i];
                            if (check.getPairNumber() == pairNumber) {
                                beverages++;
                                if (check.getOwner() == this.owner) {
                                    beveragesOwned++;
                                }
                            }
                        }
                    }

                    int rentNow;
                    if (beverages == beveragesOwned) {
                        rentNow = parent.getParent().GetRafflecup().sum() * 200;
                        owner.changeBalance(rentNow);
                        player.changeBalance(-rentNow);
                        gui.getMyGUI().showMessage(this.owner.getName() + Settings.gameHandlerText[54] +" "+ this.BigRent());
                    } else {
                        rentNow = parent.getParent().GetRafflecup().sum() * 100;
                        owner.changeBalance(rentNow);
                        player.changeBalance(-rentNow);
                        gui.getMyGUI().showMessage(this.owner.getName() + Settings.gameHandlerText[55] +" "+ this.currentRent());
                    }
                    gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                    gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                }
            }
        }
    }

    private String currentRent() {
        return Settings.gameHandlerText[56];
    }

    private String BigRent() {
        return Settings.gameHandlerText[56];
    }

    @Override
    public void auction(Player player, Player[] players, GUIController gui) {
        super.auction(player, players, gui);
    }



    @Override
    public String toString() {
        return Settings.gameHandlerText[62] + this.name + Settings.gameHandlerText[63];
    }


}
