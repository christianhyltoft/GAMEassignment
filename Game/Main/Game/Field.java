public abstract class Field {
    protected String name;
    protected String Fieldtype;

    public Field(String name, String FieldType) {
        this.name = name;
        this.Fieldtype = FieldType;
    }

    public String getFieldtype() {
        return Fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.Fieldtype = fieldtype;
    }

    public String getName() {
        return name;
    }

    public void landOn(Player player, GUIController gui) {
        System.out.println(Fieldtype);


    }


}


