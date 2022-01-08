import java.io.IOException;
import java.util.Arrays;

public class Txtreadertest {
    TxtReader reader = new TxtReader();


    public void readerTest() throws IOException {
        String[] test = reader.reader("ChanceCardReceiveMoneyFromPlayers.txt");
        System.out.println(Arrays.toString(test));
        System.out.println(test.length);


    }
}
