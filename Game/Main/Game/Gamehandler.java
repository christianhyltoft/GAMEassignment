import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.io.IOException;

public class Gamehandler {
    final private Board myboard;
    private Player[] players;
    final private int amountOfPlayers;

    final private GUI myGUI = new GUI(Settings.fields);
    final private GUI_Player[] playersgui;

    final private Rafflecup rafflecup = new Rafflecup(2, 6);

    final private GUIController controller;


    public Rafflecup GetRafflecup() {
        return rafflecup;
    }


    public Gamehandler() throws IOException {
        Settings.gamehandlerint();

        Color[] carcolors = new Color[]{Color.CYAN, Color.MAGENTA, Color.PINK, Color.BLUE, Color.GREEN, Color.ORANGE};
        this.amountOfPlayers = Integer.parseInt(myGUI.getUserSelection(Settings.gameHandlerText[0], "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        playersgui = new GUI_Player[this.amountOfPlayers];

        myboard = new Board(this);

        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = myGUI.getUserString(Settings.gameHandlerText[1] + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            playersgui[i] = new GUI_Player(input, Settings.STARTING_MONEY);
            playersgui[i].getCar().setPrimaryColor(carcolors[i]);
            myGUI.addPlayer(playersgui[i]);
            playersgui[i].getCar().setPosition(myGUI.getFields()[0]);
        }
        for (int i = 0; i < myGUI.getFields().length; i++) {
            myGUI.getFields()[i].setDescription(myboard.getBoardAr()[i].toString());

        }
        controller = new GUIController(myGUI, playersgui);

        myGUI.showMessage(Settings.gameHandlerText[2]);
    }

    public void Playgame() {
        do {
            for (int i = 0; i < players.length; i++) {
                if (!players[i].isPlayerHasLost()) {
                    if (players[i].isJailed()) {
                        JailTurn(players[i]);
                    } else {
                        roll(players[i]);
                    }
                    detectLoser(players[i]);
                }
            }


        } while (detectWinner());
        //Looking for the winner of the game
        for (int i = 0; i < players.length; i++) {
            if (!players[i].isPlayerHasLost())
                getMyGUI().showMessage(Settings.gameHandlerText[3] + players[i].getName() + Settings.gameHandlerText[4]);

        }

    }

    private void JailTurn(Player player) {
        myGUI.showMessage(Settings.gameHandlerText[5] + player.getName());
        if (player.getTurnsJailed() >= 2) {
            myGUI.showMessage(Settings.gameHandlerText[6] + Settings.JAIL_RELEASE_FEE + player.getName());
            player.changeBalance(-1000);
            playersgui[player.getNumber()].setBalance(player.getBalance());
            player.setJailed(false);
            player.setTurnsJailed(0);
            roll(player);
        } else {
            String Choice = "";
            if (player.getEscapeJailCard() >= 1 && player.getBalance() >= Settings.JAIL_RELEASE_FEE) {
                Choice = myGUI.getUserSelection(Settings.gameHandlerText[7] + Settings.JAIL_RELEASE_FEE, Settings.gameHandlerText[8], Settings.gameHandlerText[9], Settings.gameHandlerText[10]);
            } else if (player.getEscapeJailCard() >= 1) {
                Choice = myGUI.getUserSelection(Settings.gameHandlerText[11], Settings.gameHandlerText[8], Settings.gameHandlerText[10]);
            } else if (player.getBalance() >= Settings.JAIL_RELEASE_FEE) {
                Choice = myGUI.getUserSelection(Settings.gameHandlerText[12] + Settings.JAIL_RELEASE_FEE, Settings.gameHandlerText[8], Settings.gameHandlerText[9]);
            }


            if (Choice.equals(Settings.gameHandlerText[9])) {
                myGUI.showMessage(Settings.gameHandlerText[13] + Settings.JAIL_RELEASE_FEE + " " + player.getName());
                player.changeBalance(-1000);
                playersgui[player.getNumber()].setBalance(player.getBalance());
                player.setJailed(false);
                player.setTurnsJailed(0);
                roll(player);
            }
            if (Choice.equals(Settings.gameHandlerText[11])) {
                myGUI.showMessage(Settings.gameHandlerText[14] + player.getName());
                player.setEscapeJailCard(player.getEscapeJailCard() - 1);
                player.setJailed(false);
                player.setTurnsJailed(0);
                roll(player);
            } else {
                myGUI.getUserButtonPressed(Settings.gameHandlerText[15] + player.getName(), Settings.gameHandlerText[16]);
                rafflecup.roll();
                myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());

                if ((rafflecup.getCup()[0].getValue() == rafflecup.getCup()[1].getValue())) {
                    myGUI.showMessage(Settings.gameHandlerText[17] + player.getName());
                    player.setJailed(false);
                    player.setTurnsJailed(0);
                    Taketurn(player, rafflecup);
                } else {
                    myGUI.showMessage(Settings.gameHandlerText[18] + player.getName());
                    player.setTurnsJailed(player.getTurnsJailed() + 1);
                }
            }
        }
    }

    private void roll(Player player) {
        myGUI.getUserButtonPressed(Settings.gameHandlerText[19] + player.getName(), Settings.gameHandlerText[16]);
        rafflecup.roll();
        myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());
        Taketurn(player, rafflecup);
    }

    private void Taketurn(Player player, Rafflecup rafflecup) {
        myGUI.showMessage(Settings.gameHandlerText[20] + player.getName());
        int positionFromTurnBefore = player.getPosition();
        player.changePosition(rafflecup.sum());

        playersgui[player.getNumber()].getCar().setPosition(myGUI.getFields()[player.getPosition()]);
        if (player.getPosition() < positionFromTurnBefore) {
            myGUI.showMessage(Settings.gameHandlerText[21] + player.getName());
            player.changeBalance(4000);
            playersgui[player.getNumber()].setBalance(player.getBalance());
        }
        this.myboard.getBoardAr()[player.getPosition()].landOn(player, this.controller);
        if (this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Property") || this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Ferry") || this.myboard.getBoardAr()[player.getPosition()].getFieldtype().equals("Beverage")) {
            this.myboard.getBoardAr()[player.getPosition()].auction(player, this.players, this.controller);

        }

        if (rafflecup.sameFacesUpOnAllDice()) {
            myGUI.showMessage(Settings.gameHandlerText[22] + player.getName());
            roll(player);
        }

        EndOfTurnChoice(player);
    }

    private void EndOfTurnChoice(Player myPlayer) {
        String choice = "Invalid";
        while (choice.equals("Invalid")) {
            choice = GetChoice(myPlayer);
        }

        String choice2 = "Invalid";
        while (choice2.equals("Invalid")) {
            if (choice.equals("Nothing")) {
                break;
            } else if (choice.equals(Settings.gameHandlerText[23])) {
                String propertyName = myGUI.getUserString(Settings.gameHandlerText[24]);

                for (int i = 0; i < Settings.BOARD_SIZE; i++) {
                    if (myboard.getBoardAr()[i].getName().equals(propertyName) && myboard.getBoardAr()[i].getFieldtype().equals("Property")) {
                        FieldDeed property = (FieldDeed) myboard.getBoardAr()[i];
                        if (property.getOwner() == myPlayer) {
                            // Just using the auction for now, should be changed later.
                            property.setOwner(null);
                            property.sell(myPlayer, players, controller);
                            choice2 = propertyName;
                            break;
                        } else {
                            myGUI.showMessage(Settings.gameHandlerText[25]);
                        }
                    }
                }
            } else if (choice.equals(Settings.gameHandlerText[26])) {
                String buyer = getMyGUI().getUserString(Settings.gameHandlerText[27]);
                if (buyer.equals(Settings.gameHandlerText[28])) {
                    return;
                }
                for (int i = 0; i < players.length; i++) {
                    if (buyer.equals(players[i].getName())) {
                        int price = getMyGUI().getUserInteger(Settings.gameHandlerText[29]);
                        myPlayer.changeBalance(price);
                        players[i].changeBalance(-price);
                        myPlayer.setEscapeJailCard(myPlayer.getEscapeJailCard() - 1);
                        players[i].setEscapeJailCard(players[i].getEscapeJailCard() + 1);
                        getPlayersgui()[myPlayer.getNumber()].setBalance(myPlayer.getBalance());
                        getPlayersgui()[players[i].getNumber()].setBalance(players[i].getBalance());
                        break;

                    }

                }

            }
            choice = GetChoice(myPlayer);
        }
    }

    private String GetChoice(Player myPlayer) {
        String choice = myGUI.getUserSelection(Settings.gameHandlerText[30] + myPlayer.getName() + Settings.gameHandlerText[31], Settings.gameHandlerText[32], Settings.gameHandlerText[23], Settings.gameHandlerText[33], Settings.gameHandlerText[26], Settings.gameHandlerText[34]);

        boolean check = false;

        if (choice.equals(Settings.gameHandlerText[23]) || choice.equals(34)) {
            for (int i = 0; i < Settings.BOARD_SIZE; i++) {
                if (myboard.getBoardAr()[i].getFieldtype().matches("Property|Ferry|Beverage")) {
                    FieldPurchaseAble playerOwnerCheck = (FieldPurchaseAble) myboard.getBoardAr()[i];
                    if (playerOwnerCheck.getOwner() == myPlayer) {
                        check = true;

                    }
                }
            }
        } else if (choice.equals(Settings.gameHandlerText[26])) {
            if (myPlayer.getEscapeJailCard() >= 1) {
                check = true;


            } else {
                getMyGUI().showMessage(Settings.gameHandlerText[35]);
            }
        } else if (choice.equals(Settings.gameHandlerText[34])) {
            for (int i = 0; i < Settings.BOARD_SIZE; i++) {
                if (myboard.getBoardAr()[i].getFieldtype().equals("Property")) {
                    FieldDeed playerOwnerCheck = (FieldDeed) myboard.getBoardAr()[i];
                    if (playerOwnerCheck.getOwner() == myPlayer) {
                        check = true;
                        break;
                    }
                }
            }
        } else if (choice.equals(Settings.gameHandlerText[32])) {
            check = true;
        }

        if (!check) {
            return "Invalid";
        } else {
            return choice;
        }
    }


    private void detectLoser(Player players) {
        //En metode der tjekker når man har tabt spillet. Hvis en spiller har under 0 kr i spillet skal der vurderes at spilleren har tabt.
        if (players.getBalance() < 0) {
            players.setPlayerHasLost(true);
            this.controller.getMyGUI().showMessage(players.getName() + Settings.gameHandlerText[36]);

        }
    }

    private boolean detectWinner() {
        int playersRemaining = this.players.length;
        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isPlayerHasLost())
                playersRemaining--;

        }
        return !(playersRemaining == 1);

    }


    public Board getMyboard() {
        return myboard;
    }


    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public GUI getMyGUI() {
        return myGUI;
    }


    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }


    public GUI_Player[] getPlayersgui() {
        return playersgui;
    }


    public GUIController getController() {
        return controller;
    }


}
