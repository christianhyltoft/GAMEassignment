import gui_fields.GUI_Ownable;
import gui_fields.GUI_Shipping;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
        GUI_Ownable auctionField = (GUI_Ownable) gui.getMyGUI().getFields()[player.getPosition()];

        LinkedList<Player> biddingPlayers = new LinkedList<Player>();

        for(int i = 0; i < players.length; i++){
            if(players[i] != player){
                biddingPlayers.add(players[i]);
            }
        }

        int price = 0;
        Player highestBidder = null;
        ListIterator<Player> myIterator = biddingPlayers.listIterator();
        while(true){
            Player bidder = null;
            if(!myIterator.hasNext()){
                while(myIterator.hasPrevious()){
                    myIterator.previous();
                }
            }

            bidder = myIterator.next();

            if(bidder == highestBidder){
                gui.getMyGUI().showMessage(bidder.getName() + Settings.gameHandlerText[82]);
                break;
            }

            int playerBid = Integer.parseInt(gui.getMyGUI().getUserString(bidder.getName() +  Settings.gameHandlerText[83] + " " + price));
            if(playerBid < price){
                gui.getMyGUI().showMessage(bidder.getName() + " " + Settings.gameHandlerText[84]);
                myIterator.remove();
            }
            else{
                highestBidder = bidder;
                price = playerBid;
            }
        }

        highestBidder.changeBalance(-price);
        gui.getMyPlayers()[highestBidder.getNumber()].setBalance(highestBidder.getBalance());
        this.owner = highestBidder;
        auctionField.setOwnerName(highestBidder.getName());
        auctionField.setBorder(gui.getMyPlayers()[highestBidder.getNumber()].getPrimaryColor(), Color.BLACK);
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
