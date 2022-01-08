public class FieldDeed extends FieldPurchaseAble {
    private int rent;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int rent5;
    private int mortgagevalue;

    private int amountOfHouses;

    public FieldDeed(String name, String message, int buyprice,int mortgageValue, int rent, int bonusrentperHouse){
        super(name,message,buyprice,mortgageValue);
        this.rent=rent;

    }
    @Override
    public void landOn(Player player){
        super.landOn(player);
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

}
