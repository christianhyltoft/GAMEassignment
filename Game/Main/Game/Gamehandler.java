import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.io.IOException;

public class Gamehandler {
    private Board myboard;
    private Player[] players;
    private static GUI mygui;
    private int amountOfPlayers;
    private static GUI_Player[] playersgui;
    GUIController controller;


    public Gamehandler() throws IOException {
        GUI mygui = new GUI();
        this.amountOfPlayers = Integer.parseInt(mygui.getUserSelection("How many players do you want to play", "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        playersgui = new GUI_Player[this.amountOfPlayers];
        myboard = new Board();
        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = mygui.getUserString("Enter name of player: " + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i] = new GUI_Player(input, Settings.STARTING_MONEY);
            mygui.addPlayer(playersgui[i]);
            playersgui[i].getCar().setPosition(mygui.getFields()[0]);


        }
        controller = new GUIController(mygui, playersgui);
        GUI_Ownable ownable = (GUI_Ownable) mygui.getFields()[1];

        mygui.showMessage("The game vil start when you press ok");
    }

    public void playGame() {
        do {
            for (int i = 0; i < players.length; i++) {
                taketurn(players[i]);

            }


        } while (true);

    }

    private void taketurn(Player player) {


    }

    private boolean detectLoser(Player players) {
        //En metode der tjekker når man har tabt spillet. Hvis en spiller har under 0 kr i spillet skal der vurderes at spilleren har tabt.
        if (players.getBalance() < 0) {
            players = null;
            this.controller.getMyGUI().showMessage(players.getName()+" has lost the game.");
            return true;

        }
        return false;
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

    public static GUI getMygui() {
        return mygui;
    }

    public static void setMygui(GUI mygui) {
        Gamehandler.mygui = mygui;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    public static GUI_Player[] getPlayersgui() {
        return playersgui;
    }

    public static void setPlayersgui(GUI_Player[] playersgui) {
        Gamehandler.playersgui = playersgui;
    }
}
