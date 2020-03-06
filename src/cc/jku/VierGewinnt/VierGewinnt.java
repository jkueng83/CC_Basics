package cc.jku.VierGewinnt;

import java.awt.*;
import java.util.Random;
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
        printTheGame(fields);

        while (!isFinish) {


            if (!player2IsActive) {
                selectAColumn(fields, charPlayer1);
                player2IsActive = !player2IsActive;

                printTheGame(fields);

                isFinish = gameIsFinish(fields, charPlayer1);

            } else {
                //selectAColumn(numberOfLines, numberOfColumns, fields, charPlayer2);
                computerMakeChoice(fields, charPlayer2);
                player2IsActive = !player2IsActive;

                printTheGame(fields);

                isFinish = gameIsFinish(fields, charPlayer2);
            }


        }

    }

    private static void computerMakeChoice(char[][] fields, char charComputer) {
        int numberOfLines = fields.length;
        int numberOfColumns = fields[0].length;
        int actualColumn = numberOfColumns / 2;
        boolean computerMadeChoice = false;


        boolean isSelectinOk = false;
        int selectedColumnComputer = -1;

        while (!isSelectinOk) {


            for (int numberOfCharInLine = 3; numberOfCharInLine > 0; numberOfCharInLine--) {
                int counter = 0;
                for (int line = fields.length-1; line >= 0; line--) {
                    counter = 0;
                    for (int column = 0; column < fields[0].length; column++) {
                        if (fields[line][column] == charComputer) {
                            // Zeichen zählen die in einer Zeile nebeneinander sind
                            if (counter == 0) {
                                counter++;
                            } else if ((fields[line][column - 1] == charComputer)) {
                                counter++;
                            } else {
                                counter = 0;
                            }

                            if (counter >= numberOfCharInLine) {
                                //Wenn möglich zusätzliches zeichen setzen
                                if (column < (fields[0].length - 1)) {
                                    if (fields[line][column + 1] == 0) &&((unterste ZEile)||(Feld darunter efüllt) ) {
                                        // Wenn nach den Zeichen eine leeres Feld ist,
                                        // dann wird der Stein in diese Spalte geworfen
                                        selectedColumnComputer = column + 1;
                                        computerMadeChoice = true;
                                    }
                                }
                            }

                        }

                    }

                }


            }


            if (!computerMadeChoice) {

                Random random = new Random();
                selectedColumnComputer = random.nextInt(7);

            }


            System.out.println("the computer selected column: " + selectedColumnComputer);

            isSelectinOk = isSelectionOk(fields, charComputer, selectedColumnComputer);

        }




        /*

        if (fields[numberOfLines - 1][actualColumn] == 0) {
            fields[numberOfLines - 1][actualColumn - 1] = charComputer;
            computerMadeChoice = true ;
        }
        */

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

    private static void selectAColumn(char[][] fields, char charPlayer) {

        boolean selectionOk = false;

        while (!selectionOk) {
            int selectedColumn = 0;
            boolean choiceIsWrong = false;

            System.out.println("player # " + charPlayer + " # select a column");

            selectedColumn = scannInt(selectedColumn);

            if ((0 >= selectedColumn) || (selectedColumn > fields[0].length)) {
                choiceIsWrong = true;// Außerhalb vom Spielfeld
            }

            if (choiceIsWrong) {
                System.out.println("your choice is wrong");

            }

            selectionOk = isSelectionOk(fields, charPlayer, selectedColumn);
        }
    }

    private static boolean isSelectionOk(char[][] fields, char charPlayer, int selectedColumn) {

        boolean selectionOk = false;

        if ((fields[0][selectedColumn] != 0)) {
            //Spalte ist schon voll
            System.out.println("the column is completed");
        }

        for (int line = fields.length - 1; line >= 0; line--) {
            if ((fields[line][selectedColumn] == 0)) {

                fields[line][selectedColumn] = charPlayer;
                selectionOk = true;

                break;

            }

        }

        return selectionOk;
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

    private static void printTheGame(char[][] fields) {
        System.out.println();
        System.out.println("|\t0\t|\t1\t|\t2\t|\t3\t|\t4\t|\t5\t|\t6\t|");
        System.out.println();
        for (int i = 0; i < fields.length; i++) {
            System.out.print("|");
            for (int j = 0; j < fields[0].length; j++) {
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
