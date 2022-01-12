import java.io.IOException;

public class Board {

    private Field[] boardAr;
    private ChanceCardDeck myDeck;
    private TxtReader reader;

    public Board() throws IOException {
        reader = new TxtReader();

        String[] generator = reader.reader("Fields.txt");
        boardAr = new Field[generator.length];
        for (int i = 0; i < boardAr.length; i++) {
            boardAr[i] = makeField(i, generator);
        }

        myDeck = new ChanceCardDeck(boardAr);
    }

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
                return new FieldDeed(generate1field[1], "Property", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]), Integer.parseInt(generate1field[4]), Integer.parseInt(generate1field[5]), Integer.parseInt(generate1field[6]), Integer.parseInt(generate1field[7]), Integer.parseInt(generate1field[8]), Integer.parseInt(generate1field[9]), Integer.parseInt(generate1field[10]));
            case "Ferry":
                return new FieldFerry(generate1field[1], "Ferry", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]), Integer.parseInt(generate1field[4]));
            case "Beverage":
                return new FieldBeverage(generate1field[1], "Beverage", this, Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]));


        }
        return null;

    }

    public Field[] getBoardAr() {
        return boardAr;
    }

    public void setBoardAr(Field[] boardAr) {
        this.boardAr = boardAr;
    }

    public ChanceCardDeck getMyDeck() {
        return myDeck;
    }
}
