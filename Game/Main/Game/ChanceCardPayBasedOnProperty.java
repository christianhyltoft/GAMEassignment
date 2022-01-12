public class ChanceCardPayBasedOnProperty extends ChanceCard {
    private int houseAmount;
    private int hotelAmount;


    public ChanceCardPayBasedOnProperty(int houseAmount, int hotelAmount, String chanceCardText, ChanceCardDeck parent) {
        super(chanceCardText, parent);
        this.houseAmount = houseAmount;
        this.hotelAmount = hotelAmount;
    }
   /*
   @override
   public void DrawCard(Player myPlayer, GUIController GUI){
        myPlayer.changeBalance(houseAmount*husprisen + hotelAmount*hotelprisen);
        }
         !SKAL RETTES EFTER! */
}

