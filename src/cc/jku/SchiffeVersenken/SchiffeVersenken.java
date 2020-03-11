package cc.jku.SchiffeVersenken;

import java.util.Scanner;

public class SchiffeVersenken {

    private static enum DIRECTION {UP, DOWN, LEFT, RIGHT};

    public static void main(String[] args) {

        int xSize = 10; // Größe X-Achse
        int ySize = 10; // Größe Y-Achse
        char[][] shipPositionsPlayer1 = new char[ySize][xSize]; // Schiffpositionen die der Spieler 1 gesetzt hat
        char[][] gameFieldsPlayer1 = new char[ySize][xSize]; // Spielfeld vom Spieler 1
        char[][] shipPositionsPlayer2 = new char[ySize][xSize];
        char[][] gameFieldsPlayer2 = new char[ySize][xSize];

        makeDefaultSetingsForFields(gameFieldsPlayer1);
        makeDefaultSetingsForFields(gameFieldsPlayer2);


        shipPositionsPlayer1[5][5] = 'Z';
        shipPositionsPlayer1[5][6] = 'Z';
        shipPositionsPlayer1[5][7] = 'Z';

        printBattleship(shipPositionsPlayer1);

        printBattleship(gameFieldsPlayer1);

        boolean gameIsFinish = false;
        while (!gameIsFinish) {
            String playersChoice = playersChoice();

        /*
        das war zum testen


        int xPosition = playersChoice.charAt(0) - 65;//65 ist 'A'
        String yPositionString = playersChoice.substring(playersChoice.indexOf('/') + 1, playersChoice.length());
        int yPosition = Integer.parseInt(yPositionString) - 1;
        System.out.println(xPosition);
        System.out.println(yPosition);

        if (shipPositionsPlayer1[yPosition][xPosition] != 0) {
            gameFieldsPlayer2[yPosition][xPosition] = 'X';
        } else {
            gameFieldsPlayer2[yPosition][xPosition] = ' ';
        }
        */


            gameFieldsPlayer2 = gameFields(shipPositionsPlayer1, gameFieldsPlayer2, playersChoice);
            printBattleship(gameFieldsPlayer2);

            gameIsFinish = isGameFinish(shipPositionsPlayer1,gameFieldsPlayer2, "Test Player");


        }


    }

    private static boolean isGameFinish(char[][] shipPositions, char[][] gameFields, String player) {
        boolean isGameFinishIntern = true;
        for (int y = 0; y < gameFields.length; y++) {
            for (int x = 0; x < gameFields[0].length; x++) {
                if (((shipPositions[y][x]) != 0)) { // Schiff ist an der Position
                    if ((shipPositions[y][x] != gameFields[y][x])) { // Schiff wurde noch nicht getrofen
                        isGameFinishIntern = false;
                    }
                }
            }
        }

        if(isGameFinishIntern){
            System.out.println("Game is finisch! Player '" + player + "' won the game!");
        }

        return isGameFinishIntern;

    }


    private static char[][] gameFields(char[][] shipPositions, char[][] gameFields, String shootPosition) {
        boolean isShootOk = true;
        char[][] tempGameFields = gameFields;

        int xPosition = shootPosition.charAt(0) - 65;//65 ist 'A'
        String yPositionString = shootPosition.substring(shootPosition.indexOf('/') + 1, shootPosition.length());
        int yPosition = Integer.parseInt(yPositionString) - 1;
        if ((xPosition < 0) || (xPosition > shipPositions[0].length)) {
            isShootOk = false;
        } else if ((yPosition < 0) || (yPosition > shipPositions.length)) {
            isShootOk = false;
        }

        if (!isShootOk) {
            isShootOk = false;
        } else if ((tempGameFields[yPosition][xPosition]) == '-') {
            if ((shipPositions[yPosition][xPosition]) == ' ') { // kein Schiff
                tempGameFields[yPosition][xPosition] = ' ';
                System.out.println("Kein treffer!");
            } else { // Schiff getroffen
                tempGameFields[yPosition][xPosition] = shipPositions[yPosition][xPosition];
                System.out.println("Schiff getroffen!");
            }
        } else {
            isShootOk = false;
        }

        return tempGameFields;


    }

    private static String playersChoice() {
        System.out.println("Koordinate eingeben (x/y) ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        inputString = inputString.toUpperCase();
        inputString = inputString.replace(" ", ""); //Leerzeichen entfernen
        return inputString;
    }

    private static void makeDefaultSetingsForFields(char[][] gameFieldsPlayer) {
        for (int y = 0; y < gameFieldsPlayer.length; y++) {
            for (int x = 0; x < gameFieldsPlayer[0].length; x++) {
                gameFieldsPlayer[y][x] = '-';
            }
        }
    }

    private static void printBattleship(char[][] field) {
        System.out.print("|\t\t|");
        char charPrint = 65; // 65=='A'
        for (byte x = 0; x < field[0].length; x++) {

            System.out.print(" " + charPrint + " |");  // Beschriftung X-Achse drucken
            charPrint += 1; // nächstes Zeichen - Es wird mit A gestartet , dann B , ....

        }

        System.out.print("\n");// neue Zeile

        for (int y = 0; y < field.length; y++) {
            System.out.print("|\t" + (y + 1) + "\t| ");
            for (int x = 0; x < field[0].length; x++) {
                charPrint = field[y][x];
                if (charPrint == 0) {
                    charPrint = ' ';
                }
                System.out.print(charPrint + " | ");

            }
            System.out.print("\n");

        }
        System.out.println();

    }
}
