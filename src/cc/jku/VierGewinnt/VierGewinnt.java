package cc.jku.VierGewinnt;

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
        // Zeilen überprüfen - horizontal
        boolean gameIsFinish = false;
        int counter = 0;
        for (int line = 0; line < fields.length; line++) { //Zeile
            for (int column = 0; column < fields[0].length; column++) { //Spalte
                if (fields[line][column] == charPlayer) {
                    if ((column == 0)) {
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
                System.out.println("player # " + charPlayer + " # won the game");
                break;
            }

        }

        if(!gameIsFinish){
            // Spalten überprüfen
        }

        return gameIsFinish;


    }

    private static void selectAColumn(int numberOfLines, int numberOfColumns, char[][] fields, char charPlayer) {

        boolean selectionOk =false;

        while (!selectionOk) {
            int selectedColumn = 0;
            boolean choiceIsWrong = false;


            System.out.println("player # " + charPlayer + " # select a column");

            selectedColumn = scannInt(selectedColumn)-1;

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

                for (int line = fields.length-1 ; line >= 0; line--) {
                    if ((fields[line][selectedColumn] == 0)) {

                        fields[line][selectedColumn] = charPlayer;
                        selectionOk= true;

                        break;

                    }

                }
            }
        }
    }

    private static int scannInt(int selectedColumn) {
        Scanner scanner = new Scanner(System.in);

        try {
            selectedColumn = scanner.nextInt() ;
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
