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
    Arrow(
            new LinkedBag<String>(new String[] {" Here is one arrow: <IMG> -=>> </IMG>"}),
            null,
            null,
            null,
            null,
            null,
            null,
            null,2),
    Book(new LinkedBag<String>(new String [] {"A set of pages.", "A written work published in printed or electronic form."}),
            new LinkedBag<String>(new String [] {"To arrange for someone to have a seat on a plane.", "To arrange something on a particular date."}),
            null,
            null,
            null,
            null,
            null,
            null,2),
    Distinct(new LinkedBag<String>(new String[] {"A keyword in this assignment.","A keyword in this assignment.","A keyword in this assignment.","An advanced search option.","Distinct is a parameter in this assignment."}),
            null,
            new LinkedBag<String>(new String[] {"Familiar. Worked in Java.\",\"Unique. No duplicates. Clearly different or of a different kind."}),
            new LinkedBag<String>(new String[] {"Uniquely. Written \"distinctly\"."}),
            null,
            null,
            null,
            null,2),
    Reverse(new LinkedBag<String>(),
            new LinkedBag<String>(),
            new LinkedBag<String>(),
            null,
            null,
            null,
            null,
            null,2),
    Placeholder(new LinkedBag<String>(new String[] {"To be updated...","To be updated...","To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated...","To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated..."}),
            new LinkedBag<String>(new String[] {"To be updated..."}),2),
    DNE(null,null,null,null,null,null,null,null,3),
    q(null,null,null,null,null,null,null,null,1);

    private LinkedBag<String> nounDefinitions;
    private LinkedBag<String> verbDefinitions;
    private LinkedBag<String> adjectiveDefinitions;
    private LinkedBag<String> adverbDefinitions;
    private LinkedBag<String> conjunctionDefinitions;
    private LinkedBag<String> interjectionDefinitions;
    private LinkedBag<String> prepositionDefinitions;
    private LinkedBag<String> pronounDefinitions;
    private int code;

    DictionaryKeywords(LinkedBag<String> noun, LinkedBag<String> verb, LinkedBag<String> adjective,
                       LinkedBag<String> adverb, LinkedBag<String> conjunction, LinkedBag<String> interjection,
                       LinkedBag<String> preposition, LinkedBag<String> pronoun, int code) {
        this.code = code;
        if (code == 2) {
            this.nounDefinitions = noun;
            this.verbDefinitions = verb;
            this.adjectiveDefinitions = adjective;
            this.adverbDefinitions = adverb;
            this.conjunctionDefinitions = conjunction;
            this.interjectionDefinitions = interjection;
            this.prepositionDefinitions = preposition;
            this.pronounDefinitions = pronoun;
        }
    }

    public static void run() {

    }
    public static void ScanInput(String [] inputs) {
        try {
            valueOf(inputs[0]);
        }
        catch (IllegalArgumentException e) {
            System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
            System.out.println("|");
        }
    }
//    @Override
//    public String toString() {
//        return "HELLO";
//    }
}
