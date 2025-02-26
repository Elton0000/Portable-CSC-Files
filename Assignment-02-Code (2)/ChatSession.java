/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.util.Scanner;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class ChatSession {

    //  Static Data Fields

    //
    // Instance Data Fields
    //
    private Club Club;
    private University University;
    //
    // Constructors
    //
    public ChatSession() {
    }
    public ChatSession(Club myClub, University myUniversity) {
        this.Club = new Club(Config.getDefaultClub());
        this.University = new University(Config.getDefaultUniversity());
    }

    //
    // Instance Methods
    //
    //
    // Additional Instance Methods
    //
    private void startChatSession() {
        Club.displayAbout();
        Club.displayMission();
        connectChatters();
    }
    private void connectChatters() {
        Scanner input = new Scanner(System.in);
        Student myStudent = new Student();
        myStudent.sayGreeting();
        System.out.print(Club.getClubShortName() + ": Thank you. Now who would you like to speak with?\n");
        System.out.print(myStudent.getName() + ": ");
        Player myPlayer = Player.getPlayer();
        System.out.print(Club.getClubShortName() + ": Thank you. We are connecting you with " + myPlayer.getPlayerName() + "...\n. . . . . \n");
        System.out.println(Card.getDashes());
        chat(myStudent,myPlayer);
    }
    private void chat(Student myStudent, Player myPlayer) {
        myPlayer.displayAbout();
    }
    private void runQuiz() {
    }
    private void stopChatSession() {
    }
    public void runChatSession() {
        Messenger.getConfig().getTimer().getFormattedTime();
        //start I/O log?
        startChatSession();
    }

    //
    // Language
    //
}