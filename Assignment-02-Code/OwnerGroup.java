/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OwnerGroup.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class OwnerGroup extends Organization{
    //
    // Data fields
    //
    private static String title = "San Francisco Baseball Associates LLC";
    //
    // Constructors
    //
    public OwnerGroup() {
    }

    //
    // Instance Methods
    //
    @Override
    public void displayAbout(){

    }
    @Override
    public void displayMission(){

    }
    public static String getTitle () {
        return title;
    }
    //
    // Override
    //
}