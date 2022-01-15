import java.io.*;

public class TxtReader {

    public String[] reader(String file) throws IOException {
        BufferedReader myReader = new BufferedReader(new FileReader(("Game/Main/resources/" + file)));
        String amount = myReader.readLine();
        int length = Integer.parseInt(amount);
        String[] ret = new String[length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = myReader.readLine();
        }
        return ret;
    }
}


//A class used for reading txt files and returning a string[] og given length, the length is given by the first line in the txt file