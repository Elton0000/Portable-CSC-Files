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
            System.out.println("Please enter a valid player name. [" + errorCounter  + "] (! to exit)");
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
        System.out.println(Card.getDashes() + "\n");
        System.out.println(". . . . . \n");
    }
    //
    // Language
    //

    //
    // @Override
    @Override
    public void sayGreeting(String string) {

    }
    //
}
