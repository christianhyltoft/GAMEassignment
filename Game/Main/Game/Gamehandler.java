import gui_fields.GUI_Player;
import gui_main.GUI;
import java.util.Scanner;

public class Gamehandler {
    Board myboard;
    Player[] players;
    GUI mygui;
    int playerCount;
    Scanner input = new Scanner(System.in);


    public Gamehandler() {
        GUI mygui=new GUI();
        playerCount = input.nextInt();
        while (playerCount<3 && playerCount>6){
            System.out.println("Wrong amount of players");
            playerCount = input.nextInt();
        }
        for (int i = 0; i < playerCount; i++) {

        }


        GUI_Player p1= new GUI_Player("sten",30000);
        GUI_Player p2= new GUI_Player("sten1",30000);
        GUI_Player p3= new GUI_Player("sten2",30000);
        GUI_Player p4= new GUI_Player("sten3",30000);
        mygui.addPlayer(p1);
        mygui.addPlayer(p2);
        mygui.addPlayer(p3);
        mygui.addPlayer(p4);

    }
}
