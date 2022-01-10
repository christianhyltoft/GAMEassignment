import gui_fields.GUI_Player;
import gui_main.GUI;

import java.io.IOException;

public class Gamehandler {
   private Board myboard;
   private Player[] players;
   private static GUI mygui;
   private int amountOfPlayers;
   private static GUI_Player[] playersgui;



    public Gamehandler() throws IOException {
        GUI mygui = new GUI();
        this.amountOfPlayers = Integer.parseInt(mygui.getUserSelection("How many players do you want to play", "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        playersgui = new GUI_Player[this.amountOfPlayers];
        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = mygui.getUserString("Enter name of player: " + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i] = new GUI_Player(input, Settings.STARTING_MONEY);
            mygui.addPlayer(playersgui[i]);
            myboard = new Board();


        }


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

    private void detectLoser() {

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
