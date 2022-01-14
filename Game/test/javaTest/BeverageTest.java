import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeverageTest {

    @Test
    public void beveragetest() throws IOException {
        GameHandler gtest=new GameHandler();
        gtest.getPlayers()[0].setPosition(12);
        gtest.getmyBoard().getBoardAr()[12].landOn(gtest.getPlayers()[0], gtest.getController());
        gtest.getPlayers()[0].setPosition(28);
        gtest.getmyBoard().getBoardAr()[28].landOn(gtest.getPlayers()[0], gtest.getController());
        gtest.getPlayers()[1].setPosition(12);
        gtest.getmyBoard().getBoardAr()[12].landOn(gtest.getPlayers()[1], gtest.getController());
        assertEquals(29600,gtest.getPlayers()[1].getBalance());




    }
}
