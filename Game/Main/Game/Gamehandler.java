import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.io.IOException;

public class Gamehandler {
    private Board myboard;
    private Player[] players;
    private int amountOfPlayers;

    private GUI myGUI = new GUI(Settings.fields);
    private GUI_Player[] playersgui;

    private Rafflecup rafflecup = new Rafflecup(2, 6);

    private GUIController controller;

    public Rafflecup getRafflecup() {
        return rafflecup;
    }

    public Gamehandler() throws IOException {
        Color[] carcolors = new Color[]{Color.CYAN, Color.MAGENTA, Color.PINK, Color.BLUE, Color.GREEN, Color.ORANGE};
        this.amountOfPlayers = Integer.parseInt(myGUI.getUserSelection("How many players do you want to play", "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        playersgui = new GUI_Player[this.amountOfPlayers];

        myboard = new Board(this);

        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = myGUI.getUserString("Enter name of player: " + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i] = new GUI_Player(input, Settings.STARTING_MONEY);
            playersgui[i].getCar().setPrimaryColor(carcolors[i]);
            myGUI.addPlayer(playersgui[i]);
            playersgui[i].getCar().setPosition(myGUI.getFields()[0]);
        }
        for (int i = 0; i < myGUI.getFields().length; i++) {
            myGUI.getFields()[i].setDescription(myboard.getBoardAr()[i].toString());

        }
        controller = new GUIController(myGUI, playersgui);

        myGUI.showMessage("The game will start when you press ok");
    }

    public void playGame() {
        do {
            for (int i = 0; i < players.length; i++) {
                if (!players[i].isPlayerHasLost()) {
                    if (players[i].isJailed()) {
                        JailTurn(players[i]);
                    } else {
                        roll(players[i]);
                    }
                    detectLoser(players[i]);
                }
            }


        } while (detectWinner());
        //Looking for the winner of the game
        for (int i = 0; i < players.length; i++) {
            if (!players[i].isPlayerHasLost())
                getMyGUI().showMessage("Player: " + players[i].getName() + " has won the game");

        }

    }

    private void JailTurn(Player player) {
        myGUI.showMessage("You are jailed " + player.getName());
        if (player.getTurnsJailed() >= 2) {
            myGUI.showMessage("You've served your jail sentence and are now released after paying " + Settings.JAIL_RELEASE_FEE + player.getName());
            player.changeBalance(-1000);
            playersgui[player.getNumber()].setBalance(player.getBalance());
            player.setJailed(false);
            player.setTurnsJailed(0);
            roll(player);
        } else {
            String Choice = "";
            if(player.getEscapeJailCard() >= 1 && player.getBalance() >= Settings.JAIL_RELEASE_FEE){
                Choice = myGUI.getUserSelection("Choose whether to try and roll, use a get out of jail free card, or pay " + Settings.JAIL_RELEASE_FEE, "Roll", "Pay", "Card");
            }
            else if(player.getEscapeJailCard() >= 1){
                Choice = myGUI.getUserSelection("Choose whether to try and roll or use a get out of jail free card", "Roll", "Card");
            }
            else if(player.getBalance() >= Settings.JAIL_RELEASE_FEE){
                Choice = myGUI.getUserSelection("Choose whether to try and roll or pay " + Settings.JAIL_RELEASE_FEE, "Roll", "Pay");
            }


            if(Choice.equals("Pay")){
                myGUI.showMessage("You've bribed the officials to be released, you pay " + Settings.JAIL_RELEASE_FEE + " " + player.getName());
                player.changeBalance(-1000);
                playersgui[player.getNumber()].setBalance(player.getBalance());
                player.setJailed(false);
                player.setTurnsJailed(0);
                roll(player);
            }
            if(Choice.equals("Card")){
                myGUI.showMessage("You use your get out of jail free card to escape jail " + player.getName());
                player.setEscapeJailCard(player.getEscapeJailCard() - 1);
                player.setJailed(false);
                player.setTurnsJailed(0);
                roll(player);
            }
            else{
                myGUI.getUserButtonPressed("Roll a pair to escape " + player.getName(),"ROLL");
                rafflecup.roll();
                myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());

                if ((rafflecup.getCup()[0].getValue() == rafflecup.getCup()[1].getValue())) {
                    myGUI.showMessage("You've rolled a pair and have escaped " + player.getName());
                    player.setJailed(false);
                    player.setTurnsJailed(0);
                    taketurn(player, rafflecup);
                } else {
                    myGUI.showMessage("You failed to roll a pair and will stay in jail " + player.getName());
                    player.setTurnsJailed(player.getTurnsJailed() + 1);
                }
            }
        }
    }

    private void roll(Player player) {
        myGUI.getUserButtonPressed("Roll the dice " + player.getName(),"ROLL");
        rafflecup.roll();
        myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());
        taketurn(player, rafflecup);
    }

    private void taketurn(Player player, Rafflecup rafflecup) {
        myGUI.showMessage("Move your car " + player.getName());
        int positionFromTurnBefore = player.getPosition();
        player.changePosition(rafflecup.sum());

        playersgui[player.getNumber()].getCar().setPosition(myGUI.getFields()[player.getPosition()]);
        if (player.getPosition() < positionFromTurnBefore) {
            myGUI.showMessage("You have passed START, and will therefore receive 4000 kr " + player.getName());
            player.changeBalance(4000);
            playersgui[player.getNumber()].setBalance(player.getBalance());
        }
        this.myboard.getBoardAr()[player.getPosition()].landOn(player, this.controller);
        if (this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Property") || this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Ferry") || this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Beverage")) {
            this.myboard.getBoardAr()[player.getPosition()].auction(player, this.players, this.controller);

        }

        if (rafflecup.sameFacesUpOnAllDice()) {
            myGUI.showMessage("You rolled two of a kind and now therefore get another turn " + player.getName());
            roll(player);
        }

        EndOfTurnChoice(player);
    }

    private void EndOfTurnChoice(Player myPlayer){
        String choice = "Invalid";
        while(choice.equals("Invalid"){
            choice = GetChoice(myPlayer);
        }
    }

    private String GetChoice(Player myPlayer){
        String choice =  myGUI.getUserSelection("Your turn is about to end " + myPlayer.getName() + ". Pick a miscellaneous action to perform ", "Sell a property", "Pawn a property", "Sell GetOutOfJail card", "Build");

        Boolean check = false;

        if(choice.equals("Sell a property") || choice.equals("Pawn a property")){
            for(int i = 0; i < Settings.BOARD_SIZE; i++)
            if(myboard.getBoardAr()[i].getFieldtype().matches("Property|Ferry|Beverage")){
                FieldPurchaseAble playerOwnerCheck = (FieldPurchaseAble) myboard.getBoardAr()[i];
                if(playerOwnerCheck.getOwner() == myPlayer){
                    check = true;
                    break;
                }
            }
        }
        else if(choice.equals("Sell GetOutOfJail card")){
            if(myPlayer.getEscapeJailCard() >= 1){
                check = true;
            }
        }

        if(!check){
            return "Invalid";
        }
        else{
            return choice;
        }
    }


    private boolean detectLoser(Player players) {
        //En metode der tjekker når man har tabt spillet. Hvis en spiller har under 0 kr i spillet skal der vurderes at spilleren har tabt.
        if (players.getBalance() < 0) {
            players.setPlayerHasLost(true);
            this.controller.getMyGUI().showMessage(players.getName() + " has lost the game.");
            return true;

        }
        return false;
    }

    private boolean detectWinner() {
        int playersRemaining = this.players.length;
        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isPlayerHasLost())
                playersRemaining--;

        }
        return !(playersRemaining == 1);

    }


    public Board getMyboard() {
        return myboard;
    }

    public void setMyboard(Board myboard) {
        this.myboard = myboard;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public GUI getMyGUI() {
        return myGUI;
    }

    public void setMyGUI(GUI myGUI) {
        this.myGUI = myGUI;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    public GUI_Player[] getPlayersgui() {
        return playersgui;
    }

    public void setPlayersgui(GUI_Player[] playersgui) {
        this.playersgui = playersgui;
    }


    public GUIController getController() {
        return controller;
    }

    public void setController(GUIController controller) {
        this.controller = controller;
    }
}
