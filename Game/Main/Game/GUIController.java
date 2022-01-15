import gui_fields.*;
import gui_main.GUI;

// Class used for passing both the GUI and the GUI_player
public class GUIController {

    final private GUI myGUI;
    final private GUI_Player[] myPlayers;

    GUIController(GUI myGUI, GUI_Player[] myPlayers) {
        this.myGUI = myGUI;
        this.myPlayers = myPlayers;
    }


    // Standard getters no setters since the variables are final
    public GUI getMyGUI() {
        return myGUI;
    }

    public GUI_Player[] getMyPlayers() {
        return myPlayers;
    }

}
