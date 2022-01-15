import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;

import java.awt.*;

public class FieldDeed extends FieldPurchaseAble {
    private int rent;
    private final int rent1;
    private final int rent2;
    private final int rent3;
    private final int rent4;
    private final int rent5;
    private final int houseprice;
    private final int pairnumber;

    private int amountOfHouses;

    public FieldDeed(String name, String FieldType, Board parent, int buyprice, int mortgageValue, int rent, int rent1, int rent2, int rent3, int rent4, int rent5, int houseprice, int pairNumber) {
        super(name, FieldType, parent, buyprice, mortgageValue, pairNumber);
        this.rent = rent;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rent5 = rent5;
        this.amountOfHouses = 0;
        this.houseprice = houseprice;
        this.pairnumber = pairNumber;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        GUI_Street ownable = (GUI_Street) gui.getMyGUI().getFields()[player.getPosition()];

        if (owner == null) {
            //GUI skal spørge om man vil købe grunden eller ej
            String buy = gui.getMyGUI().getUserButtonPressed(Settings.gameHandlerText[47] + this.buyPrice, Settings.gameHandlerText[48], Settings.gameHandlerText[49]);
            if (buy.equals(Settings.gameHandlerText[48])) {
                setOwner(player);
                ownable.setOwnerName(player.getName());
                player.changeBalance(-this.buyPrice);
                gui.getMyGUI().showMessage(Settings.gameHandlerText[50]);
                ownable.setRent(Settings.gameHandlerText[51] + this.rent);
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

                    int properties = 0;
                    int propertiesOwned = 0;

                    for (int i = 0; i < 40; i++) {
                        if (parent.getBoardAr()[i].getFieldType().equals("Property")) {
                            FieldDeed check = (FieldDeed) parent.getBoardAr()[i];
                            if (check.getPairNumber() == pairNumber) {
                                properties++;
                                if (check.getOwner() == player) {
                                    propertiesOwned++;
                                }
                            }
                        }
                    }

                    if (propertiesOwned == properties && this.amountOfHouses==0) {
                        int rentNow = currentRent() * 2;
                        owner.changeBalance(rentNow);
                        player.changeBalance(-rentNow);
                        gui.getMyGUI().showMessage(this.owner.getName() + Settings.gameHandlerText[55] + " " + rentNow);
                        gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                        gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                        ownable.setRent("Rent: "+rentNow);
                    } else {
                        int rentNow = currentRent();
                        owner.changeBalance(rentNow);
                        player.changeBalance(-rentNow);
                        gui.getMyGUI().showMessage(this.owner.getName() + Settings.gameHandlerText[55] + " " + rentNow);
                        gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
                        gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                    }
                }
            }
        }
    }

    @Override
    public void auction(Player player, Player[] players, GUIController gui) {
        super.auction(player, players, gui);
    }

    public int currentRent() {
        switch (this.amountOfHouses) {
            case 0:
                return rent;
            case 1:
                return rent1;
            case 2:
                return rent2;
            case 3:
                return rent3;
            case 4:
                return rent4;
            case 5:
                return rent5;
        }
        return 0;
    }

    public void buildHouse(Player player, GUIController gui) {
        if(this.amountOfHouses>=5){
            gui.getMyGUI().showMessage("You already have 5 houses there");
            return;
        }


        GUI_Street ownable = null;
        for (int i = 0; i < Settings.BOARD_SIZE; i++) {
            if (parent.getBoardAr()[i].getName().equals(this.name)) {
                ownable = (GUI_Street) gui.getMyGUI().getFields()[i];

            }

        }


        int properties = 0;
        int propertiesOwned = 0;
        FieldDeed[] series;

        for (int i = 0; i < 40; i++) {

            if (parent.getBoardAr()[i].getFieldType().equals("Property")) {
                FieldDeed check = (FieldDeed) parent.getBoardAr()[i];
                if (check.getPairNumber() == pairNumber) {
                    properties++;

                    if (check.getOwner() == player) {
                        propertiesOwned++;
                    }

                }
            }
        }
        if (propertiesOwned == properties) {
            series = new FieldDeed[properties];
            int arrCount = 0;
            for (int i = 0; i < 40; i++) {
                try {
                    FieldDeed temp = (FieldDeed) parent.getBoardAr()[i];
                    if (temp.pairnumber == this.pairnumber) {
                        series[arrCount] = temp;
                        arrCount++;

                    }


                } catch (Exception e) {

                }


            }
            int averagehouses = 0;
            for (int i = 0; i < series.length; i++) {
                averagehouses += series[i].amountOfHouses;

            }
            averagehouses = averagehouses/series.length;
            if (averagehouses >= this.amountOfHouses) {
                gui.getMyGUI().showMessage("You you now built one house for the price of: " + this.houseprice);
                player.changeBalance(-this.houseprice);
                gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());

                this.amountOfHouses++;
                if (this.amountOfHouses == 5) {
                    ownable.setHotel(true);

                } else {
                    ownable.setHouses(this.amountOfHouses);
                }

            } else {
                gui.getMyGUI().showMessage("You have to build evenly");
            }


        } else {
            gui.getMyGUI().showMessage("You do not have all the properties in that series");
        }
        ownable.setRent("the rent is now: "+currentRent());
    }


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getAmountOfHouses() {
        return amountOfHouses;
    }

    public void setAmountOfHouses(int amountOfHouses) {
        this.amountOfHouses = amountOfHouses;
    }

    public int getRent1() {
        return rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public int getRent3() {
        return rent3;
    }

    public int getRent4() {
        return rent4;
    }

    public int getRent5() {
        return rent5;
    }

    public int getHouseprice() {
        return houseprice;
    }

    public String toString() {
        return "This is the very nice " + this.name + ". It is a very nice place";
    }

}
