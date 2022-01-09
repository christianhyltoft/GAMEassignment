public class FieldStart extends Field{


    public FieldStart(String name, String message){
        super(name, message);
    }
    @Override
    public void landOn(Player player){
        System.out.println("You landed on the field "+ name+"." + message);
    }
}
