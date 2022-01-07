
import java.util.Random;

public abstract class ChanceCard {


    private int MoneyAmount;
    private int ChanceCardAmount;
    private int ChanceCardID;
    private String ChanceCardText;

    public ChanceCard(int ChanceCardAmount, String ChanceCardText, int ChanceCardID) {
        this.ChanceCardAmount = ChanceCardAmount;
        this.ChanceCardID = ChanceCardID;
        this.ChanceCardText = ChanceCardText;
    }
}