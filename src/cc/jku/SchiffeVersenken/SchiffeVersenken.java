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

        String playersChoice = playersChoice();


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

        printBattleship(gameFieldsPlayer2);


    }

    private static boolean isShootOk(char[][] shipPositions, char[][] gameFields, String shootPosition) {
        boolean isShootOk = true;

        int xPosition = shootPosition.charAt(0) - 65;//65 ist 'A'
        String yPositionString = shootPosition.substring(shootPosition.indexOf('/') + 1, shootPosition.length());
        int yPosition = Integer.parseInt(yPositionString) - 1;
        if ((xPosition < 0) || (xPosition > shipPositions[0].length)) {
            isShootOk = false;

        } else if ((yPosition < 0) || (yPosition>shipPositions.length)){
            isShootOk = false;
        }

        return isShootOk;


    }

    private static String playersChoice() {
        System.out.println("Koordinate eingeben (x/y) ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        inputString = inputString.toUpperCase();
        inputString = inputString.replace(" ", ""); //Leerzeichen entfernen
        return inputString;
    }

    private static void makeDefaultSetingsForFields(char[][] gameFieldsPlayer1) {
        for (int y = 0; y < gameFieldsPlayer1.length; y++) {
            for (int x = 0; x < gameFieldsPlayer1[0].length; x++) {
                gameFieldsPlayer1[y][x] = '-';
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
