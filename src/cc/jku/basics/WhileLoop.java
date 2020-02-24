package cc.jku.basics;

import java.util.Random;

public class WhileLoop {
    public static void main(String[] args) {

        //Aufgabe - While Loop
        //Erstelle ein Programm, dass Zufallszahlen zwischen 10 und 30 generiert.
        // Das Programm soll die Zufallszahlen zusammenzählen.
        // Sobald die Zahl 15 oder die Zahl 25 kommt, wird das Programm beendet und die Summe der vorherigen Zufallszahlen ausgegeben!

        boolean isFinished = false;
        Random random = new Random();
        int sumOfRandom = 0;

        while (!isFinished) {

            int randomNumber = random.nextInt(21) + 10;

            System.out.println("Random Number is: " + randomNumber);

            if ((randomNumber == 15) || (randomNumber == 25)) {
                isFinished = true;
            } else {
                sumOfRandom = sumOfRandom + randomNumber;
            }

        }

        System.out.println("The sum is: " + sumOfRandom);

    }
}
