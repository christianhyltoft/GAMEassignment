public abstract class Field {
    protected String name;
    protected String message;

    public Field(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void landOn(Player player, GUIController gui) {
        System.out.println(message);


    }


}


