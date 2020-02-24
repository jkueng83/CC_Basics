package cc.jku.StringHelper;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class StringHelper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie einen Text ein: ");
        String scanText = scanner.nextLine();

        System.out.println("Ihre Eingabe lautet:");
        System.out.println(scanText);

        String testString = scanText;

        // Testen ob es ein Palindrome ist
        boolean isPalindrome = isPalindrome(testString);

        // Zeichen Zählen testen
        for (int i = 0; i < scanText.length(); i++) {

            System.out.println("Test Zeichen Zählen");

            countLetters(testString, testString.charAt(i));

        }

        String reverseString = reverseString(testString);
        //System.out.println("Reverse String: " + reverseString);

        printAmountOfLetters(testString);


    }

    private static void printAmountOfLetters(String inputString) {
        int[] numbersOfLetters = new int[128];
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < numbersOfLetters.length; j++) {
                char actualChar = inputString.charAt(i);

                if (actualChar == j) {
                    numbersOfLetters[j]++;
                    break;
                }

            }

        }

        for (int i = 0; i < numbersOfLetters.length; i++) {
            char charLatter = (char)i ;
            if (numbersOfLetters[i] > 0) {
                System.out.println(" Das Zeichen: " + charLatter + " ist " + numbersOfLetters[i] + " mal enthalten");
            }

        }

    }

    private static String reverseString(String inputString) {
        String reverseString = "";
        char[] charsArray = inputString.toCharArray();

        for (int i = charsArray.length - 1; i >= 0; i--) {
            reverseString += charsArray[i];
            //      inputString.charAt(i) ; // =+ inputString.substring(i);
            //reverseString =+ inputString.charAt(i);
            //System.out.println("Reverse String: " + reverseString);

        }
        System.out.println("Reverse String: " + reverseString);
        return reverseString;
    }


    private static boolean isPalindrome(String inputString) {
        System.out.println("Es wird überprüft, ob es ein Palindrom ist");
        boolean isPalindrome = true;

        char[] charArray = inputString.toCharArray();

        for (int i = 0; i <= (charArray.length / 2); i++) {

            char char1 = charArray[i];
            char char2 = charArray[(charArray.length - i - 1)];

            System.out.println("Nummer: " + i + " " + char1 + " - " + char2);

            if (!(char1 == char2)) {
                isPalindrome = false;
                break;
            }

        }

        if (isPalindrome) {
            System.out.println("Der Text ist ein Palindrome");
        } else {
            System.out.println("Der Text ist KEIN Palindrome");
        }
        return isPalindrome;
    }

    private static int countLetters(String inputString, char searchChar) {
        char[] chars = inputString.toCharArray();
        int counterChar = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == searchChar) {
                counterChar++;
            }

        }

        System.out.println("Das Zeichen " + searchChar + " ist " + counterChar + " mal enthalten");
        return counterChar;

    }
}
