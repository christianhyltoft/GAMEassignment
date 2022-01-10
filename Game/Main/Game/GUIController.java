import gui_fields.GUI_Player;
import gui_main.GUI;

public class GUIController {

    GUI myGUI;
    GUI_Player[] myPlayers;

    GUIController(GUI myGUI, GUI_Player[] myPlayers){
        this.myGUI = myGUI;
        this.myPlayers = myPlayers;
    }

    public GUI getMyGUI() {
        return myGUI;
    }

    public GUI_Player[] getMyPlayers() {
        return myPlayers;
    }
}
