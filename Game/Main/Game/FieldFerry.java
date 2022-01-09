public class FieldFerry extends FieldPurchaseAble {
    private int rent;

    public FieldFerry(String name, String message, int buyprice,int moortgageValue, int rent){
        super(name,message,buyprice,moortgageValue);
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
        if (owner == null) {
            String yesno = "";
            //GUI skal spørge om man vil købe grunden eller ej

            if (yesno.equals("yes")) {
                setOwner(player);
                player.changeBalance(-buyprice);
            }

        } else {

            if (player == owner) {
                //Udskriv message+messageowned til GUI
            }
            else {
                owner.changeBalance(rent);
                player.changeBalance(-rent);
            }
        }

    }
}
