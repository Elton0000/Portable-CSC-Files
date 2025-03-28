/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Language.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.util.Scanner;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// java.util.ResourceBundle
// - ResourceBundle is a valid approach to internationalization.
// - ResourceBundle is not required.
// - Other approaches to internationalization are available. Some of these approaches are
// more straightforward and more relevant to new CSC 220 students then ResourceBundle is.
// - Yet, curiosity for intelligence is always highly encouraged:
// https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/ResourceBundle.html

public final class Language {
    //
    // Static Data Fields
    //    
    private static final String defaultAlienSound = "~ ąļīæń ~ "; // Default

    //
    // Instance Data Fields
    //
    private String language;
    //
    // Constructors
    //
    public Language() {
    }
    public Language(String language) {

        switch (language.toLowerCase()) {
            case "alien" -> this.populateAlienPhrases();            // Supported
            case "chinese" -> this.populateChinesePhrases();        // Future implementation
            case "french" -> this.populateFrenchPhrases();          // Future implementation
            case "spanish" -> this.populateSpanishPhrases();        // Future implementation
            case "future" -> this.populateYourLanguagePhrases();    // Future implementation
            default -> this.populateEnglishPhrases();               // Supported
        }

    }

    //
    // Static Methods
    //
    public static void displayAppHeader() {
        Card.printCardOpening();
    }
    public static Language setLanguagePreference() {
        Scanner input = new Scanner(System.in);
        System.out.print("Language: ");
        String userInput = input.nextLine().toLowerCase();
        while (!userInput.startsWith("eng") && !userInput.startsWith("chi") && !userInput.startsWith("fre") && !userInput.startsWith("spa") &&!userInput.startsWith("ali")) {
            System.out.print("Language: UNSUPPORTED language. Please enter your language.\n");
            System.out.print("Language: English, Chinese, French, Spanish, Alien\n");
            System.out.print("Language: ");
            userInput = input.nextLine().toLowerCase();
        }

        switch (userInput) {
            case "eng" -> userInput = "english";
            case "chi" -> userInput = "chinese";
            case "fre" -> userInput = "french";
            case "spa" -> userInput = "spanish";
            default -> userInput = "alien";
        }
        return new Language(userInput);
    }
    //
    // Additional Static Methods
    //

    //
    // Instance Methods
    //
    public void populateAlienPhrases() {
        this.language = defaultAlienSound;
    }
    public void populateChinesePhrases() {
        populateEnglishPhrases();
    }
    public void populateFrenchPhrases() {
        populateEnglishPhrases();
    }
    public void populateSpanishPhrases() {
        populateEnglishPhrases();
    }
    public void populateYourLanguagePhrases() {
        populateEnglishPhrases();
    }
    public void populateEnglishPhrases() {
        this.language = "ENGLISH";
    }

    public String getLanguage() {
        return this.language;
    }
    public String getUniversityPhrase(int x) {
        return Config.getDefaultUniversity();
    }
    public String getClubPhrase(int x) {
        return Config.getDefaultClub();
    }
    public String getConfigPhrase(int x) {
        switch (x) {
                case 1 -> {return "Language: ";}
                case 2 -> {return "Time Zone: ";}
                case 3 -> {return "Color Sequences: ";}
                case 4 -> {return "Standard Output Log: ";}
                case 5 -> {return "Standard Error Log: ";}
                case 6 -> {return "Receipt Log: ";}
                case 7 -> {return "./src/assignment02PartB/log/Receipt-*-*.log";}
                case 8 -> {return "Default University: ";}
                case 9 -> {return "Default Club: ";}
                default -> {return Card.getDashes();}
            }
    }
    public String getGreetingPhrase(int x) {
        switch (x) {
            case 1 -> {return " \n";}
            case 2 -> {return " \n";}
            case 3 -> {return " \n";}
            case 4 -> {return " \n";}
            case 5 -> {return " \n";}
            case 6 -> {return " \n";}
            case 7 -> {return " \n";}
            case 8 -> {return " \n";}
            case 9 -> {return " \n";}
            default -> {return Card.getDashes();}
        }
    }

    @Override
    public String toString() {
        return "Language: ";
    }
    //
    // Language
    //
}