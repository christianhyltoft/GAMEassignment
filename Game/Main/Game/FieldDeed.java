public class FieldDeed extends FieldPurchaseAble {
    int rent;
    int amountOfHouses;
    int bonusrentperHouse;
    public FieldDeed(String name, String message, int buyprice, int rent, int bonusrentperHouse){
        super(name,message,buyprice);
        this.rent=rent;
        this.bonusrentperHouse=bonusrentperHouse;
    }
    @Override
    public void landOn(Player player){
        System.out.println(message);
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
    }

    public int getBonusrentperHouse() {
        return bonusrentperHouse;
    }

    public void setBonusrentperHouse(int bonusrentperHouse) {
        this.bonusrentperHouse = bonusrentperHouse;
    }
}
