package cc.jku.loops;

import java.util.Scanner;

public class Calander {

    /*
    Erstelle ein Programm welches einen Kalender korrekt darstellt, zu Beginn werden zwei
    Variablen definiert (Monat und Starttag) welche wir zur Darstellung der Monatstage (30/31
    Tage) und zum bestimmen des Tages an dem der Monat beginnt (Starttage … 0 - Montag, 1
    - Dienstag usw.).
    Die Ausgabe sollte wie folgt sein:
    Verwendet werden hierfür Schleifen,
    innerhalb dieser können bereits gelernte
    Themen wie if oder auch switch Anwendung
    finden.
    */
    public static void main(String[] args) {

        System.out.println("Bitte geben Sie den Monat ein: ");
        int month = intScannerBoundMinMax(1, 12);

        System.out.println("Sie haben den Monat " + month + " ausgewählt.");

        System.out.println("An welchem Tag startet die Woche? 0 - Montag, 1 - Dienstag, usw. ");
        int startDayOfMonthInCalender = intScannerBoundMinMax(0, 6); // 0 - Montag, 1 - Dienstag usw.

        int daysInMonth = daysInMonth(month);

        printCalender(daysInMonth, startDayOfMonthInCalender);

        System.out.println("Möchten sie alle möglichen Kalender drucken? Dann 'ja' eingeben");
        Scanner scannerString = new Scanner(System.in);
        String string = scannerString.next();

        if (string.equals("ja")) {
            printAllPossibleCalenders();
        }

    }

    private static void printAllPossibleCalenders() {
        for (int i = 28; i < 32; i++) {

            for (int j = 0; j < 7; j++) {
                //System.out.println();
                System.out.println("days in month: " + i + " - start day of the week: " + j);
                printCalender(i, j); //i = days in month, j = startday of the week
            }
        }
    }

    private static void printCalender(int daysInMonth, int startDayOfMonthInCalender) {

        int actualNumberOfDayToPrint = -startDayOfMonthInCalender + 1;//1 ;
        int numberOfLinesForCalender;

        if ((daysInMonth + startDayOfMonthInCalender) % 7 == 0) {
            numberOfLinesForCalender = (daysInMonth + startDayOfMonthInCalender) / 7;
        } else {
            numberOfLinesForCalender = (daysInMonth + startDayOfMonthInCalender) / 7 + 1;
        }

        for (int i = 0; i <= numberOfLinesForCalender; i++) {
            // Zeilen
            if (i == 0) {
                System.out.println("| Mo | Di | Mi | Do | Fr | Sa | So |");
                continue;
            }

            for (int j = 0; j < 8; j++) {
                // Spalte
                if (j == 0) {
                    System.out.print("|");
                    continue;
                }
                if ((actualNumberOfDayToPrint > 0) && (actualNumberOfDayToPrint < 10)) {
                    System.out.print("  " + actualNumberOfDayToPrint + " |");
                } else if ((actualNumberOfDayToPrint >= 10) && (actualNumberOfDayToPrint <= daysInMonth)) {
                    System.out.print(" " + actualNumberOfDayToPrint + " |");
                } else {
                    System.out.print("    |");
                }

                actualNumberOfDayToPrint++;
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int daysInMonth(int month) {
        int daysInMonth = 0;
        if (month == 2) {
            daysInMonth = 29;
        } else if (((month % 2 == 0) && (month < 7)) || (!(month % 2 == 0) && (month > 8))) {
            daysInMonth = 30;
        } else {
            daysInMonth = 31;
        }

        return daysInMonth;

    }

    private static int intScannerBoundMinMax(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int scannedInt = 0;

        try {
            scannedInt = scan.nextInt();
        } catch (Exception e) {
            return 0;
        }

        if (scannedInt < min) {
            System.out.println("Ihre Eingabe ist keiner der Minimalwert. Es wird auf " + min + " aufgerundet." );
            scannedInt = min;
        } else if (scannedInt > max) {
            System.out.println("Ihre Eingabe ist größer als der Maximalwert. Es wird auf " + max + " abgerundet.");
            scannedInt = max;
        }

        return scannedInt;
    }
}