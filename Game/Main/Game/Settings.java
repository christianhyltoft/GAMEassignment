import gui_fields.*;

import java.awt.*;
import java.io.IOException;

public final class Settings {

    private Settings() throws IOException {


    }
    public static void gamehandlerint() throws IOException {
        TxtReader myTxtReader = new TxtReader();

        gameHandlerText = myTxtReader.reader("GameText");

    }

    // Game Rules
    public static final int STARTING_MONEY = 30000;

    // Players
    public static final int MIN_PLAYERS = 3;
    public static final int MAX_PLAYERS = 6;
    public static final int BOARD_SIZE = 40;

    //Jail
    public static final int JAIL_RELEASE_FEE = 1000;

    //GamehandlerText
    public static String [] gameHandlerText;



    public static final String ChanceCardDataBase2 = "ChanceCards.txt";
    public static final String[] ChanceCardDataBase = {"ChanceCardGetOutOfJail.txt", "ChanceCardMatadorGrant.txt", "ChanceCardMoveYourCharacter.txt",
            "ChanceCardPayBasedOnProperty.txt", "ChanceCardPayOrReceiveMoneyFromBank.txt", "ChanceCardReceiveMoneyFromPlayers.txt"};

    public static GUI_Field[] fields = new GUI_Field[]{

            new GUI_Start("Start", "Get: 4000", "Receive: 4000,-\nwhen you pass this field", new Color(150, 0, 100), Color.BLACK),
            new GUI_Street("Rødovrevej", "Cost:  1200", "Rødovrevej", "Rent:  50", new Color(75, 155, 225), Color.BLACK),
            new GUI_Chance("?", "Chance", "Take a chance card.", new Color(100, 100, 204), Color.BLACK),
            new GUI_Street("Hvidovrevej", "Cost:  1200", "Hvidovrevej", "Rent:  50", new Color(75, 155, 225), Color.BLACK),
            new GUI_Tax("Pay\ntax", "10% or 4000", "Pay your tax\n10% or 4000", Color.GRAY, Color.BLACK),
            new GUI_Shipping("default", "Øresund", "Cost:  4000", "Øresundsredderiet", "Rent:  500", Color.WHITE, Color.BLACK),
            new GUI_Street("Roskildevej", "Cost:  2000", "Roskildevej", "Rent:  100", new Color(255, 135, 120), Color.BLACK),
            new GUI_Chance("?", "Chance", "Take a chance card.", new Color(100, 100, 204), Color.BLACK),
            new GUI_Street("Valby\nLanggade", "Cost:  2000", "Valby Langgade", "Rent:  100", new Color(255, 135, 120), Color.BLACK),
            new GUI_Street("Allégade", "Cost:  2400", "Allégade", "Rent: 150", new Color(255, 135, 120), Color.BLACK),
            new GUI_Jail("default", "Jail", "Jail", "You are visiting the jail", new Color(125, 125, 125), Color.BLACK),
            new GUI_Street("Frederiks-\nberg Allé", "Cost:  2800", "Frederiksberg Allé", "Rent:  200", new Color(102, 204, 0), Color.BLACK),
            new GUI_Brewery("default", "Tuborg", "Cost:  3000", "Tuborg brewery", "10 x [Dice-roll]", Color.BLACK, Color.WHITE),
            new GUI_Street("Bülowsvej", "Cost:  2800", "Bülowsvej", "Rent:  200", new Color(102, 204, 0), Color.BLACK),
            new GUI_Street("Gammel Kongevej", "Cost:  3200", "Gammel Kongevej", "Rent:  250", new Color(102, 204, 0), Color.BLACK),
            new GUI_Shipping("default", "D.F.D.S.", "Cost:  4000", "D.F.D.S.", "Rent:  500", Color.WHITE, Color.BLACK),
            new GUI_Street("Bernstorffsvej", "Cost:  3600", "Bernstorffsvej", "Rent:  300", new Color(100, 100, 100), Color.BLACK),
            new GUI_Chance("?", "Chance", "Take a chance card.", new Color(100, 100, 204), Color.BLACK),
            new GUI_Street("Hellerupvej", "Cost:  3600", "Hellerupvej", "Rent:  300", new Color(100, 100, 100), Color.BLACK),
            new GUI_Street("Strandvejen", "Cost:  4000", "Strandvejen", "Rent:  350", new Color(100, 100, 100), Color.BLACK),
            new GUI_Refuge("default", "Parking", "Parking", "Take a break", Color.WHITE, Color.BLACK),
            new GUI_Street("Trianglen", "Cost:  4400", "Trianglen", "Rent:  350", new Color(204, 150, 150), Color.BLACK),
            new GUI_Chance("?", "Chance", "Take a chance card.", new Color(100, 100, 204), Color.BLACK),
            new GUI_Street("Østerbro-\ngade", "Cost:  4400", "Østerbrogade", "Rent:  350", new Color(204, 150, 150), Color.BLACK),
            new GUI_Street("Grønningen", "Cost:  4800", "Grønningen", "Rent:  400", new Color(204, 150, 150), Color.BLACK),
            new GUI_Shipping("default", "Scandlines Gedser", "Cost:  4000", "Scandlines Gedser", "Rent:  500", Color.WHITE, Color.BLACK),
            new GUI_Street("Bredgade", "Cost:  5200", "Bredgade", "Rent:  450", Color.CYAN, Color.BLACK),
            new GUI_Street("Kgs. Nytorv", "Cost:  5200", "Kongens Nytorv", "rent:  450", Color.CYAN, Color.BLACK),
            new GUI_Brewery("default", "Carlsberg", "Cost:  3000", "Carlsberg brewery", "10 x [Dice-roll]", Color.BLACK, Color.WHITE),
            new GUI_Street("Østergade", "Cost:  5600", "Østergade", "Rent:  500", Color.CYAN, Color.BLACK),
            new GUI_Jail("default", "Go to jail", "Go to jail", "You are being held captive\nRoll a double to get out", new Color(125, 125, 125), Color.BLACK),
            new GUI_Street("Amagertorv", "Cost:  6000", "Amagertorv", "Rent:  550", new Color(255, 255, 50), Color.BLACK),
            new GUI_Street("Vimmel-\nskaftet", "Cost:  6000", "Vimmelskaftet", "Rent:  550", new Color(255, 255, 50), Color.BLACK),
            new GUI_Chance("?", "Chance", "Take a chance card.", new Color(100, 100, 204), Color.BLACK),
            new GUI_Street("Nygade", "Cost:  6400", "Nygade", "Rent:  600", new Color(255, 255, 50), Color.BLACK),
            new GUI_Shipping("default", "Scandlines Rødby", "Cost: 4000", "Scandlines Rødby", "Rent:  500", Color.WHITE, Color.BLACK),
            new GUI_Chance("?", "Chance", "Take a chance card.", new Color(100, 100, 204), Color.BLACK),
            new GUI_Street("Frederiks-\nberggade", "Cost:  7000", "Frederiksberggade", "Rent:  700", new Color(150, 60, 150), Color.WHITE),
            new GUI_Tax("Extra-\nordinary\nStateTax", "Pay your tax\n10% or 2000", "Pay extraordinary\nStateTax: kr. 2000,-", Color.GRAY, Color.BLACK),
            new GUI_Street("Rådhuspladsen", "Cost:  8000", "Rådhuspladsen", "Rent:  1000", new Color(150, 60, 150), Color.WHITE),
    };



}

// A class of information about the game so you can chance information and rules about the game in one file instead of having to go through many files.