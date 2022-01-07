public abstract class PurchaseableField extends Field {
    protected Player owner;
    protected int buyprice;

    public PurchaseableField(String name, String message, int buyprice) {
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
    public void landOn() {

    }
}
