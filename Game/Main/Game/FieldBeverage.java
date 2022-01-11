public class FieldBeverage extends FieldPurchaseAble {
    private int rollAmount;
    private int ownedAmount;
    public FieldBeverage(String name, String FieldType, Board parent, int buyprice, int mortgageValue) {
        super(name, FieldType, parent, buyprice, mortgageValue);
        this.rollAmount = rollAmount;
        this.ownedAmount = ownedAmount;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

        if (owner == null) {
            String yesno = "";
            //GUI skal spørge om man vil købe grunden eller ej

            if (yesno.equals("yes")) {
                setOwner(player);
                player.changeBalance(-buyPrice);
            }

        } else {

            if (player == owner) {
                //Udskriv message+messageowned til GUI
            } else {

            }
        }

    }
    @Override
    public String toString(){
        return "This is a danish classic, come and try a "+this.name+" and enjoy";
    }



}
