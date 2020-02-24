package cc.jku.StringVersuche;

public class StringAufgabe2 {
    public static void main(String[] args) {

        String meinSubstring = "Ich heiße Johannes";

        int start = 0;
        int end = 5;

        System.out.println(meinSubstring.substring(start, end));
        String printString = "";

        for (int i = start; i < end; i++) {

            printString = printString + meinSubstring.charAt(i);
        }

        System.out.println(printString);

        if (printString.equals(meinSubstring.substring(start, end))) {
            //Überprüfung ob die Strings den selben wert beinhalten
            System.out.println("Die Strings beinhalten den selben Wert!");
        }

        System.out.println(printString.toUpperCase());// ALLES GROSS
        System.out.println(printString.toLowerCase());// alles klein

        printString = printString + printString;

        System.out.println(printString);


    }
}
