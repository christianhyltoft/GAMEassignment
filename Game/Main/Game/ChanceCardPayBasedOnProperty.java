public class ChanceCardPayBasedOnProperty extends ChanceCard {
    private int houseAmount;
    private int hotelAmount;


    public ChanceCardPayBasedOnProperty(int chanceCardAmount, String chanceCardText, int chanceCardID) {
        super(chanceCardAmount, chanceCardText, chanceCardID);
        this.houseAmount = houseAmount;
        this.hotelAmount = hotelAmount;
    }
   /* public void DrawCard(Player myPlayer){
        myPlayer.changeBalance(houseAmount*husprisen + hotelAmount*hotelprisen);
        }
         !SKAL RETTES EFTER! */
}

