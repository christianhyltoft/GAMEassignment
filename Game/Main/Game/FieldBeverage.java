public class FieldBeverage extends FieldPurchaseAble {
    private int rollAmount;
    private int ownedAmount;
    public FieldBeverage(String name, String FieldType, int buyprice, int mortgageValue) {
        super(name, FieldType, buyprice, mortgageValue);
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
                player.changeBalance(-buyprice);
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
        return "You are feeling very thirsty and need a break. Take a "+this.name+" and enjoy";
    }



}
