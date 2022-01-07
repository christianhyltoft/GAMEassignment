public class Die {
    private int value;
    private int faceAmount;

    public Die(int faceAmount) {
        this.faceAmount = faceAmount;
        this.value = 1;
    }

    public void setFaceAmount(int faceAmount) {
        this.faceAmount = faceAmount;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFaceAmount() {
        return faceAmount;
    }

    public void roll() {
        value = (int) (Math.random() * faceAmount + 1);
    }


    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
