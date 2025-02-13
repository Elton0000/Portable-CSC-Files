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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timer {

    //
    // Static Data Fields
    //

    //
    // Instance Data Fields
    //
    private String timeZone;
    private String timeZoneLong;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    //
    // Constructors
    //
    public Timer() {
    }
    public Timer(String timeZone) {
        switch(timeZone) {
            case "est" -> {this.timeZone = "CST"; this.timeZoneLong = "Central Standard Time in Day Light Saving"; dateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));}
            case "cst" -> {this.timeZone = "EST"; this.timeZoneLong = "Eastern Standard Time in Day Light Saving";}
            default -> {this.timeZone = "PDT"; this.timeZoneLong = "Pacific Standard Time in Day Light Saving";}
        }
        this.timeZone = timeZone;
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
    public static DateFormat getFormattedTime() {
       return DateFormat.getDateTimeInstance();
    }
    //
    // Instance Methods
    //
    public String getTimeZoneFormatted() {
        return this.timeZoneLong;
    }
    //
    // Additional Instance Methods
    //
    @Override
    public String toString() {
        return "Timer: ";
    }
    //
    // Language
    //
}
