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
        chat(myStudent,myPlayer);
        runQuiz(myStudent);
    }
    private void chat(Student myStudent, Player myPlayer) {
        Scanner input = new Scanner(System.in);
        myPlayer.displayAbout();
        myPlayer.sayGreeting(myStudent.getName());
        System.out.print(myStudent.getName() + ": ");
        input.nextLine();
        int howMany = myPlayer.cardAmount(myStudent);
        myPlayer.automated(2);
        myPlayer.getCardInfo(myStudent,howMany);
        System.out.print(myStudent.getName() + ": Very nice! Thank you, " + myPlayer.getPlayerName());
        System.out.print(myPlayer.getNameNumber() + ":  Thank you again, " + myStudent.getName() + ". See you at your graduation ceremony!\n");
    }
    private void runQuiz(Student myStudent) {
        Scanner input = new Scanner(System.in);
        Quiz newQuiz = new Quiz();
        newQuiz.quizQuestion(1);
        int tries = 2;
        int questionNum = 2;
        while (tries > 0 && questionNum < 8) {
            newQuiz.quizQuestion(questionNum);
            System.out.print(myStudent.getName() + ": ");
            String stuAnswer = input.nextLine();
            if (!newQuiz.quizAnswer(questionNum - 1, stuAnswer)) {
                tries--;
            }
            questionNum++;
        }
        if (tries > 0) {
            System.out.println("*** Congrats! You won FREE TICKETS to SF GIANTS Games ***");
        }
        else {
            System.out.println("____ Please try again at your graduation ceremony. ____\n");
        }
        stopChatSession();
    }
    private void stopChatSession() {

    }
    public void runChatSession() {
        Messenger.getConfig().getTimer().getFormattedTime();
        //start I/O log?
        startChatSession();
        Messenger.getConfig().getTimer().getFormattedTime();
    }

    //
    // Language
    //
}