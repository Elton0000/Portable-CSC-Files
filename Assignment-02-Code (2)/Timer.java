/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Timer.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
import java.util.Scanner;

public class Timer {

    //
    // Static Data Fields
    //

    //
    // Instance Data Fields
    //
    private String timeZone;
    //
    // Constructors
    //
    public Timer() {
    }
    public Timer(String timeZone) {

    }

    //
    // Static Methods
    //
    public static Timer setTimeZonePreference() {
        Scanner input = new Scanner(System.in);
        System.out.print("Time Zone: ");
        String timeType = input.nextLine().toLowerCase();
        while (!timeType.startsWith("p") && !timeType.startsWith("e") && !timeType.startsWith("c")) {
            System.out.print("Time Zone: INVALID time zone. Please enter your time zone.\n");
            System.out.print("Time Zone: ");
            timeType = input.nextLine().toLowerCase();
        }
        switch (timeType) {
            case "e": timeType = "est";
            case "c": timeType = "cst";
            default: timeType = "pst";
        }
        return new Timer(timeType);
    }
    //
    // Additional Static Methods
    //

    //
    // Instance Methods
    //
    public String getTimeZoneFormatted() {
        return this.timeZone;
    }
    //
    // Additional Instance Methods
    //

    //
    // Language
    //
}