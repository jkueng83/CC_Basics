package cc.jku.basics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BasicsVariables2 {
    public static void main(String[] args) {
        String banana = "Banane";
        String apple = "Apple";
        //float bananaPricePerKilo = 2.14 ;
        double bananaPricePerKilo = 2.14;
        double applePricePerKilo = 3.43;
        double averageWeightApple = 0.34;
        double averageWeightBanana = 0.22;
        DecimalFormat twoPlaces = new DecimalFormat("0.00");

        double numberOfApples = 8;

        double applePrice = numberOfApples * averageWeightApple * applePricePerKilo;

        System.out.print("Preis für " + Math.round(numberOfApples) + " Äpfel: " + applePrice + "\n");
        System.out.print("Preis für " + Math.round(numberOfApples) + " Äpfel: " + twoPlaces.format(applePrice) + "\n");

        double numberOfBananas = 17;
        double bananaPrice = numberOfBananas * averageWeightBanana * bananaPricePerKilo;
        System.out.print("Preis für " + Math.round(numberOfBananas) + " Bananen: " + (bananaPrice) + "\n");
        System.out.print("Preis für " + Math.round(numberOfBananas) + " Bananen: " + twoPlaces.format(bananaPrice) + "\n");

        System.out.print("Preis für 1 Tonne Äpfel: " + applePricePerKilo * 1000.0 + "\n");
        System.out.print("Preis für 1 Tonne Bananen: " + bananaPricePerKilo * 1000 + "\n");

        System.out.print("Eine Banane kostet: " + bananaPricePerKilo * averageWeightBanana + "\n");
        System.out.print("Ein Apfel kostet: " + applePricePerKilo * averageWeightApple + "\n");

        System.out.print("Bitte die Anzahl der Äpfel/Bananen eingeben: ");


        Scanner scan = new Scanner(System.in);
        int inputNumber = scan.nextInt();

        numberOfBananas = inputNumber;
        bananaPrice = numberOfBananas * averageWeightBanana * bananaPricePerKilo;
        System.out.print("Preis für " + Math.round(numberOfBananas) + " Bananen: " + bananaPrice + "\n");

        numberOfApples = inputNumber;
        applePrice = numberOfApples * averageWeightApple * applePricePerKilo;
        System.out.print("Preis für " + Math.round(numberOfApples) + " Äpfel: " + applePrice + "\n");

        boolean exitProgramm = false;
        while (!exitProgramm) {
            System.out.print("Bitte die Anzahl der Äpfel/Bananen eingeben: 0=Abbruch ");
            inputNumber = scan.nextInt();
            if (inputNumber == 0) {
                exitProgramm = true;
            } else {
                System.out.print("Eingabe" + inputNumber + "\n");
                numberOfBananas = inputNumber;
                bananaPrice = numberOfBananas * averageWeightBanana * bananaPricePerKilo;
                System.out.print("Preis für " + Math.round(numberOfBananas) + " Bananen: " + twoPlaces.format(bananaPrice) + "\n");

                numberOfApples = inputNumber;
                applePrice = numberOfApples * averageWeightApple * applePricePerKilo;
                System.out.print("Preis für " + Math.round(numberOfApples) + " Äpfel: " + twoPlaces.format(applePrice) + "\n");
            }

        }

    }
}
