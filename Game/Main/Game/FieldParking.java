public class FieldParking extends Field{

    public FieldParking(String name, String FieldType) {
        super(name, FieldType);
    }
    @Override
    public void landOn(Player player, GUIController gui) {
        System.out.println(Fieldtype);


    }
    public String toString(){
        return "Congrats, you maneged to find the last spot at "+this.name;
    }
}
