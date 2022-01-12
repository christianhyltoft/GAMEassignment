public class FieldJail extends Field{

    public FieldJail(String name, String FieldType, Board parent){
        super(name, FieldType, parent);
    }

    @Override
    public void landOn(Player player, GUIController gui){

    }

    public String toString(){
        return "You wouldnt wanna go to " + this.name + " trust me...";
    }

}
