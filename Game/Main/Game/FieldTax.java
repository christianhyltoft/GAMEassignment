public class FieldTax extends Field{
    private final int taxAmount;
    private final int taxdecimal;


    public FieldTax(String name, String FieldType, int taxAmount, int taxdecimal){
        super(name, FieldType);
        this.taxAmount = taxAmount;
        this.taxdecimal=taxdecimal;
    }
    @Override
    public void landOn(Player player, GUIController gui){
        System.out.println("You landed on the field "+ name+"." + Fieldtype);

        if ((player.getBalance()*taxdecimal)/100>taxAmount){
            player.changeBalance((-player.getBalance()*taxdecimal)/100);
        }
        else {
            player.changeBalance(-taxAmount);
        }


    }
}
