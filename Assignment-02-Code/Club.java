/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.util.Scanner;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Club extends Organization {

    //
    // Instance Data Fields
    //
    private String clubName;
    private String clubShortName;
    private String colorCombo;
    //
    // Constructors
    //
    public Club() {

    }
    public Club(String clubName) {
        this.clubName = clubName;
        this.clubShortName = "SF Giants";
        this.colorCombo = "Orange, Black, Gold, Cream";
    }
    //
    // Static Methods
    //

    //
    // Instance Methods
    //
    public static String getOfficialSong() {
        return " ";
    }
    @Override
    public void displayAbout(){
        System.out.print("\n" + clubShortName + ": Welcome to the SAN FRANCISCO GIANTS!\n");
        System.out.println(Card.getDashes());
        System.out.printf("%-25s %-50s %n", "Club:", getClubName());
        System.out.printf("%-25s %-50s %n", "Short Name:", getClubShortName());
        System.out.printf("%-25s %-50d %n", "Established in:", 1883);
        System.out.printf("%-25s %-50s %n", "Colors:", getColorCombo());
        System.out.printf("%-25s %-50s %n", "Ballpark:", "Oracle Park");
        System.out.printf("%-25s %-50d %n", "World Series Titles:", 8);
        System.out.printf("%-25s %-50d %n", "NL Pennants:", 23);
        System.out.printf("%-25s %-50d %n", "Division Titles:", 8);
        System.out.printf("%-25s %-50d %n", "Wild Card Berths:", 3);
        System.out.printf("%-25s %-50s %n", "Owners:", 8);
        System.out.printf("%-25s %-50s %n", "President:", "Farhan Zaidi");
        System.out.printf("%-25s %-50s %n", "General Manager:", "Scott Harris");
        System.out.printf("%-25s %-50s %n", "Manager:", "Gabe Kapler");
        System.out.println(Card.getDashes() + "\n");
    }
    @Override
    public void displayMission(){
        Scanner input = new Scanner(System.in);
        System.out.print(clubShortName + ": Your first name and last name, please: ");
        Student.setName(input.nextLine());
        System.out.print(clubShortName + ": Your school email address, please: ");
        Student.setEmail(input.nextLine());
    }
    public String getClubName() {
        return clubName;
    }

    public String getColorCombo() {
        return colorCombo;
    }

    public String getClubShortName() {
        return clubShortName;
    }
    //
    // Additional Instance Methods
    //

    //
    // Language
    //
}