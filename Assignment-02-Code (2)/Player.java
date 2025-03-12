/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.util.InputMismatchException;
import java.util.Scanner;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Player extends Person {

    // Instance Data Fields
    private String playerName;
    private String Club;
    private String Position;
    private int Number;
    private String Bats;
    private String Throws;
    private int MLB_Debut;
    //
    // Constructors
    //
    public Player() {
    }
    public Player(String name) {
        switch (name) {
            default -> {
                this.playerName = "Buster Posey";
                this.Club = "San Francisco Giants";
                this.Position = "Catcher";
                this.Number = 28;
                this.Bats = "Right";
                this.Throws = "Right";
                this.MLB_Debut = 2009;
            }
        }
    }
    //
    // Instance Methods
    //
    public static Player getPlayer() {
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        int errorCounter = 3;
        while (!playerName.startsWith("Bus") && !playerName.startsWith("bus")) {
            if (playerName.equals("!")) {
                System.out.println("Special command entered.\nSystem exit initiated.\n.  .  .  .");
                System.exit(0);
            }
            errorCounter--;
            if (errorCounter == 0) {
                System.out.println("Too many failed attempts.\nSystem exit initiated.\n.  .  .  .");
                System.exit(0);
            }
            System.out.print("Please enter a valid player name. [" + errorCounter  + "] (! to exit): ");
            playerName = input.nextLine();
        }

        return new Player(playerName);
    }
    public String getPlayerName() {
        return playerName;
    }
    public String getClub() {
        return Club;
    }
    public String getPosition() {
        return Position;
    }
    public int getNumber() {
        return Number;
    }
    public String getBats() {
        return Bats;
    }
    public String getThrows() {
        return Throws;
    }
    public int getMLB_Debut() {
        return MLB_Debut;
    }
    public String getNameNumber() {
        return this.getPlayerName() + ", " + this.getNumber() + ": ";
    }
    //
    // Additional Instance Methods
    //
    public void displayAbout(){
        System.out.println(Card.getDashes());
        System.out.printf("%-25s %-50s %n", "Player: ", getPlayerName());
        System.out.printf("%-25s %-50s %n", "Club:", getClub());
        System.out.printf("%-25s %-50s %n", "Position:", getPosition());
        System.out.printf("%-25s %-50s %n", "Number: ", getNumber());
        System.out.printf("%-25s %-50s %n", "Bats: ", getBats());
        System.out.printf("%-25s %-50s %n", "Throws: ", getThrows());
        System.out.printf("%-25s %-50d %n", "MLB Debut:", 2009);
        System.out.println(Card.getDashes());
        System.out.println(". . . . . ");
    }
    public int cardAmount(Student myStudent) {
        Scanner input = new Scanner(System.in);
        System.out.println(this.getNameNumber() + "Likewise, " + myStudent.getName() + ". Very nice chatting w/ you.");
        automated(1);
        int howMany = -1;
        int errorCounter = 4;

        while (errorCounter > 0 && howMany <= 0) {
            try {
                System.out.print(myStudent.getName() + ": " );
                howMany = input.nextInt();

            } catch (InputMismatchException e) {
                if (errorCounter == 1) {
                    System.out.println("Too many incorrect responses.\nSystem exiting...");
                    System.exit(0);
                }
                errorCounter--;
                System.out.println( e.getLocalizedMessage() + "\nPlease enter an INTEGER. " + errorCounter + " tries left.");
                automated(1);
            }
            input.nextLine();
        }

        if (howMany < 0) {
            howMany = 0;
        }
        return howMany;
    }
    public void getCardInfo(Student myStudent, int howMany) {
        String [] cardInfo = new String[howMany * 3];
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= howMany; i++) {
        System.out.println(this.getNameNumber() + "Card #" + i);
        System.out.print(myStudent.getName() + ": [1] ");
        cardInfo[3 * i - 3] = input.nextLine(); //Recipient Name
        System.out.print(myStudent.getName() + ": [2] ");
        cardInfo[3 * i - 2] = input.nextLine(); //Art Symbol
        System.out.print(myStudent.getName() + ": [3] ");
        cardInfo[3 * i - 1] = input.nextLine(); //Message
        }
        System.out.println(this.getNameNumber() + "Thanks, " + myStudent.getName() + ". Please confirm your order:\n\n");

        for (int j = 0; j < howMany; j++) {
            try {
                SFGiantsCardGenerator.generateSFGiantsCard(cardInfo[3 * j - 3],cardInfo[3 - j - 1],myStudent.getName(),myStudent.getEmail(),cardInfo[3 * j - 2].charAt(0),12, SFGiantsCardGenerator.ASCIIArtFont.ART_FONT_DIALOG.toString());
            }
            catch (java.lang.Exception) {

            }
        }
    }
    public void automated (int message) {
        switch (message) {
            case 1 -> {System.out.println(this.getNameNumber() + "How many SF Giants Thank You cards would you like to order?");}
            case 2 -> {System.out.println(this.getNameNumber() + " In 3 lines, please provide\n[1] Recipient name\n" +
                    "[2] Art symbol (a character)\n" +
                    "[3] Message to recipient\n");}
            default -> {}
        }
    }
    //
    // Language
    //

    //
    // @Override
    @Override
    public void sayGreeting(String studentName) {
        System.out.println(this.getNameNumber() +  "Hello, " + studentName + ". C-O-N-G-R-A-T-U-L-A-T-I-O-N-S!");
        System.out.println(this.getNameNumber() + Config.getDefaultUniversity().toUpperCase() + ". Way to go!");
    }
    //
}
