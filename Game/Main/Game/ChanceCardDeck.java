import java.io.IOException;

public class ChanceCardDeck {


    private ChanceCard[] chanceCardDeck;

    public ChanceCardDeck() {
        TxtReader textreader = new TxtReader();
        for (int i = 0; i < Settings.ChanceCardDataBase.length; i++) {
            try {
                String[] chanceCardText = textreader.reader(Settings.ChanceCardDataBase[i]);
                for (int j = 0; j < chanceCardText.length; j++) {
                    String chanceCardLine = chanceCardText[j];
                    txtReaderDivider(chanceCardLine, Settings.ChanceCardDataBase[i]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void txtReaderDivider(String chanceCardLine, String chanceCardTextFile) {
        if (chanceCardTextFile == "ChanceCardPayOrReceiveMoneyFromBank.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
            int cardAmount = Integer.parseInt(chanceCardData[0]);
            String payOrReceive = chanceCardData[1];
            int moneyAmount = Integer.parseInt(chanceCardData[2]);
            String text = chanceCardData[3];
            if (payOrReceive == "p") {
                moneyAmount = -moneyAmount;
            }
            for (int i = 0; i < cardAmount; i++) {
                ChanceCardPayOrReceive payOrReceiveCard = new ChanceCardPayOrReceive(moneyAmount, text);
                
            }
        }
        if (chanceCardTextFile == "ChanceCardGetOutOfJail.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
        }
        if (chanceCardTextFile == "ChanceCardMatadorGrant.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
        }
        if (chanceCardTextFile == "ChanceCardPayBasedOnProperty.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
        }
        if (chanceCardTextFile == "ChanceCardReceiveMoneyFromPlayers.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
        }

    }


}


