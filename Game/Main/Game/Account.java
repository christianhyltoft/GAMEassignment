public class Account {
    private int balance;
    public Account(){
        this.balance=30000;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void changeBalance(int change){
        this.balance+=change;
    }
}
