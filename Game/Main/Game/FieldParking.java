public class FieldParking extends Field {

    private int totalMoney;

    public FieldParking(String name, String FieldType, Board parent) {
        super(name, FieldType, parent);
        this.totalMoney = 0;
    }

    @Override
    public void landOn(Player player, GUIController gui) {
        super.landOn(player, gui);
        gui.getMyGUI().showMessage(Settings.gameHandlerText[71] + totalMoney);
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
        return Settings.gameHandlerText[72] + this.name + Settings.gameHandlerText[73];
    }
}
