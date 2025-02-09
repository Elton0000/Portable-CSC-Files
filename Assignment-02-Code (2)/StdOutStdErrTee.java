/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StdOutStdErrTee.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.io.IOException;
import java.io.OutputStream;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"



// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class StdOutStdErrTee extends OutputStream {

    //
    // Static Data Fields
    //

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public StdOutStdErrTee() {

    }

    //
    // Instance Methods
    //
    public String getStdOutFilePath() {
        return "";
    }
    public String getStdErrFilePath() {
        return "";
    }
    //
    // Additional Methods
    //
    public static void startLog() {

    }

    //
    // Language
    //

    //
    // Override

    @Override
    public void write(int b) throws IOException {

    }

    //
}