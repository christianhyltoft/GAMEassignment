public class Player {

    private int balance;
    private String name;
    private static int playernumber = 0;
    private int number;

    private int position;
    private Field[] ownedFields;

    private boolean isJailed;
    private int turnsJailed;

    private int escapeJailCard;

    private boolean playerHasLost;

    Player(int balance, String name, int position) {
        this.balance = balance;
        this.name = name;
        this.position = position;
        this.number = playernumber;
        isJailed = false;
        turnsJailed = 0;
        escapeJailCard = 0;
        playernumber++;
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

    public void changeBalance(int change) {
        this.balance += change;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void changePosition(int move) {
        this.position += move;
        if (this.position >= Settings.BOARD_SIZE) {
            this.position -= 40;
        }
        else if(this.position < 0){
            this.position += 40;
        }
    }

    public boolean isJailed() {
        return isJailed;
    }

    public int getTurnsJailed() {
        return turnsJailed;
    }

    public int getEscapeJailCard() {
        return escapeJailCard;
    }

    public void setJailed(boolean jailed) {
        isJailed = jailed;
    }

    public void setTurnsJailed(int turnsJailed) {
        this.turnsJailed = turnsJailed;
    }

    public void setEscapeJailCard(int escapeJailCard) {
        this.escapeJailCard = escapeJailCard;
    }

    public boolean isPlayerHasLost() {
        return playerHasLost;
    }

    public void setPlayerHasLost(boolean playerHasLost) {
        this.playerHasLost = playerHasLost;
    }
}
