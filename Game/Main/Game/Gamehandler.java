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
        Color[] carcolors = new Color[]{Color.cyan, Color.MAGENTA, Color.PINK};
        this.amountOfPlayers = Integer.parseInt(myGUI.getUserSelection("How many players do you want to play", "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        playersgui = new GUI_Player[this.amountOfPlayers];
        myboard = new Board();
        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = myGUI.getUserString("Enter name of player: " + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i] = new GUI_Player(input, Settings.STARTING_MONEY);
            myGUI.addPlayer(playersgui[i]);
            playersgui[i].getCar().setPosition(myGUI.getFields()[0]);


        }
        for (int i = 0; i < myGUI.getFields().length; i++) {
            myGUI.getFields()[i].setDescription(myboard.getBoardAr()[i].toString());

        }
        controller = new GUIController(myGUI, playersgui);

        myGUI.showMessage("The game vil start when you press ok");
    }


    public void playGame() {
        do {
            for (int i = 0; i < players.length; i++) {
                taketurn(players[i]);

            }


        } while (true);

    }

    private void taketurn(Player player) {
        myGUI.showMessage("Roll the dice");
        rafflecup.roll();
        player.changePosition(rafflecup.sum());
        myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());
        myGUI.showMessage("Move your car: ");
        playersgui[player.getNumber()].getCar().setPosition(myGUI.getFields()[player.getPosition()]);
        this.myboard.getBoardAr()[player.getPosition()].landOn(player, controller);

        if (rafflecup.sameFacesUpOnAllDice()) {
            myGUI.showMessage("You rolled to of a kind and now therefore get another turn");
            taketurn(player);
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
