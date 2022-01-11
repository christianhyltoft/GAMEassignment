import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FirsteGameplayTest {


    @Test
    public void playgame() throws IOException {
        Gamehandler gtset= new Gamehandler();
        gtset.playGame();
    }
}
