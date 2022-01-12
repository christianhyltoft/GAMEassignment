public abstract class FieldPurchaseAble extends Field {

    protected Player owner;

    protected int buyPrice;
    protected int mortgageValue;

    protected String messageOwned;
    protected String messageUnowned;

    protected final int pairNumber;

    public FieldPurchaseAble(String name, String FieldType, Board parent, int buyPrice, int mortgageValue, int pairNumber) {
        super(name, FieldType, parent);
        this.pairNumber = pairNumber;
        this.buyPrice = buyPrice;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getBuyprice() {
        return buyPrice;
    }

    public void setBuyprice(int buyprice) {
        this.buyPrice = buyprice;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);
    }

    @Override
    public void auction(Player player, Player[] players, GUIController gui) {

    }

    public void mortgage(Player player) {
        player.changeBalance(-mortgageValue);
    }

    public void buyMortgagedProperty(Player player) {
        player.changeBalance(mortgageValue);
    }

    public int getPairNumber() {
        return pairNumber;
    }
}
