package cc.jku.basics;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TestPrintLineMethode {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean endProgramm = false;
        while (!endProgramm) {
            System.out.print("Bitte eine Zahl größer 0 eingeben: ");
            int inputNumber = scan.nextInt();
            // LocalDateTime.now();
            System.out.print("Systemzeit:" + LocalDateTime.now() + "\n");

            if (inputNumber > 0) {
                PrintLine(inputNumber);


            } else {
                System.out.print("Das Programm wird beendet!");
                endProgramm = true;

            }
        }


    }

    static void PrintLine(int intInput) {
        System.out.print("Deine Eingabe lautet: " + intInput + "\n");
    }
}
