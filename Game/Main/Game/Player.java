public class Player {

    int balance;
    String name;

    int position;
    Field[] ownedFields;

    Player(int balance, String name, int position){
        this.balance = balance;
        this.name = name;
        this.position = position;
    }
}
