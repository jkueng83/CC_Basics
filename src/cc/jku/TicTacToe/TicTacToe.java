package cc.jku.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println();

        System.out.println("Welcome at TicTacToe");

        int numberOfLines = 3;
        int numberOfColumns = 3;

        char[][] fieldsInTicTacToe = new char[numberOfLines][numberOfColumns];

        fieldsInTicTacToe[0][0] = '_';
        fieldsInTicTacToe[0][1] = '_';
        fieldsInTicTacToe[0][2] = '_';

        fieldsInTicTacToe[1][0] = '_';
        fieldsInTicTacToe[1][1] = '_';
        fieldsInTicTacToe[1][2] = '_';

        fieldsInTicTacToe[2][0] = '_';
        fieldsInTicTacToe[2][1] = '_';
        fieldsInTicTacToe[2][2] = '_';

        printTheGame(fieldsInTicTacToe);

        char player1Char = 'O';
        char player2Char = 'X';

        boolean gameIsFinished = false;

        // Play the game
        while (!gameIsFinished) {
            gameSelectField(fieldsInTicTacToe, player1Char);
            printTheGame(fieldsInTicTacToe);

            gameIsFinished = checkGameIsFinished(fieldsInTicTacToe, player1Char);


        }


    }

    private static boolean checkGameIsFinished(char[][] fieldsInTicTacToe, char player1Char) {
        boolean gameIsFinish = false;

        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int j = 0; j < 3; j++) {
                if (fieldsInTicTacToe[i][j] == player1Char) {
                    counter++;
                } else {
                    break; // wenn es nicht identisch ist kann abgebrochen werden da man nicht mehr auf 3 Felder kommt!
                }
            }

            if (counter >= 3) {
                gameIsFinish = true;
                break;
            } else {
                counter = 0;
            }
        }
        if (!gameIsFinish) {

            for (int i = 0; i < 3; i++) {
                int counter = 0;

                for (int j = 0; j < 3; j++) {
                    if (fieldsInTicTacToe[j][i] == player1Char) {
                        counter++;
                    } else {
                        break; // wenn es nicht identisch ist kann abgebrochen werden da man nicht mehr auf 3 Felder kommt!
                    }
                }

                if (counter >= 3) {
                    gameIsFinish = true;
                    break;
                } else {
                    counter = 0;
                }

            }

        }

        if (!gameIsFinish) {
            // Diagonale Prüfen
            if ((fieldsInTicTacToe[0][0] == player1Char) && (fieldsInTicTacToe[1][1] == player1Char) && (fieldsInTicTacToe[2][2] == player1Char)) {
                gameIsFinish = true;
            } else if ((fieldsInTicTacToe[2][0] == player1Char) && (fieldsInTicTacToe[1][1] == player1Char) && (fieldsInTicTacToe[0][2] == player1Char)) {
                gameIsFinish = true;
            }
        }
        if (gameIsFinish) {
            System.out.println("player " + player1Char + " won the game!");
        }
        return gameIsFinish;
    }

    private static void gameSelectField(char[][] fieldsInTicTacToe, char player) {
        boolean isFinished = false;

        while (!isFinished) {


            System.out.println("enter your choice Player " + player);

            Scanner scanner = new Scanner(System.in);

            String stringScanner = scanner.nextLine();

            String[] values = stringScanner.split(",");

            //Zeilennummer der Eingabe
            int inputLineNumber = Integer.parseInt(values[0]);

            // Spaltennummer der Eingabe
            int inputCulumNumber = Integer.parseInt(values[1]);

            if ((inputLineNumber < 0) || (inputLineNumber > 2) || (inputCulumNumber < 0) || (inputCulumNumber > 2)) {
                System.out.println("Ihre Eingabe ist falasch Bitte geben sie einen gültigen Wert ein:");
            } else if ((fieldsInTicTacToe[inputLineNumber][inputCulumNumber] == 'X') || (fieldsInTicTacToe[inputLineNumber][inputCulumNumber] == 'O')) {
                System.out.println("Das Feld ist schon belegt. Bitte eine Andere Eingabe machen");
            } else {
                isFinished = true;
                fieldsInTicTacToe[inputLineNumber][inputCulumNumber] = player;
            }
        }
    }

    private static void printTheGame(char[][] fieldsInTicTacToe) {
        for (int i = 0; i < fieldsInTicTacToe.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < fieldsInTicTacToe.length; j++) {
                System.out.print("" + fieldsInTicTacToe[i][j] + " | ");

            }
            System.out.println();

        }
    }
}
