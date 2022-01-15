import java.io.IOException;

//This class is a creator class used for creating the board that the game is played on.
// This class is having both all the fields and the deck of chance-cards.
public class Board {
//The two important values being stored in this class
    private final Field[] boardAr;
    final private ChanceCardDeck myDeck;

    final private GameHandler parent;

    public Board(GameHandler parent) throws IOException {
        this.parent = parent;
        TxtReader reader = new TxtReader();

        String[] generator = reader.reader("Fields.txt");
        boardAr = new Field[generator.length];
        for (int i = 0; i < boardAr.length; i++) {
            boardAr[i] = makeField(i, generator);
        }

        myDeck = new ChanceCardDeck(this, boardAr);
    }

    //This method creates the fields used to play the game and puts them boardAr[]
    private Field makeField(int i, String[] generator) {
        String[] generate1field = generator[i].split("-");
        switch (generate1field[0]) {
            case "Start":
                return new FieldStart(generate1field[0], "Start", this);
            case "Chance":
                return new FieldChance(generate1field[1], "Chance", this);
            case "Jail":
                return new FieldJail(generate1field[1], "Jail", this);
            case "Parking":
                return new FieldParking(generate1field[1], "Parking", this);
            case "MoveToJail":
                return new FieldGoToJail(generate1field[1], "MoveToJail", this);
            case "Tax":
                return new FieldTax(generate1field[1], "Tax", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]));
            case "Property":
                return new FieldDeed(generate1field[1], "Property", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]), Integer.parseInt(generate1field[4]), Integer.parseInt(generate1field[5]), Integer.parseInt(generate1field[6]), Integer.parseInt(generate1field[7]), Integer.parseInt(generate1field[8]), Integer.parseInt(generate1field[9]), Integer.parseInt(generate1field[10]), Integer.parseInt(generate1field[11]));
            case "Ferry":
                return new FieldFerry(generate1field[1], "Ferry", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]), Integer.parseInt(generate1field[4]), Integer.parseInt(generate1field[5]));
            case "Beverage":
                return new FieldBeverage(generate1field[1], "Beverage", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]), Integer.parseInt(generate1field[4]));


        }
        return null;

    }

    //Standard getter methods
    public Field[] getBoardAr() {
        return boardAr;
    }

    public ChanceCardDeck getMyDeck() {
        return myDeck;
    }

    public GameHandler getParent() {
        return parent;
    }
}
