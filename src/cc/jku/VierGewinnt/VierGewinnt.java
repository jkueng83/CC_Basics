package cc.jku.VierGewinnt;

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

        boolean isPlayer2Computer = isPlayer2Computer();


        boolean isFinish = false;
        boolean player2IsActive = false;
        printTheGame(fields);

        while (!isFinish) {


            if (!player2IsActive) {
                selectAColumn(fields, charPlayer1);
                player2IsActive = !player2IsActive;

                printTheGame(fields);

                isFinish = isGameFinish(fields, charPlayer1);

            } else {
                if (!isPlayer2Computer) {
                    selectAColumn(fields, charPlayer2);
                } else {
                    computerMakeChoice(fields, charPlayer2);
                }

                player2IsActive = !player2IsActive;

                printTheGame(fields);

                isFinish = isGameFinish(fields, charPlayer2);
            }


        }

    }

    private static boolean isPlayer2Computer() {
        boolean isPlayer2Computer = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play against the computer? type 'yes', else 'no': ");
        String inputString ="";

        try {
            inputString = scanner.nextLine() ;
        } catch (Exception e) {
        }

        if (inputString.equalsIgnoreCase("yes")) {
            System.out.println("You play against the computer");
            isPlayer2Computer = true;
        }

        return isPlayer2Computer;
    }

    private static void computerMakeChoice(char[][] fields, char charComputer) {
        // is not finisch
        int numberOfLines = fields.length;
        int numberOfColumns = fields[0].length;
        int actualColumn = numberOfColumns / 2;
        boolean computerMadeChoice = false;

        boolean isSelectinOk = false;
        int selectedColumnComputer = -1;

        while (!isSelectinOk) {

            for (int searchNumberOfCharsInLine = 3; searchNumberOfCharsInLine > 0; searchNumberOfCharsInLine--) {
                System.out.println("wir suchen " + searchNumberOfCharsInLine + " Steine nebeneinander");
                int counter = 0;
                if (!computerMadeChoice) {
                    for (int line = fields.length - 1; line >= 0; line--) { // Steine suchen die nebeneinander liegen
                        counter = 0;
                        for (int column = 0; column < fields[0].length; column++) {

                            System.out.println("Aktuelle Zeile: " + line + "Aktuelle Spalte " + column);

                            if (fields[line][column] == charComputer) {
                                // Zeichen zählen die in einer Zeile nebeneinander sind
                                if (counter == 0) {
                                    counter++;
                                } else if ((fields[line][column - 1] == charComputer)) {
                                    counter++;
                                } else {
                                    counter = 0;
                                }

                                System.out.println("Gezählte Steine nebeneinander: " + counter);

                                if (counter >= searchNumberOfCharsInLine) {

                                /*
                                Wenn möglich zusätzlichen Stein setzen
                                Wenn die Anzahl der Zeichen erreicht wird (zuerst 3, dann 2 und am Schluss 1)
                                dann im Feld rechts daneben ein Zeichen setzen.
                                Der Stein muss aber auch in die gleiche Zeile
                                 */

                                    int emptyFieldsOnLeftSideOrComputerChar = 0;
                                    int emptyFieldsOnRightSideOrComputerCahr = 0;
                                    for (int i = column + 1; i < fields[0].length; i++) {
                                        if ((fields[line][i] == 0) || (fields[line][i] == charComputer)) {
                                            emptyFieldsOnRightSideOrComputerCahr++;
                                        } else {
                                            break;
                                        }

                                    }
                                    for (int i = (column - counter - 1); i >= 0; i--) {
                                        if ((fields[line][i] == 0) || (fields[line][i] == charComputer)) {
                                            emptyFieldsOnLeftSideOrComputerChar++;
                                        } else {
                                            break;
                                        }
                                    }

                                    // Überprüfen ob 4 Steine nebeneinander  Platz haben
                                    if ((emptyFieldsOnLeftSideOrComputerChar + counter + emptyFieldsOnRightSideOrComputerCahr) >= 4) {

                                        // Stein auf der rechten Seite ergänzen
                                        if ((column + 1) < fields[0].length) {

                                            if (fields[line][column + 1] == 0) {

                                            /*
                                            Wenn nach den Zeichen (rechts) eine leeres Feld ist wird überprüft, ob der Stein
                                            in diese Spalte in die gleiche Zeile geworfen werden kann:
                                            */

                                                if ((line == (fields.length - 1))) {  // es ist die unterste Zeile oder
                                                    selectedColumnComputer = column + 1;
                                                    computerMadeChoice = true;
                                                } else if ((fields[line + 1][column + 1]) != 0) { // Feld darunter voll ist
                                                    selectedColumnComputer = column + 1;
                                                    computerMadeChoice = true;
                                                }

                                            }
                                        }

                                        if (!computerMadeChoice) {

                                             /*
                                            Wenn der Stein rechts nicht rein geworfen werden kann, dann wird versucht,
                                            ob der Stein auf der linken Seite rein geworfen werden kann.
                                            */

                                            if ((column - searchNumberOfCharsInLine) > 0) {// Der erste Stein daf nicht ganz links sein
                                                if (fields[line][(column - searchNumberOfCharsInLine)] == 0) {// das Feld links davon ist leer
                                                    if (line == (fields.length - 1)) {
                                                        // es ist die unterste Zeile --> Stein kann rein geworfen werden
                                                        selectedColumnComputer = column - searchNumberOfCharsInLine;
                                                        computerMadeChoice = true;

                                                    } else if ((fields[line + 1][(column - searchNumberOfCharsInLine)]) != 0) {
                                                        // Feld darunter voll ist --> Stein kann rein geworfen werden
                                                        selectedColumnComputer = column - searchNumberOfCharsInLine;
                                                        computerMadeChoice = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (computerMadeChoice) {
                                break;
                            }
                        }
                        if (computerMadeChoice) {
                            break;
                        }
                    }
                }

                if (!computerMadeChoice) {
                    /*
                    Überprüfung wie viele die Steine übereinander rein geworfen wurden
                     */
                    for (int column = 0; column < fields.length; column++) { // Steine suchen die übereinander stehen
                        counter = 0;
                        for (int line = fields.length - 1; line >= 0; line--) {
                            System.out.println("wir suchen " + searchNumberOfCharsInLine +
                                    " Steine in einer Zeile - aktuell wird die Spalte " + column +
                                    " und Zeile " + line + " überprüft");

                            if ((fields[line][column]) == charComputer) {
                                counter++; // Steine Zählen, die übereinander sind
                            } else if ((fields[line][column]) == 0) {
                                break; // Feld ist leer --> Schleife abbrechen
                            } else {
                                counter = 0; // wenn es ein anderes Zeichen ist, dann den Counter rücksetzen
                            }

                        }
                        if (counter >= searchNumberOfCharsInLine) {
                                /*
                                Stein in die Spalte werfen wenn die Sollanzahl der Steine erreicht wird
                                und die Spalte nicht voll ist.
                                 */
                            if (fields[column][0] == 0) {
                                selectedColumnComputer = column;
                                computerMadeChoice = true;
                                break;
                            }

                        }
                        if (computerMadeChoice) {
                            break;
                        }
                    }
                }

                if (!computerMadeChoice) {
                    // Diagonale überprüfen --> noch nicht fertig
                    System.out.println("Diagonale prüfen");


                    for (int line = (4 - searchNumberOfCharsInLine); line <= (fields.length - searchNumberOfCharsInLine); line++) {
                        //for (int line = 0; line <= (fields.length - searchNumberOfCharsInLine); line++) {
                        // Diagonale links oben nach rechts unten prüfen
                        for (int column = (4 - searchNumberOfCharsInLine); column <= (fields[0].length - searchNumberOfCharsInLine); column++) {
                            //for (int column = 0; column <= (fields[0].length - searchNumberOfCharsInLine); column++) {

                            int counterDiagonal = 0;

                            for (int i = 0; i < searchNumberOfCharsInLine; i++) {
                                // Zähler links oben nach rechts unten
                                if (fields[line + i][column + i] == charComputer) {
                                    counterDiagonal++;
                                }
                            }
                            System.out.println("Conter Diagonale: " + counterDiagonal);

                            if (counterDiagonal >= searchNumberOfCharsInLine) {
                                // Sollanzahl der Steine erreicht
                                if (fields[line - counterDiagonal - 1][column - counterDiagonal - 1] == 0) {
                                    // Überprüfen ob links darüber ein Stein gesetzt werden kann
                                    if (fields[line - counterDiagonal][column - counterDiagonal - 1] != 0) {
                                        //Stein fällt auf die richtige Höhe
                                        selectedColumnComputer = column - counterDiagonal - 1;
                                        computerMadeChoice = true;
                                        break;
                                    }
                                } else if (fields[line + 1][column + 1] == 0) {
                                    //Überprüfen ob rechts darunter ein Stein gesetzt werden kann.
                                }
                            }

                        }

                    }
                }


            }


            if (!computerMadeChoice) {


                Random random = new Random();
                selectedColumnComputer = random.nextInt(7);
                System.out.println("the computer selected random number: " + selectedColumnComputer);

            }


            System.out.println("the computer selected column: " + selectedColumnComputer);

            isSelectinOk = isSelectionOk(fields, charComputer, selectedColumnComputer);

        }


    }

    private static boolean isGameFinish(char[][] fields, char charPlayer) {
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
                if (counter >= 4) {
                    gameIsFinish = true;
                    break;
                }
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
