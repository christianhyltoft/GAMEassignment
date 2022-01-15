import gui_fields.GUI_Shipping;

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
        gui.getMyGUI().showMessage(Settings.gameHandlerText[64]);
        GUI_Shipping ownable = (GUI_Shipping) gui.getMyGUI().getFields()[player.getPosition()];

        String buyer = "";
        while (true) {
            buyer = gui.getMyGUI().getUserString(Settings.gameHandlerText[65]);
            for (int i = 0; i < players.length; i++) {
                if (players[i].getName().equals(buyer)) {
                    int price = gui.getMyGUI().getUserInteger(Settings.gameHandlerText[66]);
                    this.owner = players[i];
                    players[i].changeBalance(-price);
                    gui.getMyPlayers()[players[i].getNumber()].setBalance(players[i].getBalance());
                    ownable.setOwnerName(buyer);
                    ownable.setBorder(gui.getMyPlayers()[players[i].getNumber()].getPrimaryColor(), Color.BLACK);
                    gui.getMyGUI().showMessage(players[i].getName() + Settings.gameHandlerText[67]);
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
            String buy = gui.getMyGUI().getUserButtonPressed(Settings.gameHandlerText[47], Settings.gameHandlerText[48], Settings.gameHandlerText[49]);

            if (buy.equals(Settings.gameHandlerText[48])) {
                setOwner(player);
                player.changeBalance(-buyPrice);
                gui.getMyGUI().showMessage(Settings.gameHandlerText[50]);
                ownable.setRent(Settings.gameHandlerText[51] + this.rent);
                ownable.setBorder(gui.getMyPlayers()[player.getNumber()].getPrimaryColor(), Color.BLACK);
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
            }

        } else {
            if (player == owner) {
                // Udskriv message + messageowned til GUI
                // Temp message
                gui.getMyGUI().showMessage(Settings.gameHandlerText[58] + name + Settings.gameHandlerText[59]);
            } else {
                if (owner.isJailed()) {
                    gui.getMyGUI().showMessage(Settings.gameHandlerText[53]);
                } else {
                    int ferriesOwned = 0;

                    for (int i = 0; i < 40; i++) {
                        if (parent.getBoardAr()[i].getFieldType().equals("Ferry")) {
                            FieldFerry check = (FieldFerry) parent.getBoardAr()[i];

                            if (check.getPairNumber() == pairNumber) {
                                if (check.getOwner() == this.owner) {
                                    ferriesOwned++;
                                }
                            }
                        }
                    }
                    int temprent = this.rent;

                    for (int i = 0; i < ferriesOwned - 1; i++) {
                        temprent *= 2;
                    }

                    owner.changeBalance(temprent);
                    player.changeBalance(-temprent);
                    gui.getMyGUI().showMessage("You must pay: " + temprent + "Since: " + this.owner.getName() + " owns " + ferriesOwned + " " + this.fieldType);
                    gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                    gui.getMyPlayers()[owner.getNumber()].setBalance(this.owner.getBalance());
                }
            }
        }
    }

    @Override
    public String toString() {
        return Settings.gameHandlerText[60] + this.name + Settings.gameHandlerText[61];
    }
}
