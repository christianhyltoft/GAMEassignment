public class FieldBeverage extends FieldPurchaseAble {
    private int rollAmount;
    private int ownedAmount;
    public FieldBeverage(String name, String message, int buyprice, int mortgageValue) {
        super(name, message, buyprice, mortgageValue);
        this.rollAmount = rollAmount;
        this.ownedAmount = ownedAmount;
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

            }
        }

    }


}
