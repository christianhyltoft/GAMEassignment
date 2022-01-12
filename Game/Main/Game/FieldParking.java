public class FieldParking extends Field {

    private int totalMoney;

    public FieldParking(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
        this.totalMoney = 0;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);
        gui.getMyGUI().showMessage("You receive " + totalMoney);
        player.changeBalance(totalMoney);
        gui.getMyPlayers()[player.getNumber()].setBalance(player.getBalance());
        totalMoney = 0;
    }

    public void addMoney(int money){
        totalMoney += money;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public String toString() {
        return "Here at " + this.name + " you might get lucky with the last parking spot";
    }
}
