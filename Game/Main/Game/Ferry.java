public class Ferry extends PurchaseableField{
    private int rent;

    public Ferry(String name, String message, int buyprice, int rent){
        super(name,message,buyprice);
        this.rent=rent;
    }


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
    @Override
    public void landOn(Player player){
        super.landOn(player);
        player.changeBalance(rent);

    }
}
