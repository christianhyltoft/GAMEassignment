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
                if(players[i].isJailed()){
                    JailTurn(players[i]);
                }
                else{
                    roll(players[i]);
                }
            }


        } while (true);

    }

    private void JailTurn(Player player){
        myGUI.showMessage("You are jailed" + player.getName());
        if(player.getTurnsJailed() >= 2){
            myGUI.showMessage("You've served your jail sentence and are now released" + player.getName());
            player.setJailed(false);
            player.setTurnsJailed(0);
            roll(player);
        }
        else if(player.getEscapeJailCard() >= 1){
            myGUI.showMessage("You use your get out of jail free card to escape jail" + player.getName());
            player.setEscapeJailCard(player.getEscapeJailCard() - 1);
            player.setJailed(false);
            player.setTurnsJailed(0);
            roll(player);
        }
        else{
            myGUI.showMessage("Roll a pair to escape" + player.getName());
            rafflecup.roll();
            myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());

            if((rafflecup.getCup()[0].getValue() == rafflecup.getCup()[1].getValue())){
                myGUI.showMessage("You've rolled a pair and have escaped" + player.getName());
                player.setJailed(false);
                player.setTurnsJailed(0);
                taketurn(player, rafflecup);
            }
            else{
                myGUI.showMessage("You failed to roll a pair and will stay in jail" + player.getName());
                player.setTurnsJailed(player.getTurnsJailed() + 1);
            }
        }
    }

    private void roll(Player player){
        myGUI.showMessage("Roll the dice " + player.getName());
        rafflecup.roll();
        myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());
        taketurn(player, rafflecup);
    }

    private void taketurn(Player player, Rafflecup rafflecup) {
        myGUI.showMessage("Move your car " + player.getName());
        int positionFromTurnBefore = player.getPosition();
        player.changePosition(rafflecup.sum());

        playersgui[player.getNumber()].getCar().setPosition(myGUI.getFields()[player.getPosition()]);
        if (player.getPosition()<positionFromTurnBefore){
            myGUI.showMessage("You have passed START, and will therefore receive 4000 kr." + player.getName());
            player.changeBalance(4000);
            playersgui[player.getNumber()].setBalance(player.getBalance());
        }
        this.myboard.getBoardAr()[player.getPosition()].landOn(player, this.controller);
        if (this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Property") || this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Ferry")||this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Beverage")){
            this.myboard.getBoardAr()[player.getPosition()].auction(player,this.players,this.controller);

        }


        if (rafflecup.sameFacesUpOnAllDice()) {
            myGUI.showMessage("You rolled two of a kind and now therefore get another turn" + player.getName());
            roll(player);
        }


    }


    private boolean detectLoser(Player players) {
        //En metode der tjekker når man har tabt spillet. Hvis en spiller har under 0 kr i spillet skal der vurderes at spilleren har tabt.
        if (players.getBalance() < 0) {
            players = null;
            this.controller.getMyGUI().showMessage(players.getName() + " has lost the game.");
            return true;

        }
        return false;
    }

    //private boolean detectWinner (){
    //}


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
