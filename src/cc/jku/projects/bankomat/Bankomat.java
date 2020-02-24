package cc.jku.projects.bankomat;

import java.util.Scanner;

public class Bankomat {


    public static void main(String[] args) {
        /*
        Aufgabe (Summary) Bankomat
        Diese Aufgabe setzt sich aus allen gelernten Inhalten zusammen!
                Erstelle ein Programm, das einen Bankomaten simuliert. Folgende Möglichkeiten gibt es:
        1. Einzahlen
        2. Abheben
        3. Kontostand
        4. Beenden
        Folgendes Video zeigt dir die Funktionsweise

        DRY dont repeat yourself
         */
        Scanner scan = new Scanner(System.in);
        int balance = 0;
        boolean isFinished = false;

        while (!isFinished) {

            printOptions();
            int scanValue = 0;

            switch (getCashMaschineFunction()) {
                case 1:
                    // Einzahlen

                    int deposit = getDepositAmount();
                    balance = balance + deposit;
                    //System.out.println("Ihr neuer Kontostand beträgt: " + balance + " €" );

                    printBalance(balance);

                    break;
                case 2: // Abheben
                    //System.out.println("Bitte geben Sie den Betrag ein, den sie abheben möchten: ");
                    //scanValue = scan.nextInt();
                    int payOutAmount = getPayOutAmount();
                    balance = balance - payOutAmount;
                    //System.out.println("Sie haben " + scanValue + " € abgehoben.");
                    // System.out.println("Ihr neuer Kontostand beträ1gt: " + balance + " €");
                    printBalance(balance);
                    break;
                case 3: // Kontostand
                    //System.out.println("Ihr Kontostand beträgt: " + balance + " €");
                    printBalance(balance);
                    break;
                case 4: // Beenden
                    System.out.println("Das Programm wird beendet.");
                    isFinished = true;
                    break;
                default:
                    System.out.println("Ihre Eingabe ist nicht zulässig.");
                    break;
            }

            System.out.println(""); // Leerzeile erstellen

        }
        System.out.println("Das Programm wurde beendet!!!");


    }

    private static void printOptions() {
        System.out.println("Was wollen Sie machen?");
        System.out.println("1. Einzahlen");
        System.out.println("2. Abheben");
        System.out.println("3. Kontostand");
        System.out.println("4. Beenden");
    }

    private static int getDepositAmount() {
        //Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Betrag ein, den sie einzahlen möchten: ");
        int scanValue = scanAndCheckIfValueIsIntAndPositive(); //scan.nextInt();
        System.out.println("Sie haben " + scanValue + " € eingezahlt.");
        return scanValue;
    }

    private static int getPayOutAmount() {
        //Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Betrag ein, den sie abheben möchten: ");
        int scanValue = scanAndCheckIfValueIsIntAndPositive();// scan.nextInt();
        System.out.println("Sie haben " + scanValue + " € abgehoben.");
        return scanValue;
    }

    private static int getCashMaschineFunction() {
        Scanner scan = new Scanner(System.in);
        int chashMachineFunction = 0;
        try {
            chashMachineFunction = scan.nextInt();
        } catch (Exception e) {
            return -1;
        }
        return chashMachineFunction;
    }

    private static void printBalance(int balance) {
        System.out.println("Ihr neuer Kontostand beträgt: " + balance + " €");
    }

    private static int scanAndCheckIfValueIsIntAndPositive() {
        Scanner scan = new Scanner(System.in);
        int scannedInt = 0;

        try {
            scannedInt = scan.nextInt();
        } catch (Exception e) {
            return 0;
        }

        if (scannedInt < 0) {
            scannedInt = 0;
            System.out.println("Werte < 0 sind nicht möglich!");
        }
        return scannedInt;
    }
}
