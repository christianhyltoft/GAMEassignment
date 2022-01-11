public class FieldChance extends Field{
    public FieldChance(String name, String FieldType){
        super(name,FieldType);


    }
    @Override
    public void landOn(Player player,GUIController gui){
        super.landOn(player,gui);
        gui.getMyGUI().showMessage("Pick a chance card");

    }



    @Override
    public String toString(){
        return "Lets test your luck... "+this.name;
    }
}
