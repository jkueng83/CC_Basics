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

        makeDefaultSettingsForFields(gameFieldsPlayer1);
        makeDefaultSettingsForFields(gameFieldsPlayer2);

        /*
        shipPositionsPlayer1[5][5] = 'Z';
        shipPositionsPlayer1[5][6] = 'Z';
        shipPositionsPlayer1[5][7] = 'Z';
        */

        String player1Name = "Johannes";
        String player2Name = "Hans";

        if (true) {
            // Schiffe über Konsole eingeben
            shipPositionsPlayer1 = setShipPositions(shipPositionsPlayer1, player1Name);
            shipPositionsPlayer2 = setShipPositions(shipPositionsPlayer2, player2Name);
        } else {
            // zum Testen damit die Schiffe nicht eigegeben werden müssen
            for (int i = 0; i < 5; i++) {
                shipPositionsPlayer1[0][i] = 'S';
                shipPositionsPlayer2[i][0] = 'S';
            }

        }

        boolean gameIsFinish = false;
        boolean player1IsActive = true;
        while (!gameIsFinish) {
            boolean isShootOk = false;

            if (player1IsActive) {
                System.out.println("Spielfeld von " + player1Name);
                printBattleship(gameFieldsPlayer1);

                String playersChoice = playersChoice(player1Name);

                isShootOk = isShootOk(shipPositionsPlayer2, gameFieldsPlayer1, playersChoice);

                printBattleship(gameFieldsPlayer1);

                gameIsFinish = isGameFinish(shipPositionsPlayer2, gameFieldsPlayer1, player1Name);

                if (isShootOk) {
                    player1IsActive = false;
                }

            } else {
                System.out.println("Spielfeld von " + player2Name);
                printBattleship(gameFieldsPlayer2);

                String playersChoice = playersChoice(player2Name);

                isShootOk = isShootOk(shipPositionsPlayer1, gameFieldsPlayer2, playersChoice);
                printBattleship(gameFieldsPlayer2);

                gameIsFinish = isGameFinish(shipPositionsPlayer1, gameFieldsPlayer2, player2Name);

                if (isShootOk) {
                    player1IsActive = true;
                }

            }


        }


    }

    private static char[][] setShipPositions(char[][] shipPositionsPlayer, String playersName) {

            /*
            1 Schlachtschiff (5 Kästchen)
            2 Kreuzer (je 4 Kästchen)
            3 Zerstörer (je 3 Kästchen)
            4 U Boote (je 2 Kästchen)
            */

        // Überschrift Drucken
        int lengthText = playersName.length() + 47;
        for (int i = 0; i < lengthText; i++) {
            System.out.print("#");
        }
        System.out.println();

        System.out.println("#####  '" + playersName + "' bitte platziere deine Schiffe.  #####");

        for (int i = 0; i < lengthText; i++) {
            System.out.print("#");
        }
        System.out.println();

        char[][] shipPositon = new char[shipPositionsPlayer.length][shipPositionsPlayer[0].length];
        shipPositon = shipPositionsPlayer;

        // 1 Schlachtschiff (5 Kästchen)
        setShipOnPosition(shipPositon, 5, "Schlachtschiff", 'S', 1, playersName);

        // 2 Kreuzer (je 4 Kästchen)
        setShipOnPosition(shipPositon, 4, "Kreuzer", 'K', 1, playersName);

        // 3 Zerstörer (je 3 Kästchen)
        setShipOnPosition(shipPositon, 3, "Zerstörer", 'Z', 1, playersName);

        // 4 U Boote (je 2 Kästchen)
        setShipOnPosition(shipPositon, 2, "U-Boot", 'U', 1, playersName);

        return shipPositon;
    }

    private static void setShipOnPosition(char[][] shipPositon, int shipLength, String shipName, char shipChar,
                                          int numberOfShips, String playersName) {

        int setNumberOfShips = 0;

        while (setNumberOfShips < numberOfShips) {
            boolean newShipIsSetOnPosition = false;
            newShipIsSetOnPosition = shipIsSetOnPosition(shipPositon, shipLength, shipName, shipChar, playersName);

            if (newShipIsSetOnPosition) {
                setNumberOfShips++;
            }
        }
    }

    private static boolean shipIsSetOnPosition(char[][] shipPosition, int shipLength, String shipName, char shipChar,
                                               String playersName) {
        boolean isShipPositionOk = false;

        while (!isShipPositionOk) {

            printBattleship(shipPosition);
            System.out.println("Positionieren Sie ein '" + shipName + "' mit der Länge von " + shipLength + " Kästchen.");
            boolean isHorizontal = isHorizontal();
            System.out.println("Geben sie die Start Koordinate vom " + shipName + " an:");
            String shipStartPosition = playersChoice(playersName);
            int xPositionStart = getXPosition(shipStartPosition);
            int yPositionStart = getYPosition(shipStartPosition);
            int xPositionEnd = xPositionStart;
            int yPositionEnd = yPositionStart;

            if (isHorizontal) {
                xPositionEnd = xPositionStart + shipLength - 1;
            } else {
                yPositionEnd = yPositionStart + shipLength - 1;
            }

            if ((yPositionStart < 0) || (yPositionEnd >= shipPosition.length)) {
                System.out.println("Y Koordinaten ungültig");
                continue;
            }

            if ((xPositionStart < 0) || (xPositionEnd >= shipPosition[0].length)) {
                System.out.println("X Koordinaten ungültig");
                continue;
            }

            boolean fieldsEmpty = true;

            for (int y = yPositionStart; y <= yPositionEnd; y++) {
                for (int x = xPositionStart; x <= xPositionEnd; x++) {
                    if (shipPosition[y][x] != 0) {
                        fieldsEmpty = false;
                    }
                }
            }

            if (!fieldsEmpty) {
                System.out.println("Die Felder sind schon belegt.");
                continue;
            } else {
                for (int y = yPositionStart; y <= yPositionEnd; y++) {
                    for (int x = xPositionStart; x <= xPositionEnd; x++) {
                        shipPosition[y][x] = shipChar;
                        isShipPositionOk = true;
                    }
                }

                printBattleship(shipPosition);
            }


        }
        return isShipPositionOk;
    }

    private static boolean isHorizontal() {
        boolean isHorizontal = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Soll das Schiff horizontal oder vertikal ausgereichtet wereden? h/v");
        String scannerInput = scanner.next();
        isHorizontal = scannerInput.equalsIgnoreCase("h");
        return isHorizontal;
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


    private static char[][] makeStootOnGameFields(char[][] shipPositions, char[][] gameFields, String shootPosition) {
        boolean isShootOk = true;
        char[][] tempGameFields = gameFields;

        int xPosition = getXPosition(shootPosition);
        int yPosition = getYPosition(shootPosition);
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

    private static boolean isShootOk(char[][] shipPositions, char[][] gameFields, String shootPosition) {
        boolean isShootOk = true;
        //char[][] tempGameFields = gameFields;

        int xPosition = getXPosition(shootPosition);
        int yPosition = getYPosition(shootPosition);
        if ((xPosition < 0) || (xPosition > shipPositions[0].length)) {
            isShootOk = false;
        } else if ((yPosition < 0) || (yPosition > shipPositions.length)) {
            isShootOk = false;
        }

        if (!isShootOk) {
            isShootOk = false;
        } else if ((gameFields[yPosition][xPosition]) == '-') {
            if ((shipPositions[yPosition][xPosition]) == ' ') { // kein Schiff
                gameFields[yPosition][xPosition] = ' ';
                System.out.println("Kein treffer!");
            } else { // Schiff getroffen
                gameFields[yPosition][xPosition] = shipPositions[yPosition][xPosition];
                System.out.println("Schiff getroffen!");
            }
        } else {
            isShootOk = false;
        }

        return isShootOk;
    }

    private static int getYPosition(String shootPosition) {
        int yPosition = -1;

        try {
            String yPositionString = shootPosition.substring(shootPosition.indexOf('/') + 1, shootPosition.length());
            yPosition = Integer.parseInt(yPositionString) - 1;
        } catch (Exception e) {
            System.out.println("Falsche Eingabe der Y Koordinate");
        }

        return yPosition;
    }

    private static int getXPosition(String shootPosition) {
        int xPosition = -1;

        try {
            xPosition = shootPosition.charAt(0) - 65; //65 ist 'A'
        } catch (Exception e) {
            System.out.println("Falsche Eingabe der X Koordinate");
        }

        return xPosition;
    }

    private static String playersChoice(String plyersName) {
        System.out.println(plyersName + " bitte eine Koordinate eingeben (x/y) ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        inputString = inputString.toUpperCase();
        inputString = inputString.replace(" ", ""); //Leerzeichen entfernen
        return inputString;
    }

    private static void makeDefaultSettingsForFields(char[][] gameFieldsPlayer) {
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
