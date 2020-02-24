package cc.jku.projects.CubeGame;

import java.util.Random;
import java.util.Scanner;

public class CubeGame {

    public static void main(String[] args) {
        /*
        Aufgabe Würfelspiel

        Erstelle ein Würfelspiel!
        Du spielst gegen den Computer. Wenn das Spiel startet (mit einem kleinen Menü), hat der Spieler 6 Würfe. Er spielt dabei gegen den Computer. Wenn die Augensumme höher ist als jene des Computers hat der Spieler gewonnen, ansonsten der Computer.
        */

        int pointsComputer = 0;
        int pointsPlayer = 0;
        boolean isFinished = false;
        int numberOfGames = 6;
        int actualNumberOfGame = 1;

        printOptions();

        numberOfGames = changeNumberOfGames(numberOfGames);

        if (numberOfGames < 1) {
            isFinished = true;
        }

        playGame(pointsComputer, pointsPlayer, isFinished, numberOfGames, actualNumberOfGame);

        System.out.println("\nDas Spiel ist beendet.");
    }



    private static int changeNumberOfGames(int numberOfGames) {
        Scanner scannerString = new Scanner(System.in);
        String string = "";

        System.out.println("Geben sie 'ja' ein, wenn sie die Anzahl der Spiele ändern wollen, sonst 'nein':");

        string = scannerString.next();

        if (string.equals("ja")) {
            System.out.println("Wie viele Spiele wollen Sie spielen?");
            numberOfGames = getIntValueFromScanner();
            System.out.println("Die Anzahl der Spiele wurde auf " + numberOfGames + " geändert\n");
        }
        return numberOfGames;
    }

    private static void playGame(int pointsComputer, int pointsPlayer, boolean isFinished, int numberOfGames, int actualNumberOfGame) {
        while (!isFinished) {

            startGame(actualNumberOfGame);

            int randomNumberComputer = getRendomNumber();
            int randomNumberPlayer = getRendomNumber();
            System.out.println("\nZufallszahl Spieler: " + randomNumberPlayer);
            System.out.println("Zufallszahl Computer: " + randomNumberComputer);

            if (randomNumberComputer > randomNumberPlayer) {
                pointsComputer++;
            } else if (randomNumberPlayer > randomNumberComputer) {
                pointsPlayer++;
            }

            System.out.println("Spielstand Spieler/Computer: " + pointsPlayer + "/" + pointsComputer + "\n");

            actualNumberOfGame++;

            if (actualNumberOfGame > numberOfGames) {
                isFinished = true;
                if (pointsComputer > pointsPlayer) {
                    System.out.println("Der Computer hat gewonnen.");
                } else if (pointsPlayer > pointsComputer) {
                    System.out.println("Der Spieler hat gewonnen.");
                } else {
                    System.out.println("Unentschieden!");
                }
            }
        }
    }

    private static void printOptions() {
        System.out.println("");
        System.out.println("########################################");
        System.out.println("####  Willkommen beim Würfelspiel!  ####");
        System.out.println("########################################");
        System.out.println("");
        System.out.println("Du spielst gegen den Computer");
        System.out.println("Es werden Zufallszahlen gewürfelt.");
        System.out.println("Wenn deine Augensumme höher ist als die vom Computer, dann bekommst du einen Punkt, ansonsten der Computer.");
        System.out.println("Es werden 6 Spiele gespilet." + "\n");
    }

    private static int getRendomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        return randomNumber;
    }

    private static void startGame(int gameNumber) {

        boolean isFinished = false;

        while (!isFinished) {
            System.out.print("Spiel " + gameNumber + " mit der Eingabe von " + gameNumber + " starten:");
            int scanValue = getIntValueFromScanner();
            if (scanValue == gameNumber) {
                isFinished = true;

            }

        }

    }

    private static int getIntValueFromScanner() {

        Scanner scan = new Scanner(System.in);
        int intValue = 0;

        try {
            intValue = scan.nextInt();
        } catch (Exception e) {
            return -1;
        }
        return intValue;
    }
}
