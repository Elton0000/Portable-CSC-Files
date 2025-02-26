/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Student.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;

public final class Student extends Person {

    //
    // Instance Data Fields
    //
    private static String name;
    private static String email;

    //
    // Constructors
    //
    public Student() {

    }
    //
    // Instance Methods
    //
    public static void setName(String myName) {
        name = myName;
    }
    public static void setEmail(String myEmail) {
        email = myEmail;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    //
    // Additional Methods
    //

    //
    // Language
    //

    //
    // Override
    @Override
    public void sayGreeting(String string) {
        System.out.print("\n" + name + ": Welcome to my university!\n");
        System.out.println(Card.getDashes());
        System.out.printf("%-25s %-50s %n", "Official Name:", Config.getDefaultUniversity());
        System.out.printf("%-25s %-50s %n", "Motto in Latin:", "Experientia Docet");
        System.out.printf("%-25s %-50s %n", "Motto in English:", "Experience Teaches");
        System.out.printf("%-25s %-50s %n", "Type:", "Public");
        System.out.printf("%-25s %-50d %n", "Year of Establishment:", 1899);
        System.out.printf("%-25s %-50s %n", "Location:", "San Francisco, California, United States");
        System.out.printf("%-25s %-50s %n", "Address: ", "1600 Holloway Avenue, San Francisco, CA 94132");
        System.out.printf("%-25s %-50s %n", "Colors:", "Purple, Gold");
        System.out.printf("%-25s %-50s %n", "Nickname: ", "Gators");
        System.out.printf("%-25s %-50s %n", "Mascot:", "Gator");
        System.out.printf("%-25s %-50s %n", "Website:", "www.sfsu.edu ");
        System.out.println(Card.getDashes() + "\n");
    }
    //
}