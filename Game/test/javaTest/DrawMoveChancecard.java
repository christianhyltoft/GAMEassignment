import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class DrawMoveChancecard {
    @Test
    public void movecard() throws IOException {
        Gamehandler gtest = new Gamehandler();
        gtest.getMyboard().getMyDeck().getChanceCardDeck()[1].DrawCard(gtest.getPlayers()[1], gtest.getController());
        assertEquals(gtest.getPlayers()[1].getPosition(),34);



    }
}
