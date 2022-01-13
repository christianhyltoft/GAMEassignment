import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class SellGetoutofjailTest {

    @Test
    public void getoutofjailsellTest() throws IOException {
        GameHandler gtest = new GameHandler();
        gtest.getMyGUI().showMessage("Sell the getoutofjail card to the third player");
        gtest.getPlayers()[0].setEscapeJailCard(1);
        for (int i = 0; i < gtest.getPlayers().length-1; i++) {
            gtest.getPlayers()[i].setBalance(-10000);


        }
        gtest.playGame();


        assertEquals(0, gtest.getPlayers()[0].getEscapeJailCard());
        assertEquals(1, gtest.getPlayers()[2].getEscapeJailCard());

    }
}
