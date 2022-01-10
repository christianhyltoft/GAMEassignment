import java.util.stream.IntStream;

public class Rafflecup {

    private Die[] cup;

    public Rafflecup(int diceAmount, int faceAmount) {
        this.cup = new Die[diceAmount];
        for (int i = 0; i < diceAmount; i++) {
            this.cup[i] = new Die(faceAmount);
        }
    }
public void rollar(){
    for (int i = 0; i < cup.length; i++) {
        cup[i].roll();
    }
}

public int sum(){
    int[] values = roll();
    return IntStream.of(values).sum();

    }
    public int[] roll(){
        int[] values = new int[this.cup.length];
        for (int i = 0; i < this.cup.length; i++) {
            cup[i].roll();
            values[i] = cup[i].getValue();
        }
        return values;
    }
}
