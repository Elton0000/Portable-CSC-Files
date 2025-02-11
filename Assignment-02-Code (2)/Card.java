/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Card {

    //
    // Instance Data Fields
    //
    private int artSize = 0;     // Please change artSize, if needed, to get an identical output
    private String artFont = ""; // Please change artFont, if needed, to get an identical output
    private static String dashes = "----------------------------------------------------------------------";
    private static String thankYou = "---------------------- SF GIANTS THANK YOU ---------------------------";
    private static String poweredBy = "powered by CSC 220 @ SFSU";

    //
    // Constructors
    //
    public Card() {
    }

    //
    // Instance Methods
    //

    //
    // Additional Instance Methods
    //
    public static void printCardOpening (){
        System.out.printf("%25s%n %25s%n %25s%n %69s%n", dashes,thankYou,dashes,poweredBy);
    }

    //
    // Language
    //

}
