import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BuildhouseTest {

    @Test
    public void houseBuildTest() throws IOException {
        GameHandler ghousetest = new GameHandler();
        ghousetest.getPlayers()[0].setPosition(1);
        ghousetest.getmyBoard().getBoardAr()[1].landOn(ghousetest.getPlayers()[0], ghousetest.getController());
        ghousetest.getPlayers()[0].setPosition(3);
        ghousetest.getmyBoard().getBoardAr()[3].landOn(ghousetest.getPlayers()[0], ghousetest.getController());
        ghousetest.playGame();


    }

}
