public class FieldStart extends Field{


    public FieldStart(String name, String FieldType){
        super(name, FieldType);
    }
    @Override
    public void landOn(Player player, GUIController gui){
        System.out.println("You landed on the field "+ name+"." + Fieldtype);
    }
}
