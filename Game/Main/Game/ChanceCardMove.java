public class ChanceCardMove extends ChanceCard{

    public ChanceCardMove(String chanceCardText) {
        super(chanceCardText);
    }

    @Override
    public void DrawCard(Player player, GUIController GUI, Field[] myFields){
        String[] fieldname = chanceCardText.split("\"",2);
        // move to non-ferry property.
        for (int i = 0; i < myFields.length; i++) {
            if (myFields[i].getName().equals(fieldname[1])){
                player.setPosition(i);
            }
        }
    }
}
