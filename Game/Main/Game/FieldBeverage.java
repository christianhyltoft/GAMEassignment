public class FieldBeverage extends FieldPurchaseAble {
    private int rollAmount;
    private int ownedAmount;
    private int rent;
    public FieldBeverage(String name, String message, int buyprice, int mortgageValue) {
        super(name, message, buyprice, mortgageValue);
        this.rollAmount = rollAmount;
        this.ownedAmount = ownedAmount;
        this.rent = rent;
    }

    @Override
    public void landOn(Player player) {
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
            } else {
                owner.changeBalance(rent);
                player.changeBalance(-rent);

            }
        }

    }


}
