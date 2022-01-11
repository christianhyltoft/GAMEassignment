import java.io.IOException;

public class Gamehandlertest {
    public static void main(String[] args) throws IOException {
        Gamehandler g1 = new Gamehandler();
        g1.playGame();
        System.out.println(g1.getMyboard().getBoardAr().length);

    }
}
