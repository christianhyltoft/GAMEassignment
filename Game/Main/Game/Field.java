//The parent class to all the fields which are used in this game.
public abstract class Field {
    //The two values used in all fields the name and the type.
    //Here fieldType is crucial since you can use .class() method, but It's still nice to have the type as a string.
    protected String name;
    protected String fieldType;
    //Each field having access to the board makes finding other fields in the land on method possible
    protected Board parent;

    public Field(String name, String FieldType, Board parent) {
        this.name = name;
        this.fieldType = FieldType;
        this.parent = parent;
    }

    //Methods used in all fields for what happens when the player lands on a given field
    public void landOn(Player player, GUIController gui) {
        gui.getMyGUI().showMessage(Settings.gameHandlerText[46] + this.name);
    }

    //Auction method in the parent class even though it should probably first be defined in PurchaseAbleField.
    //But when defining it here we do not have to typecast and can instead check for type.
    public void auction(Player player, Player[] players, GUIController gui) {
    }


    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getName() {
        return name;
    }


    public String toString() {
        return Settings.gameHandlerText[46] + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}


