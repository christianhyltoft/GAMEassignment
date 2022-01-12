import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SellGetoutofjailTest {

    @Test
    public void getoutofjailsellTest() throws IOException {
        Gamehandler gtest= new Gamehandler();
        gtest.getPlayers()[0].setEscapeJailCard(1);
        gtest.Playgame();

    }
}
