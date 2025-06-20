public enum DictionaryKeywords {
    Noun(null,null,null,null,null,null,null,null,0),
    Verb(null,null,null,null,null,null,null,null,0),
    Adjective(null,null,null,null,null,null,null,null,0),
    Adverb(null,null,null,null,null,null,null,null,0),
    Conjunction(null,null,null,null,null,null,null,null,0),
    Interjection(null,null,null,null,null,null,null,null,0),
    Preposition(null,null,null,null,null,null,null,null,0),
    Pronoun(null,null,null,null,null,null,null,null,0),
    help(null,null,null,null,null,null,null,null,1),
    Arrow(new LinkedBag<>(new String[] {" Here is one arrow: <IMG> -=>> </IMG>"},"noun"),
            null,
            null,
            null,
            null,
            null,
            null,
            null,2),
    Book(new LinkedBag<>(new String [] {"A set of pages.", "A written work published in printed or electronic form."},"noun"),
            new LinkedBag<>(new String [] {"To arrange for someone to have a seat on a plane.", "To arrange something on a particular date."},"verb"),
            null,
            null,
            null,
            null,
            null,
            null,2),
    Distinct(new LinkedBag<>(new String[] {"A keyword in this assignment.","A keyword in this assignment.","A keyword in this assignment.","An advanced search option.","Distinct is a parameter in this assignment."},"noun"),
            null,
            new LinkedBag<>(new String[] {"Familiar. Worked in Java.\",\"Unique. No duplicates. Clearly different or of a different kind."},"adjective"),
            new LinkedBag<>(new String[] {"Uniquely. Written \"distinctly\"."},"adverb"),
            null,
            null,
            null,
            null,0),
    Reverse(new LinkedBag<>(new String[]{"A dictionary program's parameter.","Change to opposite direction.","The opposite.","To be updated...","To be updated...","To be updated...","To be updated..."},"noun"),
            new LinkedBag<>(new String[]{"Change something to opposite.","Go back","Revoke ruling.","To be updated...","To be updated...","Turn something inside out."},"verb"),
            new LinkedBag<>(new String[]{"On back side.","Opposite to usual or previous arrangement."},"adjective"),
            null,
            null,
            null,
            null,
            null,0),
    Placeholder(new LinkedBag<>(new String[] {"To be updated...","To be updated...","To be updated..."},"noun"),
            new LinkedBag<>(new String[] {"To be updated..."},"verb"),
            new LinkedBag<>(new String[] {"To be updated...","To be updated..."},"adjective"),
            new LinkedBag<>(new String[] {"To be updated..."},"adverb"),
            new LinkedBag<>(new String[] {"To be updated..."},"conjunction"),
            new LinkedBag<>(new String[] {"To be updated..."},"interjection"),
            new LinkedBag<>(new String[] {"To be updated..."},"preposition"),
            new LinkedBag<>(new String[] {"To be updated..."},"pronoun"),2),
    q(null,null,null,null,null,null,null,null,1);

    private final LinkedBag<String> noun;
    private final LinkedBag<String> verb;
    private final LinkedBag<String> adjective;
    private final LinkedBag<String> adverb;
    private final LinkedBag<String> conjunction;
    private final LinkedBag<String> interjection;
    private final LinkedBag<String> preposition;
    private final LinkedBag<String> pronoun;

    private static boolean reversed = false;
    private static boolean distinct = false;
    private static String partOfSpeech = null;
    private final int code;

    DictionaryKeywords(LinkedBag<String> noun, LinkedBag<String> verb, LinkedBag<String> adjective,
                       LinkedBag<String> adverb, LinkedBag<String> conjunction, LinkedBag<String> interjection,
                       LinkedBag<String> preposition, LinkedBag<String> pronoun, int code) {
        this.code = code;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.adverb = adverb;
        this.conjunction = conjunction;
        this.interjection = interjection;
        this.preposition = preposition;
        this.pronoun = pronoun;
    }

    public static void run() {
        System.out.println("! Loading data...\n" +
                            "! Loading completed...\n" +
                            "===== DICTIONARY 340 JAVA =====\n" +
                            "----- Keywords: " + DictionaryKeywords.values().length + "\n" +
                            "----- Definitions: " + getDefinitionTotal() + "\n");
    }

    public static int getDefinitionTotal() {
        int total = 0;
        for (DictionaryKeywords entry : DictionaryKeywords.values()) {
            if (entry.noun != null)
                total += entry.noun.getDefinitionTotal();
            if (entry.verb != null)
                total += entry.verb.getDefinitionTotal();
            if (entry.adjective != null)
                total += entry.adjective.getDefinitionTotal();
            if (entry.adverb != null)
                total += entry.adverb.getDefinitionTotal();
            if (entry.conjunction != null)
                total += entry.conjunction.getDefinitionTotal();
            if (entry.interjection != null)
                total += entry.interjection.getDefinitionTotal();
            if (entry.preposition != null)
                total += entry.preposition.getDefinitionTotal();
            if (entry.pronoun != null)
                total += entry.pronoun.getDefinitionTotal();
        }
        return total;
    }

    public static void ScanInput(String [] inputs) {
        int parameterIndex = 1;
        if (inputs[0].contains("!")) {
            testCommand(inputs[0].split("!")[1]);
        }
        else {
            DictionaryKeywords word = null;
            for (int i = 0; i < inputs.length; i++) {
                try {
                    if (i == 0) {
                        word = valueOf(inputs[i]);
                    }
                    else if (valueOf(inputs[i]).code == 0) {
                        configureSettings(inputs[i]);
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                }
                catch (IllegalArgumentException e) {
                    errorMessages(inputs[i],parameterIndex);
                }
                parameterIndex++;
            }
            if (word != null) {
                try {
                    processInputs(word);
                }
                catch (NullPointerException e) {
                    System.out.println("Here");
                    errorMessages(word.name(),0);
                }
            }
        }
    }

    private static void configureSettings (String input) {
        switch (input) {
            case "Distinct": {
                distinct = true;
                break;
            }
            case "Reverse": {
                reversed = true;
                break;
            }
            default: {
                if (valueOf(input).code == 0) {
                    partOfSpeech = input;
                }
            }
        }
    }

    private static void processInputs (DictionaryKeywords word) {
        System.out.println("|");
        if (!reversed && !distinct && partOfSpeech == null) {
            printAllDefinitions(word);
        }
        else {
            switch (partOfSpeech) {
                case "Noun" -> {
                    word.noun.printList(word.name(),distinct,reversed);
                }
                case "Verb" -> {
                    word.verb.printList(word.name(),distinct,reversed);
                }
                case "Adjective" -> {
                    word.adjective.printList(word.name(),distinct,reversed);
                }
                case "Adverb" -> {
                    word.adverb.printList(word.name(),distinct,reversed);
                }
                case "Conjunction" -> {
                    word.conjunction.printList(word.name(),distinct,reversed);
                }
                case "Interjection" -> {
                    word.interjection.printList(word.name(),distinct,reversed);
                }
                case "Preposition" -> {
                    word.preposition.printList(word.name(),distinct,reversed);
                }
                case "Pronoun" -> {
                    word.pronoun.printList(word.name(),distinct,reversed);
                }
            }
        }
        distinct = false;
        reversed = false;
        partOfSpeech = null;
    }

    private static void printAllDefinitions(DictionaryKeywords word) {
        if (word.noun != null || word.verb != null || word.adjective != null || word.adverb != null || word.conjunction != null || word.interjection != null || word.preposition != null || word.pronoun != null) {
            if (word.noun != null)
                word.noun.printList(word.name());
            if (word.verb != null)
                word.verb.printList(word.name());
            if (word.adjective != null)
                word.adjective.printList(word.name());
            if (word.adverb != null)
                word.adverb.printList(word.name());
            if (word.conjunction != null)
                word.conjunction.printList(word.name());
            if (word.interjection != null)
                word.interjection.printList(word.name());
            if (word.preposition != null)
                word.preposition.printList(word.name());
            if (word.pronoun != null)
                word.pronoun.printList(word.name());
        }
        else {
            throw new NullPointerException();
        }

    }

    private static void testCommand (String input) {
                switch (input) {
                    case "q" -> {
                        System.out.println("\n-----THANK YOU-----");
                        System.exit(0);
                    }
                    case "help" ->
                        System.out.println(
                                "1. A search key -then 2. An optional part of speech -then\n" +
                                        "3. An optional 'distinct' -then 4. An optional 'reverse'");
                    default -> {
                        System.out.println("<No command exists. Try the following> ");
                        for (DictionaryKeywords entry : values()) {
                            if (entry.code == 1) {
                                System.out.println("!" + entry.name());
                            }
                        }
                    }
                }
    }

    private static void errorMessages (String inputError,int parameterIndex) {
        System.out.println("|");
        switch (parameterIndex) {
            case 2 -> {
                System.out.println("<The entered " + parameterIndex + "nd parameter '" + inputError + "' is NOT a part of speech.>");
                System.out.println("<The entered " + parameterIndex + "nd parameter '" + inputError + "' is NOT 'distinct'.>");
                System.out.println("<The entered " + parameterIndex + "nd parameter '" + inputError + "' is NOT 'reverse'.>");
                System.out.println("<The " + parameterIndex + "rd parameter " + inputError + " was disregarded.>");
                System.out.println("<The " + parameterIndex + "nd parameter should be a part of speech or 'distinct' or 'reverse'.>");
                System.out.println("|");
            }
            case 3 -> {
                System.out.println("<The entered " + parameterIndex + "rd parameter '" + inputError + "' is NOT 'distinct'.>");
                System.out.println("<The entered " + parameterIndex + "rd parameter '" + inputError + "' is NOT 'reverse'.>");
                System.out.println("<The " + parameterIndex + "rd parameter should be a part of speech or 'distinct' or 'reverse'.>");
                System.out.println("|");
            }
            case 4 -> {
                System.out.println("<The entered " + parameterIndex + "th parameter '" + inputError + "' is NOT 'reverse'.>");
                System.out.println("<The entered " + parameterIndex + "th parameter '" + inputError + "' was disregarded.");
                System.out.println("|");
            }
            default -> {
                System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
                System.out.println("|");
                testCommand(help.name());
            }
        }
    }
}
