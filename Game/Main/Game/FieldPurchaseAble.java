public abstract class FieldPurchaseAble extends Field {
    protected Player owner;
    protected int buyprice;
    protected int mortgageValue;

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
    public void landOn(Player player) {
        super.landOn(player);

    }
}
