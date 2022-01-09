public class FieldJail extends Field{


    public FieldJail(String name, String message){
        super(name, message);
    }
    @Override
    public void landOn(Player player){
        System.out.println("You landed on the field "+ name+"." + message);
    }


}
