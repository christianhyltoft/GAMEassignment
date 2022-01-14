import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FerryTest {

    @Test
    public void ferrytest() throws IOException {
        GameHandler gferry = new GameHandler();
        gferry.getPlayers()[0].setPosition(5);
        gferry.getmyBoard().getBoardAr()[5].landOn(gferry.getPlayers()[0], gferry.getController());
        gferry.getPlayers()[0].setPosition(15);
        gferry.getmyBoard().getBoardAr()[15].landOn(gferry.getPlayers()[0], gferry.getController());
        gferry.getPlayers()[0].setPosition(25);
        gferry.getmyBoard().getBoardAr()[25].landOn(gferry.getPlayers()[0], gferry.getController());
        gferry.getPlayers()[1].setPosition(5);
        gferry.getmyBoard().getBoardAr()[5].landOn(gferry.getPlayers()[1], gferry.getController());

        assertEquals(28000, gferry.getPlayers()[1].getBalance());

        gferry.getPlayers()[0].setPosition(35);
        gferry.getmyBoard().getBoardAr()[35].landOn(gferry.getPlayers()[0], gferry.getController());
        gferry.getPlayers()[1].setPosition(5);
        gferry.getmyBoard().getBoardAr()[5].landOn(gferry.getPlayers()[1], gferry.getController());

        assertEquals(24000,gferry.getPlayers()[1].getBalance());


    }
}
