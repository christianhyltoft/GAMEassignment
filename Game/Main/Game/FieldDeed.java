public class FieldDeed extends FieldPurchaseAble {
    private int rent;
    private final int rent1;
    private final int rent2;
    private final int rent3;
    private final int rent4;
    private final int rent5;
    private final int houseprice;

    private int amountOfHouses;

    public FieldDeed(String name, String FieldType, int buyprice, int mortgageValue, int rent, int rent1, int rent2, int rent3, int rent4, int rent5, int houseprice) {
        super(name, FieldType, buyprice, mortgageValue);
        this.rent = rent;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rent5 = rent5;
        this.amountOfHouses = 0;
        this.houseprice=houseprice;



    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        if (owner == null) {
            //GUI skal spørge om man vil købe grunden eller ej


            if (true) {
                setOwner(player);
                player.changeBalance(-this.buyprice);

            }

        } else {

            if (player == owner) {



            } else {

                int rentNow=currentRent();
                        owner.changeBalance(rentNow);
                player.changeBalance(-rentNow);


            }
        }

    }

    public int currentRent() {
        switch (amountOfHouses) {
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


}
