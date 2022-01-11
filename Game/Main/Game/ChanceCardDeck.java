import java.io.IOException;

public class ChanceCardDeck {

    private Field[] myFields;
    private ChanceCard[] chanceCardDeck;
    private int count;

    public ChanceCardDeck(Field[] myFields) {
        this.myFields = myFields;
        count = 0;

        TxtReader myTxtReader = new TxtReader();
        String[] chanceCardText = new String[0];
        try {
            chanceCardText = myTxtReader.reader(Settings.ChanceCardDataBase2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < chanceCardText.length; i++){
            ChanceCardCreator(chanceCardText[i]);
        }
    }

    private void ChanceCardCreator(String cardText){
        String[] splitText = cardText.split("-", 4);
        String chanceCardType = splitText[0];
        int cardAmount = Integer.parseInt(splitText[1]);

        switch(chanceCardType){
            case "GetOutOfJail":
                String text = splitText[2];

                for(int i = 0; i < cardAmount; i++){
                    chanceCardDeck[i + count] = new ChanceCardGetOutOfJail(text);
                    count++;
                }
                break;
            case "MatadorGrant":
                int moneyAmount = Integer.parseInt(splitText[2]);
                text = splitText[3];

                for(int i = 0; i < cardAmount; i++){
                    chanceCardDeck[i + count] = new ChanceCardMatadorGrant(moneyAmount, text);
                    count++;
                }
                break;
            case "MoveYourCharacter":
                text = splitText[2];

                for(int i = 0; i < cardAmount; i++){
                    chanceCardDeck[i + count] = new ChanceCardMove(text, myFields);
                    count++;
                }
                break;
            case "PayBasedOnProperty":
                int housePrice = Integer.parseInt(splitText[2]);
                int hotelPrice = Integer.parseInt(splitText[3]);
                text = splitText[4];

                for(int i = 0; i < cardAmount; i++){
                    chanceCardDeck[i + count] = new ChanceCardPayBasedOnProperty(housePrice, hotelPrice, text);
                    count++;
                }
                break;
            case "PayOrReceiveMoneyFromBank":
                String payOrReceive = splitText[2];
                moneyAmount = Integer.parseInt(splitText[3]);
                text = splitText[4];
                if (payOrReceive == "p") { moneyAmount = -moneyAmount; }

                for(int i = 0; i < cardAmount; i++){
                    chanceCardDeck[i + count] = new ChanceCardPayOrReceive(moneyAmount, text);
                    count++;
                }
                break;
            case "ReceiveMoneyFromPlayers":
                moneyAmount = Integer.parseInt(splitText[2]);
                text = splitText[3];

                for(int i = 0; i < cardAmount; i++){
                    chanceCardDeck[i + count] = new ChanceCardReceiveMoneyFromPlayers(moneyAmount, text);
                    count++;
                }
                break;
        }
    }
}


