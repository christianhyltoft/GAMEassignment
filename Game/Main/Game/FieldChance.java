public class FieldChance extends Field{

    private ChanceCard[] chanceDeck;

    public FieldChance(String name, String FieldType, Board parent){
        super(name,FieldType, parent);
    }

    public void getChanceDeck(ChanceCard[] chanceDeck) {
        this.chanceDeck = chanceDeck;
    }

    @Override
    public void landOn(Player player,GUIController gui){
        super.landOn(player,gui);

        chanceDeck = parent.getC;
        gui.getMyGUI().showMessage("Pick a chance card");

    }

    @Override
    public String toString(){
        return "Lets test your luck... " + this.name;
    }
}
