public class FieldDeed extends FieldPurchaseAble {
    private int rent;
    private int amountOfHouses;
    private int bonusrentperHouse;
    private int totalrent;
    public FieldDeed(String name, String message, int buyprice,int mortgageValue, int rent, int bonusrentperHouse){
        super(name,message,buyprice,mortgageValue);
        this.rent=rent;
        this.bonusrentperHouse=bonusrentperHouse;
        this.totalrent=rent;
    }
    @Override
    public void landOn(Player player){
        totalrent=rent+bonusrentperHouse*amountOfHouses;
        super.landOn(player);
        player.changeBalance(rent+bonusrentperHouse*amountOfHouses);

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
        this.totalrent=rent+bonusrentperHouse*amountOfHouses;

    }

    public int getBonusrentperHouse() {
        return bonusrentperHouse;
    }

    public void setBonusrentperHouse(int bonusrentperHouse) {
        this.bonusrentperHouse = bonusrentperHouse;
    }

    public int getTotalrent() {
        return totalrent;
    }

    public void setTotalrent(int totalrent) {
        this.totalrent = totalrent;
    }
}
