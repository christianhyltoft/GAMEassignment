import gui_fields.GUI_Player;
import gui_main.GUI;

public class Gamehandler {
    Board myboard;
    Player[] players;
    GUI mygui;
    int amountOfPlayers;
    GUI_Player[] playersgui;


    public Gamehandler() {
        GUI mygui = new GUI();
        this.amountOfPlayers = Integer.parseInt(mygui.getUserSelection("How many players do you want to play", "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        playersgui= new GUI_Player[this.amountOfPlayers];
        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = mygui.getUserString("Enter name of player: " + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i]= new GUI_Player(input,Settings.STARTING_MONEY);
            mygui.addPlayer(playersgui[i]);



        }




    }
    public void playGame(){

    }
    private void taketurn(){

    }
    private void detectLoser(){

    }

}
