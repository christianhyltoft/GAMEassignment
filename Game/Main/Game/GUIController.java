import gui_fields.*;
import gui_main.GUI;


public class GUIController {

    final private GUI myGUI;
    final private GUI_Player[] myPlayers;

    GUIController(GUI myGUI, GUI_Player[] myPlayers) {
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
