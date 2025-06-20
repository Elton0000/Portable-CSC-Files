import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictionaryKeywords.run();
        run();
    }

    private static void run() {
        int i = 1;
        Scanner input = new Scanner(System.in);
        System.out.print("Search [" + i + "]: ");
        String userInput = input.nextLine().trim().toLowerCase();
        inputReceiver(userInput);

        while (!userInput.equals("!q")) {
            i++;
            System.out.print("Search [" + i + "]: ");
            userInput = input.nextLine().trim().toLowerCase();
            inputReceiver(userInput);
        }
    }
    private static void inputReceiver(String userInput) {
        StringFormatter(userInput);
    }
    public static void StringFormatter (String input) {
        String [] inputs = input.split(" ");
        if (inputs.length <= 4) {
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = inputs[i].toUpperCase().charAt(0) + inputs[i].substring(1);
            }
            DictionaryKeywords.ScanInput(inputs);
        }
        else {
            DictionaryKeywords.ScanInput(new String[]{"!help"});
        }
        System.out.println("|");
    }
}