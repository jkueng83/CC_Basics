package cc.jku.VierGewinnt;

import java.awt.*;
import java.util.Scanner;

public class VierGewinnt {
    public static void main(String[] args) {
        // 6 Zeilen 7 Spalten
        int numberOfLines = 6;
        int numberOfColumns = 7;
        char fields[][] = new char[numberOfLines][numberOfColumns];
        char charPlayer1 = 'O';
        char charPlayer2 = 'X';


        boolean isFinish = false;
        boolean player2IsActive = false;
        printTheGame(numberOfLines, numberOfColumns, fields);

        while (!isFinish) {


            if (!player2IsActive) {
                selectAColumn(numberOfLines, numberOfColumns, fields, charPlayer1);
                player2IsActive = !player2IsActive;

                printTheGame(numberOfLines, numberOfColumns, fields);

                isFinish = gameIsFinish(fields, charPlayer1);

            } else {
                selectAColumn(numberOfLines, numberOfColumns, fields, charPlayer2);
                player2IsActive = !player2IsActive;

                printTheGame(numberOfLines, numberOfColumns, fields);

                isFinish = gameIsFinish(fields, charPlayer2);
            }


        }

    }

    private static boolean gameIsFinish(char[][] fields, char charPlayer) {
        // Zeilen überprüfen - horizontal - nebeneinander
        boolean gameIsFinish = false;
        int counter = 0;
        for (int line = 0; line < fields.length; line++) { //Zeile
            counter = 0;
            for (int column = 0; column < fields[0].length; column++) { //Spalte
                if (fields[line][column] == charPlayer) {
                    if ((counter == 0)) {
                        counter++;
                    } else if ((fields[line][column - 1] == charPlayer)) {
                        counter++;
                    } else {
                        counter = 0;
                    }
                }
            }
            if (counter >= 4) {
                gameIsFinish = true;
                break;
            }

        }

        if (!gameIsFinish) {
            // Spalten überprüfen - übereinander
            counter = 0;
            for (int column = 0; column < fields[0].length; column++) {
                counter = 0;
                for (int line = 0; line < fields.length; line++) {
                    if (fields[line][column] == charPlayer) {
                        if ((counter == 0)) {
                            counter++;
                        } else if ((fields[line - 1][column] == charPlayer)) {
                            counter++;
                        } else {
                            counter = 0;
                        }
                    }
                    if (counter >= 4) {
                        gameIsFinish = true;
                        break;
                    }

                }

            }
        }

        if (!gameIsFinish) {
            // Diagonale überprüfen
            for (int line = 0; line < fields.length - 3; line++) {
                for (int column = 0; column < fields[0].length - 3; column++) {
                    if ((fields[line][column] == charPlayer) && (fields[line + 1][column + 1] == charPlayer) && (fields[line + 2][column + 2] == charPlayer) && (fields[line + 3][column + 3] == charPlayer)) {
                        // links oben nach rechts unten
                        gameIsFinish = true;
                        break;
                    }
                    if ((fields[line + 3][column] == charPlayer) && (fields[line + 2][column + 1] == charPlayer) && (fields[line + 1][column + 2] == charPlayer) && (fields[line][column + 3] == charPlayer)) {
                        // links unten nach rechts oben
                        gameIsFinish = true;
                        break;
                    }

                }
                if (gameIsFinish) {
                    break;
                }
            }
        }

        if (gameIsFinish) {
            System.out.println("player # " + charPlayer + " # won the game");

        }

        return gameIsFinish;


    }

    private static void selectAColumn(int numberOfLines, int numberOfColumns, char[][] fields, char charPlayer) {

        boolean selectionOk = false;

        while (!selectionOk) {
            int selectedColumn = 0;
            boolean choiceIsWrong = false;


            System.out.println("player # " + charPlayer + " # select a column");

            selectedColumn = scannInt(selectedColumn) - 1;

            if ((0 > selectedColumn) || (selectedColumn >= numberOfColumns)) {
                choiceIsWrong = true;// Außerhalb vom Spielfeld
            }

            if (choiceIsWrong) {
                System.out.println("your choice is wrong");

            }

            if (!choiceIsWrong) {
                if ((fields[0][selectedColumn] != 0)) {
                    choiceIsWrong = true; //Spalte ist schon voll
                    System.out.println("the column is completed");
                }
            }


            if (!choiceIsWrong) {

                for (int line = fields.length - 1; line >= 0; line--) {
                    if ((fields[line][selectedColumn] == 0)) {

                        fields[line][selectedColumn] = charPlayer;
                        selectionOk = true;

                        break;

                    }

                }
            }
        }
    }

    private static int scannInt(int selectedColumn) {
        Scanner scanner = new Scanner(System.in);

        try {
            selectedColumn = scanner.nextInt();
        } catch (Exception e) {
            // Keine Zahl

        }
        return selectedColumn;
    }

    private static void printTheGame(int numberOfLines, int numberOfColumns, char[][] fields) {
        System.out.println();
        System.out.println("|\t1\t|\t2\t|\t3\t|\t4\t|\t5\t|\t6\t|\t7\t|");
        System.out.println();
        for (int i = 0; i < numberOfLines; i++) {
            System.out.print("|");
            for (int j = 0; j < numberOfColumns; j++) {
                if (fields[i][j] > 0)
                    System.out.print("\t" + fields[i][j] + "\t|");
                else
                    System.out.print("\t\t|");

            }
            System.out.println("\t" + i);
            System.out.println();
            System.out.println("---------------------------------------------------------");


        }
    }
}
