import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.Scanner;

public class Gamehandler {
    Board myboard;
    Player[] players;
    GUI mygui;
    int playerCount;
    GUI_Player[] playersgui;


    public Gamehandler() {
        GUI mygui = new GUI();
        int amountOfPlayers = Integer.parseInt(mygui.getUserSelection("How many players do you want to play", "3", "4", "5", "6"));
        players = new Player[amountOfPlayers];
        playersgui= new GUI_Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            String input = mygui.getUserString("Enter name of player" + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i]= new GUI_Player(input,Settings.STARTING_MONEY);
            mygui.addPlayer(playersgui[i]);



        }




    }
}
