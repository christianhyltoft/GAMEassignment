public class Player {

    //These values are the standard information about a player, the static variable is used for numerating players correctly.
    private int balance;
    private String name;
    private static int playerNumber = 0;
    final private int number;
    //This value is used as more game specific values. like the players position
    private int position;
    private Field[] ownedFields;
    //These to values are used to describe the players jail situation and handle the rule of only being able to be jailed for three turns
    private boolean isJailed;
    private int turnsJailed;
    //This values responsibility is to keep track of the amount of get out of jail card the player has
    private int escapeJailCard;
    //This value tracks whether a player has lost or not
    private boolean playerHasLost;

    // Constructor with the standard information and initialising other variables
    Player(int balance, String name, int position) {
        this.balance = balance;
        this.name = name;
        this.position = position;
        this.number = playerNumber;
        isJailed = false;
        turnsJailed = 0;
        escapeJailCard = 0;
        playerNumber++;
    }

    //Method that changes the players current balance with an integer
    public void changeBalance(int change) {
        this.balance += change;
    }

    //Game specific method chaining position based on board length.
    //This method is responsible for avoiding array out of by making sure the players position is always confined within the boards' length.
    public void changePosition(int move) {
        this.position += move;
        if (this.position >= Settings.BOARD_SIZE) {
            this.position -= 40;
        } else if (this.position < 0) {
            this.position += 40;
        }
    }

    //Standard getters and setters used throughout the program
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

    public int getNumber() {
        return number;
    }

    public Field[] getOwnedFields() {
        return ownedFields;
    }

    public void setOwnedFields(Field[] ownedFields) {
        this.ownedFields = ownedFields;
    }
}
