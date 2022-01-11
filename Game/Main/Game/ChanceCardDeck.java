import java.io.IOException;

public class ChanceCardDeck {


    private ChanceCard[] chanceCardDeck;

    public ChanceCardDeck() {
        TxtReader textreader = new TxtReader();
       ChanceCard[][][] filesChanceCardsCombined = new ChanceCard[Settings.ChanceCardDataBase.length][][];
        for (int i = 0; i < Settings.ChanceCardDataBase.length; i++) {
            try {
                String[] chanceCardText = textreader.reader(Settings.ChanceCardDataBase[i]);
               filesChanceCardsCombined[i] = new ChanceCard[chanceCardText.length][];
                for (int j = 0; j < chanceCardText.length; j++) {
                    String chanceCardLine = chanceCardText[j];
                    filesChanceCardsCombined[i][j] = txtReaderDivider(chanceCardLine, Settings.ChanceCardDataBase[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        // Finde ud af hvor mange chancekort der er i alt. Loop inde i loop inde i loop tjekke for hvert element i inderste array incrementere min integer.
        // når jeg har længden af det kan jeg lave chancecarddeck.lenght af det.

     //   for (Test[] ts : tss) {
      //      for (Test t : ts) {
      //          out[pos] = t;
      //          pos++;
       //    }
       // }
    }
    public ChanceCard[] txtReaderDivider(String chanceCardLine, String chanceCardTextFile) {
        ChanceCard[] output;
        if (chanceCardTextFile == "ChanceCardPayOrReceiveMoneyFromBank.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
            int cardAmount = Integer.parseInt(chanceCardData[0]);
            String payOrReceive = chanceCardData[1];
            int moneyAmount = Integer.parseInt(chanceCardData[2]);
            String text = chanceCardData[3];
            if (payOrReceive == "p") {
                moneyAmount = -moneyAmount;
            }
            output = new ChanceCardPayOrReceive[cardAmount];
            for (int i = 0; i < cardAmount; i++) {
                output[i] = new ChanceCardPayOrReceive(moneyAmount, text);
                // here we must add the chance card to the ChanceCard[] above.
            }
            return output;
        }
        if (chanceCardTextFile == "ChanceCardGetOutOfJail.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 2);
            int cardAmount = Integer.parseInt(chanceCardData[0]);
            String text = chanceCardData[1];
            output = new ChanceCardGetOutOfJail[1];
            for (int i = 0; i < cardAmount; i++) {
                output[i] = new ChanceCardGetOutOfJail(text);
            }
            return output;
        }
        if (chanceCardTextFile == "ChanceCardMatadorGrant.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 3);
            int cardAmount = Integer.parseInt(chanceCardData[0]);
            int moneyAmount = Integer.parseInt(chanceCardData[1]);
            String text = chanceCardData[3];
            output = new ChanceCardMatadorGrant[cardAmount];
            for (int i = 0; i < cardAmount; i++) {
                // here we must add the chance card to the ChanceCard[] above.
                output[i] = new ChanceCardMatadorGrant(moneyAmount, text);
            }
            return output;
        }
        if (chanceCardTextFile == "ChanceCardPayBasedOnProperty.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 4);
            int cardAmount = Integer.parseInt(chanceCardData[0]);
            int housePrice = Integer.parseInt(chanceCardData[1]);
            int hotelPrice = Integer.parseInt(chanceCardData[2]);
            String text = chanceCardData[3];
            output = new ChanceCardPayBasedOnProperty[cardAmount];
            for (int i = 0; i < cardAmount; i++) {
                // here we must add the chance card to the ChanceCard[] above.
                output[i] = new ChanceCardPayBasedOnProperty(housePrice, hotelPrice, text);
            }
            return output;
        }
        if (chanceCardTextFile == "ChanceCardReceiveMoneyFromPlayers.txt") {
            String[] chanceCardData = chanceCardLine.split("-", 3);
            int cardAmount = Integer.parseInt(chanceCardData[0]);
            int moneyAmount = Integer.parseInt(chanceCardData[1]);
            String text = chanceCardData[2];
            output = new ChanceCardReceiveMoneyFromPlayers[cardAmount];
            for (int i = 0; i < cardAmount; i++) {
                // here we must add the chance card to the ChanceCard[] above.
                output[i] = new ChanceCardReceiveMoneyFromPlayers(moneyAmount, text);
            }
            return output;
        }
        return new ChanceCard[0];
    }
}


