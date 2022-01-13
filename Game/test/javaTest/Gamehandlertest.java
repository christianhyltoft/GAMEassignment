import java.io.IOException;

public class Gamehandlertest {
    public static void main(String[] args) throws IOException {
        GameHandler g1 = new GameHandler();
        g1.playGame();
        System.out.println(g1.getmyBoard().getBoardAr().length);

    }
}
