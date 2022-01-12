import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class ChanceCardDeck {

    private Field[] myFields;



    private ChanceCard[] chanceCardDeck;
    private int count;
    private Board parent;

    public ChanceCardDeck(Board parent, Field[] myFields) {
        this.parent = parent;
        this.chanceCardDeck = new ChanceCard[42];
        this.myFields = myFields;
        count = 0;

        TxtReader myTxtReader = new TxtReader();
        String[] chanceCardText = new String[0];
        try {
            chanceCardText = myTxtReader.reader(Settings.ChanceCardDataBase2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < chanceCardText.length; i++) {
            ChanceCardCreator(chanceCardText[i]);
        }

        ShuffleDeck();
    }

    private void ChanceCardCreator(String cardText) {
        String[] splitText = cardText.split("-", 5);
        String chanceCardType = splitText[0];
        int cardAmount = Integer.parseInt(splitText[1]);

        switch (chanceCardType) {
            case "GetOutOfJail":
                String text = splitText[2];

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardGetOutOfJail(text, this);
                    count++;
                }
                break;
            case "MatadorGrant":
                int moneyAmount = Integer.parseInt(splitText[2]);
                text = splitText[3];

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardMatadorGrant(moneyAmount, text, this);
                    count++;
                }
                break;
            case "MoveYourCharacter":
                int passStart = Integer.parseInt(splitText[2]);
                String goToField = splitText[3];
                text = splitText[4];

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardMove(text, passStart, goToField, myFields, this);
                    count++;
                }
                break;
            case "MoveFerry":
                text = splitText[4];

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardFerry(text, myFields, this);
                    count++;
                }
                break;
            case "MoveBackOrForward":
                String direction = splitText[2];
                int moveAmount = Integer.parseInt(splitText[3]);
                text = splitText[4];
                if(direction.equals("b")){
                    moveAmount = -moveAmount;
                }

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardMoveBackOrForward(moveAmount, text, this);
                    count++;
                }
                break;
            case "PayBasedOnProperty":
                int housePrice = Integer.parseInt(splitText[2]);
                int hotelPrice = Integer.parseInt(splitText[3]);
                text = splitText[4];

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardPayBasedOnProperty(housePrice, hotelPrice, text, this);
                    count++;
                }
                break;
            case "PayOrReceiveMoneyFromBank":
                String payOrReceive = splitText[2];
                moneyAmount = Integer.parseInt(splitText[3]);
                text = splitText[4];
                if (payOrReceive.equals("p")) {
                    moneyAmount = -moneyAmount;
                }

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardPayOrReceive(moneyAmount, text, this);
                    count++;
                }
                break;
            case "ReceiveMoneyFromPlayers":
                moneyAmount = Integer.parseInt(splitText[2]);
                text = splitText[3];

                for (int i = 0; i < cardAmount; i++) {
                    chanceCardDeck[count] = new ChanceCardReceiveMoneyFromPlayers(moneyAmount, text, this);
                    count++;
                }
                break;
        }
    }

    public void ShuffleDeck() {
        Random rng = new Random();

        for (int i = 0; i < 1000; i++) {
            int card1 = rng.nextInt(chanceCardDeck.length);
            int card2 = rng.nextInt(chanceCardDeck.length);

            ChanceCard temp = chanceCardDeck[card1];
            chanceCardDeck[card1] = chanceCardDeck[card2];
            chanceCardDeck[card2] = temp;
        }
    }

    public ChanceCard DrawCard() {
        ChanceCard myCard = chanceCardDeck[0];

        for (int i = 0; i < chanceCardDeck.length - 1; i++) {
            chanceCardDeck[i] = chanceCardDeck[i + 1];
        }
        chanceCardDeck[chanceCardDeck.length - 1] = myCard;

        return myCard;
    }

    public Board getParent() {
        return parent;
    }

    public ChanceCard[] getChanceCardDeck() {
        return chanceCardDeck;
    }

    public void setChanceCardDeck(ChanceCard[] chanceCardDeck) {
        this.chanceCardDeck = chanceCardDeck;
    }
}


