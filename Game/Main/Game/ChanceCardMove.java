public class ChanceCardMove extends ChanceCard{
private Field[] myFields;
    public ChanceCardMove(int chanceCardAmount, String chanceCardText, int chanceCardID, Field[] myFields) {
        super(chanceCardAmount, chanceCardText, chanceCardID);
        this.myFields = myFields;
    }
    public void DrawCard(Player player){
        for (int i = 0; i <2 ; i++) {
            
        }
    }
}
