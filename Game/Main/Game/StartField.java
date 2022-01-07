public class StartField extends Field{
    public String name;
    public String message;

    public StartField (String name, String message){
        super(name, message);
    }
    @Override
    public void landOn(Player player){
        System.out.println("You landed on the field "+ name+"." + message);
    }
}
