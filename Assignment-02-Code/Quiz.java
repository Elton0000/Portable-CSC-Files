/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Quiz.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Quiz {

    //
    // Instance Data Fields
    //
    private Club Club;
    //
    // Constructors
    //
    public Quiz() {
        this.Club = new Club(Config.getDefaultClub());
    }
    //
    // Instance Methods
    //
    public void quizQuestion(int questionNum) {
        switch (questionNum) {
            case 1 -> System.out.println(Club.getClubShortName() + ": *** FREE TICKETS to SF GIANTS Games *** _ 1 miss allowed _");
            case 2 -> System.out.println(Club.getClubShortName() + ": Which type of class has 'protected' constructors?");
            case 3 -> System.out.println(Club.getClubShortName() + ": What type of method did Java 8 add to 'interface'?");
            case 4 -> System.out.println(Club.getClubShortName() + ": What new keyword did Java 13 add to 'switch' statement?");
            case 5 -> System.out.println(Club.getClubShortName() + ": In Java 15, what keyword pairs with 'sealed'?");
            case 6 -> System.out.println(Club.getClubShortName() + ": Giants in Spanish?");
            case 7 -> System.out.println(Club.getClubShortName() + ": Take me out to the...?");
            default -> {}
        }
    }
    public boolean quizAnswer (int questionNum, String answer) {
        switch (questionNum) {
            case 1 -> {
                if (answer.equals("abstract")) {
                    questionNum = 1;
            }
                else {
                    questionNum = -1;
                }
            }
            case 2 -> {
                if (answer.equals("default")) {
                    questionNum = 1;
                }
                else {
                    questionNum = -1;
                }
            }
            case 3 -> {
                if (answer.equals("yield")) {
                    questionNum = 1;
                }
                else {
                    questionNum = -1;
                }
            }
            case 4 -> {
                if (answer.equals("permits")) {
                    questionNum = 1;
                }
                else {
                    questionNum = -1;
                }
            }
            case 5 -> {
                if (answer.equals("gigantes")) {
                    questionNum = 1;
                }
                else {
                    questionNum = -1;
                }
            }
            case 6 -> {
                if (answer.equals("ball game")) {
                    questionNum = 1;
                }
                else {
                    questionNum = -1;
                }
            }
            default -> {}
        }

        if (questionNum == -1) {
            System.out.println(Club.getClubShortName() + ": Oops. . .");
            return false;
        }
        else {
            System.out.println(Club.getClubShortName() + ": Correct !");
            return true;
        }
    }
    //
    // Additional Instance Methods
    //

    //
    // Language
    //
}