
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class Guitest {
    public static void main(String[] args) throws InterruptedException{
        //Test af guiens kommandoer
        GUI mygui=new GUI();
        GUI_Player p1= new GUI_Player("sten",200);
        GUI_Player p2= new GUI_Player("sten1",200);
        GUI_Player p3= new GUI_Player("sten2",200);
        GUI_Player p4= new GUI_Player("sten3",200);

        mygui.addPlayer(p1);
        mygui.addPlayer(p2);
        mygui.addPlayer(p3);
        mygui.addPlayer(p4);

        p1.getCar().setPosition(mygui.getFields()[0]);
        p1.getCar().setPrimaryColor(Color.blue);
        p2.getCar().setPosition(mygui.getFields()[0]);
        p3.getCar().setPosition(mygui.getFields()[0]);
        p4.getCar().setPosition(mygui.getFields()[0]);
        mygui.setDice(5,5);
        Thread.sleep(4000);

        p1.getCar().setPosition(mygui.getFields()[5]);
        p2.getCar().setPosition(mygui.getFields()[5]);
        p3.getCar().setPosition(mygui.getFields()[5]);
        p4.getCar().setPosition(mygui.getFields()[5]);
        GUI_Field field = mygui.getFields()[1];
        GUI_Ownable ownable = (GUI_Ownable) field;
        ownable.setOwnerName(p1.getName());
        mygui.showMessage("hattemand");
    }

}
