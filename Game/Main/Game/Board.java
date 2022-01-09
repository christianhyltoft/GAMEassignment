public class Board {
    private Field[] boardAr;

    public Board(String[] generator) {
        boardAr = new Field[generator.length];
        for (int i = 0; i < boardAr.length; i++) {
            boardAr[i] = makeField(i, generator);

        }


    }

    private Field makeField(int i, String[] generator) {
        String[] generate1field = generator[i].split("-");
        switch (generate1field[0]) {
            case "Start":
            case "Chance":
            case "Jail":
            case "GoToJail":
                return new FieldStart(generate1field[1], "message");
            case "Property":
                return new FieldDeed(generate1field[1], "message", Integer.parseInt(generate1field[2]), Integer.parseInt(generate1field[3]), Integer.parseInt(generate1field[4]), Integer.parseInt(generate1field[5]), Integer.parseInt(generate1field[6]), Integer.parseInt(generate1field[7]), Integer.parseInt(generate1field[8]), Integer.parseInt(generate1field[9]), Integer.parseInt(generate1field[10]));


        }
        return null;

    }

}
