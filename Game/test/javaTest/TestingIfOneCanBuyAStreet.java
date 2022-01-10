import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

public class TestingIfOneCanBuyAStreet {

    @Test
    public void Test() throws IOException {
        Gamehandler g2= new Gamehandler();
        g2.getPlayers()[1].setPosition(3);
        g2.getMyGUI().showMessage("Press yes when you are asked to but the deed");
        g2.getMyboard().getBoardAr()[3].landOn(g2.getPlayers()[1],g2.getController());
        FieldDeed ftest= (FieldDeed) g2.getMyboard().getBoardAr()[3];

        assertTrue(ftest.getOwner()==g2.getPlayers()[1]);
    }
}
