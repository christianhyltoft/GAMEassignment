import gui_fields.GUI_Shipping;

import java.awt.*;

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
        if (this.owner != null)
            return;
        gui.getMyGUI().showMessage("This property is now up for auction");
        GUI_Shipping ownable = (GUI_Shipping) gui.getMyGUI().getFields()[player.getPosition()];

        String buyer = "";
        while (true) {
            buyer = gui.getMyGUI().getUserString("Figure out amongst yourselves who will buy the field and for what price and enter the player who wants to buy: ");
            for (int i = 0; i < players.length; i++) {
                if (players[i].getName().equals(buyer)) {
                    int price = gui.getMyGUI().getUserInteger("Name the price you bargained for");
                    this.owner = players[i];
                    players[i].changeBalance(-price);
                    gui.getMyPlayers()[players[i].getNumber()].setBalance(players[i].getBalance());
                    ownable.setOwnerName(buyer);
                    ownable.setBorder(gui.getMyPlayers()[players[i].getNumber()].getPrimaryColor(), Color.BLACK);
                    gui.getMyGUI().showMessage(players[i].getName() + " now owns this field");
                    return;

                }

            }
        }
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
