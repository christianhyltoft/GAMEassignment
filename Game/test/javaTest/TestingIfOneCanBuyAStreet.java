import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

public class TestingIfOneCanBuyAStreet {

    @Test
    public void Test() throws IOException {
        GameHandler g2= new GameHandler();
        g2.getPlayers()[1].setPosition(3);
        g2.getMyGUI().showMessage("Press yes when you are asked to but the deed");
        g2.getmyBoard().getBoardAr()[3].landOn(g2.getPlayers()[1],g2.getController());
        FieldDeed ftest= (FieldDeed) g2.getmyBoard().getBoardAr()[3];

        assertTrue(ftest.getOwner()==g2.getPlayers()[1]);


    }
}
