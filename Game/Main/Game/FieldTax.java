public class FieldTax extends Field{
    private final int taxAmount;
    private final int taxdecimal;


    public FieldTax(String name, String message, int taxAmount, int taxdecimal){
        super(name, message);
        this.taxAmount = taxAmount;
        this.taxdecimal=taxdecimal;
    }
    @Override
    public void landOn(Player player){
        System.out.println("You landed on the field "+ name+"." + message);

        if ((player.getBalance()*taxdecimal)/100>taxAmount){
            player.changeBalance((-player.getBalance()*taxdecimal)/100);
        }
        else {
            player.changeBalance(-taxAmount);
        }


    }
}