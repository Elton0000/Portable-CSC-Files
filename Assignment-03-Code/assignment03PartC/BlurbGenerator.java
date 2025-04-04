/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartC;
import java.util.Random;
public class BlurbGenerator {

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        Random generator = new Random();
        int numOfWhatzits = generator.nextInt(1,5);
        String blurb = makeWhoozit();
        System.out.println(numOfWhatzits);
        if (numOfWhatzits > 1) {
            blurb += makeMultiWhatzits(numOfWhatzits);
        }
        else {
            blurb += makeWhatzit();
        }
        return blurb;
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
        String whoozit = "x";
        int numOfY = new Random().nextInt(0,5);
        whoozit += makeYString(numOfY);
        return whoozit;
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString(int numOfY) {
        String y = "y";
        if (numOfY == 0) {
            return "";
        }
        else if (numOfY == 1) {
            return y;
        }
        return y += makeYString(numOfY - 1);
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits(int numOfWhatzits) {
        String whatzit = makeWhatzit();
        if (numOfWhatzits == 1) {
            return makeWhatzit();
        }
        return whatzit += makeMultiWhatzits(numOfWhatzits - 1);
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit() {
        String whatzit = "q";
        int append = new Random().nextInt(0,2);
        if (append == 0) {
            whatzit += "z";
        }
        else {
            whatzit += "d";
        }
        whatzit += makeWhoozit();
        return whatzit;
    }
}