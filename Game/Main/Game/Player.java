public class Player {

    private int balance;
    private String name;

    private int position;
    private Field[] ownedFields;

    Player(int balance, String name, int position) {
        this.balance = balance;
        this.name = name;
        this.position = position;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Field[] getOwnedFields() {
        return ownedFields;
    }

    public void setOwnedFields(Field[] ownedFields) {
        this.ownedFields = ownedFields;
    }
    public void changeBalance(int change){
        this.balance+=change;
    }
}
