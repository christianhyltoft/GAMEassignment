import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class GUI_Playerex extends GUI_Player {
    private Player player;


    public GUI_Playerex(String name) {
        super(name);
    }
    public GUI_Playerex(String name, int balance, Player player) {
        super(name, balance);
        this.player=player;
    }
    public GUI_Playerex(String name, int balance, GUI_Car car) {

        super(name, balance, car);
    }


}
