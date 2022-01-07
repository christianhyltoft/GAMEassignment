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

}
