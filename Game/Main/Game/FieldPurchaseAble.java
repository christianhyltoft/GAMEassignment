import gui_fields.GUI_Ownable;
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
        gui.getMyGUI().showMessage(Settings.gameHandlerText[64]);
        GUI_Shipping ownable = (GUI_Shipping) gui.getMyGUI().getFields()[player.getPosition()];

        String buyer = "";
        while (true) {
            buyer = gui.getMyGUI().getUserString(Settings.gameHandlerText[65]);
            for (int i = 0; i < players.length; i++) {
                if (players[i].getName().equals(buyer)) {
                    int price = gui.getMyGUI().getUserInteger(Settings.gameHandlerText[66]);
                    this.owner = players[i];
                    players[i].changeBalance(-price);
                    gui.getMyPlayers()[players[i].getNumber()].setBalance(players[i].getBalance());
                    ownable.setOwnerName(buyer);
                    ownable.setBorder(gui.getMyPlayers()[players[i].getNumber()].getPrimaryColor(), Color.BLACK);
                    gui.getMyGUI().showMessage(players[i].getName() + Settings.gameHandlerText[67]);
                    return;

                }

            }
        }
    }

    public void sell(Player player, Player[] players, GUIController gui) {
        gui.getMyGUI().showMessage(Settings.gameHandlerText[74] +player.getName());
        GUI_Ownable ownable;
        for (int i = 0; i < gui.getMyGUI().getFields().length; i++) {
            if (gui.getMyGUI().getFields()[i].getTitle().equals(this.name)) {
                ownable = (GUI_Ownable) gui.getMyGUI().getFields()[i];
                String buyer = gui.getMyGUI().getUserString(Settings.gameHandlerText[75]);
                for (int j = 0; j < players.length; j++) {
                    if (players[j].getName().equals(buyer)){
                        int price=gui.getMyGUI().getUserInteger(Settings.gameHandlerText[76]);
                        this.owner.changeBalance(price);
                        gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                        this.owner=players[j];
                        this.owner.changeBalance(-price);
                        gui.getMyPlayers()[this.owner.getNumber()].setBalance(this.owner.getBalance());
                        ownable.setBorder(gui.getMyPlayers()[j].getPrimaryColor(), Color.black);

                    }


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
