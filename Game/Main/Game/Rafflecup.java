
public class Rafflecup {

    private Die[] cup;

    public Rafflecup(int diceAmount, int faceAmount) {
        this.cup = new Die[diceAmount];
        for (int i = 0; i < diceAmount; i++) {
            this.cup[i] = new Die(faceAmount);
        }
    }

    public void rollar() {
        for (int i = 0; i < cup.length; i++) {
            cup[i].roll();
        }
    }

    //Returning the value of the sum of the arrays die's values
    public int sum() {
        int sum = 0;
        for (int i = 0; i < cup.length; i++) {
            sum += cup[i].getValue();
        }
        return sum;
    }

    //Rolling the dice and returning the value
    public int[] roll() {
        int[] values = new int[this.cup.length];
        for (int i = 0; i < this.cup.length; i++) {
            cup[i].roll();
            values[i] = cup[i].getValue();
        }
        return values;
    }

    //Used to evaluate whether all the dice has the same value
    public boolean sameFacesUpOnAllDice() {
        for (int i = 0; i < cup.length - 1; i++) {
            if (cup[i].getValue() != cup[i + 1].getValue())
                return false;

        }
        return true;
    }

    public Die[] getCup() {
        return cup;
    }

    public void setCup(Die[] cup) {
        this.cup = cup;
    }
}

// A pure fabrication and controller class used, in this case to create an array of 2 dices with 6 sides.
// The methods used other places are roll() and sameFacesUpOnAllDice