public abstract class FieldPurchaseAble extends Field {
    protected Player owner;
    protected int buyprice;
    protected int mortgageValue;
    protected String messageowned;
    protected String messageunowned;

    public FieldPurchaseAble(String name, String message, int buyprice, int mortgageValue) {
        super(name, message);
        this.buyprice = buyprice;
    }


    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(int buyprice) {
        this.buyprice = buyprice;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);

    }
    public void mortgage(Player player){
        player.changeBalance(-mortgageValue);
    }
    public void buymortgagedproperty(Player player){
        player.changeBalance(mortgageValue);
    }
}
