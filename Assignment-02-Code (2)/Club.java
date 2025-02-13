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
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Club extends Organization {

    //
    // Instance Data Fields
    //
    private String clubName;
    //
    // Constructors
    //
    public Club() {
        super();
    }
    public Club(String clubName) {
        this.clubName = clubName;
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

    }
    @Override
    public void displayMission(){

    }
    //
    // Additional Instance Methods
    //

    //
    // Language
    //
}