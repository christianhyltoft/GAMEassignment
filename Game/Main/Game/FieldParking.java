public class FieldParking extends Field{

    public FieldParking(String name, String FieldType) {
        super(name, FieldType);
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        System.out.println(Fieldtype);
    }

    public String toString(){
        return "Here at " + this.name + " you might get lucky with the last parking spot";
    }
}
