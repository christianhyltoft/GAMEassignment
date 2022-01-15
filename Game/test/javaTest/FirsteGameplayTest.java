import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FirsteGameplayTest {


    @Test
    public void playgame() throws IOException {
        GameHandler gtset= new GameHandler();
        gtset.playGame();
    }
}
