public class FieldChance extends Field{

    public FieldChance(String name, String FieldType, Board parent){
        super(name,FieldType, parent);
    }

    @Override
    public void landOn(Player player,GUIController gui){
        super.landOn(player,gui);
        gui.getMyGUI().showMessage("Pick a chance card");

        ChanceCard myCard = parent.getMyDeck().DrawCard();
    }

    @Override
    public String toString(){
        return "Lets test your luck... " + this.name;
    }
}
