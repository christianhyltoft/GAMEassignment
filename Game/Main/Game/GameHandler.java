import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.io.IOException;

public class GameHandler {
    final private Board myBoard;
    private Player[] players;
    final private int amountOfPlayers;

    final private GUI myGUI = new GUI(Settings.fields);
    final private GUI_Player[] gui_players;

    final private Rafflecup rafflecup = new Rafflecup(2, 6);

    final private GUIController controller;

    //Constructing a GameHandler instance.
    //This also initialises the txt file that takes care of game text.
    public GameHandler() throws IOException {
        Settings.gameTextInit();

        Color[] carColors = new Color[]{Color.CYAN, Color.MAGENTA, Color.PINK, Color.BLUE, Color.GREEN, Color.ORANGE};
        this.amountOfPlayers = Integer.parseInt(myGUI.getUserSelection(Settings.gameHandlerText[0], "3", "4", "5", "6"));
        players = new Player[this.amountOfPlayers];
        gui_players = new GUI_Player[this.amountOfPlayers];

        myBoard = new Board(this);

        for (int i = 0; i < this.amountOfPlayers; i++) {
            String input = myGUI.getUserString(Settings.gameHandlerText[1] + (i + 1));
            players[i] = new Player(Settings.STARTING_MONEY, input, 0);
            gui_players[i] = new GUI_Player(input, Settings.STARTING_MONEY);
            gui_players[i].getCar().setPrimaryColor(carColors[i]);
            myGUI.addPlayer(gui_players[i]);
            gui_players[i].getCar().setPosition(myGUI.getFields()[0]);
        }
        for (int i = 0; i < myGUI.getFields().length; i++) {
            myGUI.getFields()[i].setDescription(myBoard.getBoardAr()[i].toString());

        }
        controller = new GUIController(myGUI, gui_players);

        myGUI.showMessage(Settings.gameHandlerText[2]);
    }

    //The method that is called to start the game.
    public void playGame() {
        do {
            for (int i = 0; i < players.length; i++) {
                if (!players[i].isPlayerHasLost()) {
                    if (players[i].isJailed()) {
                        jailTurn(players[i]);
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

    //This method is used if the player is jailed. And is one of the two turns a player can play
    private void jailTurn(Player player) {
        myGUI.showMessage(Settings.gameHandlerText[5] + player.getName());
        if (player.getTurnsJailed() >= 2) {
            myGUI.showMessage(Settings.gameHandlerText[6] + Settings.JAIL_RELEASE_FEE + player.getName());
            player.changeBalance(-1000);
            gui_players[player.getNumber()].setBalance(player.getBalance());
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
                gui_players[player.getNumber()].setBalance(player.getBalance());
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
                    takeTurn(player, rafflecup);
                } else {
                    myGUI.showMessage(Settings.gameHandlerText[18] + player.getName());
                    player.setTurnsJailed(player.getTurnsJailed() + 1);
                }
            }
        }
    }

    //The first method being called upon each player this roll the dice.
    //This method also calls the takeTurn() to keep the players turn going.
    //This the other option of how a turn can play out.
    private void roll(Player player) {
        myGUI.getUserButtonPressed(Settings.gameHandlerText[19] + player.getName(), Settings.gameHandlerText[16]);
        rafflecup.roll();
        myGUI.setDice(rafflecup.getCup()[0].getValue(), rafflecup.getCup()[1].getValue());
        takeTurn(player, rafflecup);
    }

    //This is used to take the rest of the players turn after rolling the dice.
    //This is here the landOn method gets called and the player reacts to the outcome.
    private void takeTurn(Player player, Rafflecup rafflecup) {
        myGUI.showMessage(Settings.gameHandlerText[20] + player.getName());
        int positionFromTurnBefore = player.getPosition();
        player.changePosition(rafflecup.sum());

        gui_players[player.getNumber()].getCar().setPosition(myGUI.getFields()[player.getPosition()]);
        if (player.getPosition() < positionFromTurnBefore) {
            myGUI.showMessage(Settings.gameHandlerText[21] + player.getName());
            player.changeBalance(4000);
            gui_players[player.getNumber()].setBalance(player.getBalance());
        }
        this.myBoard.getBoardAr()[player.getPosition()].landOn(player, this.controller);
        if (this.myBoard.getBoardAr()[player.getPosition()].getFieldType().equals("Property") || this.myBoard.getBoardAr()[player.getPosition()].getFieldType().equals("Ferry") || this.myBoard.getBoardAr()[player.getPosition()].getFieldType().equals("Beverage")) {
            this.myBoard.getBoardAr()[player.getPosition()].auction(player, this.players, this.controller);

        }

        if (rafflecup.sameFacesUpOnAllDice()) {
            myGUI.showMessage(Settings.gameHandlerText[22] + player.getName());
            roll(player);
        }

        endOfTurnChoice(player);
    }

    //Is used in the end of a players turn for miscellaneous.
    private void endOfTurnChoice(Player myPlayer) {
        String choice = "Invalid";
        while (choice.equals("Invalid")) {
            choice = getChoice(myPlayer);
        }

        String choice2 = "Invalid";
        while (choice2.equals("Invalid")) {
            if (choice.equals("Nothing")) {
                break;
            } else if (choice.equals(Settings.gameHandlerText[23])) {
                String propertyName = myGUI.getUserString(Settings.gameHandlerText[24]);

                for (int i = 0; i < Settings.BOARD_SIZE; i++) {
                    if (myBoard.getBoardAr()[i].getName().equals(propertyName) && myBoard.getBoardAr()[i].getFieldType().equals("Property")) {
                        FieldDeed property = (FieldDeed) myBoard.getBoardAr()[i];
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
                        getgui_players()[myPlayer.getNumber()].setBalance(myPlayer.getBalance());
                        getgui_players()[players[i].getNumber()].setBalance(players[i].getBalance());
                        break;

                    }

                }

            }
            choice = getChoice(myPlayer);
        }
    }

    //This method is a help method to endOfTurnChoice.
    //This method asks the player what he wants to do and calculates whether the player is able to do the action or not.
    private String getChoice(Player myPlayer) {
        String choice = myGUI.getUserSelection(Settings.gameHandlerText[30] + myPlayer.getName() + Settings.gameHandlerText[31], Settings.gameHandlerText[32], Settings.gameHandlerText[23], Settings.gameHandlerText[33], Settings.gameHandlerText[26], Settings.gameHandlerText[34]);

        boolean check = false;

        if (choice.equals(Settings.gameHandlerText[23]) || choice.equals(34)) {
            for (int i = 0; i < Settings.BOARD_SIZE; i++) {
                if (myBoard.getBoardAr()[i].getFieldType().matches("Property|Ferry|Beverage")) {
                    FieldPurchaseAble playerOwnerCheck = (FieldPurchaseAble) myBoard.getBoardAr()[i];
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
                if (myBoard.getBoardAr()[i].getFieldType().equals("Property")) {
                    FieldDeed playerOwnerCheck = (FieldDeed) myBoard.getBoardAr()[i];
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

    //A method which checks whether a player has lost or not if the player has lost he will not take turns anymore.
    private void detectLoser(Player players) {

        if (players.getBalance() < 0) {
            players.setPlayerHasLost(true);
            this.controller.getMyGUI().showMessage(players.getName() + Settings.gameHandlerText[36]);

        }
    }

    //A method checking whether there is only one player remaining this is used to stop the game, when it should be stopped.
    private boolean detectWinner() {
        int playersRemaining = this.players.length;
        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isPlayerHasLost())
                playersRemaining--;

        }
        return !(playersRemaining == 1);

    }


    public Board getmyBoard() {
        return myBoard;
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

    public GUI_Player[] getgui_players() {
        return gui_players;
    }

    public GUIController getController() {
        return controller;
    }

    public Rafflecup GetRafflecup() {
        return rafflecup;
    }


}
