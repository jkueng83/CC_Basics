package cc.jku.io.ioAuto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private String name;
    List<Car> cars;
    List<Engine> engines;


    public Customer() {

        this.cars = new ArrayList<>();
        this.engines = new ArrayList<>();
        this.name = inputString("Bitte geben Sie ihren Namen ein:");

    }

    private String inputString(String printCommentForConsole) {
        System.out.println(printCommentForConsole);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void configureCar() {

        boolean isConfiguratinFinish = false;

        while (!isConfiguratinFinish) {

            printConfigurationStrat();
            String configStart = inputString("Bitte machen Sie Ihre Eingabe:");

            if (configStart.equalsIgnoreCase("Ja")) {

                configureACar();

            } else if (configStart.equalsIgnoreCase("Autos")) {

                printConfigurations();

            } else if (configStart.equalsIgnoreCase("Speichern")) {

                saveCarsInTxtFile();

            } else if (configStart.equalsIgnoreCase("Ende")) {

                isConfiguratinFinish = true;
                System.out.println("Der Konfigurator wurde beendet");

            } else {

                System.out.println(this.name + ", Ihre Eingabe ist ungültig!");

            }

        }

    }

    private void saveCarsInTxtFile() {
        /*
        So soll der Inhalt der Datei ausschauen:
        -----------------------------------------
        Auto;Treibstoff;PS;Preis
        BMX X3;DIESEL;200;60.000
        BMW X3;BENZIN;150;50.000
        */

        if (this.cars.size() > 0) {
            String pathname = "./testdata/Cars" + this.name + ".txt";
            File file = new File(pathname);

            try {

                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write("Auto;Treibstoff;PS;Preis\n");

                for (Car car : this.cars) {
                    fileWriter.write(car.getCarDataString() + "\n");
                }
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Ihre Daten wurden gespeichert.");

        } else {

            System.out.println("Datei kann nicht geschrieben werden.");
            System.out.println("Es wurden noch keine Autos konfiguriert.");
            System.out.println("Bitte konfigurieren Sie zuerst ein Auto bevor Sie speichern.");

        }
    }

    private void printConfigurations() {
        System.out.println();

        if (this.cars.size() > 0) {
            System.out.println("Sie haben folgende Autos konfiguriert:");

            for (Car car : this.cars) {
                System.out.println(car.getCarDataString());
            }

        } else {
            System.out.println("Es wurden noch keine Autos konfiguriert.");
        }

    }

    private void printConfigurationStrat() {

        System.out.println("Hallo " + this.name + "!");
        System.out.println("Wenn Sie ein Auto konfigurieren möchen geben Sie \"Ja\" ein.");
        System.out.println("Wenn Sie ihhre konfigorierten Austos ansehen möchten geben Sie \"Autos\" ein.");
        System.out.println("Wenn Sie ihhre konfigorierten Austos speichern möchten geben Sie \"Speichern\" ein.");
        System.out.println("Wenn Sie den Konfigurator beenden möchten geben Sie \"Ende\" ein.");

    }

    private void configureACar() {

        System.out.println("--------------------------------");
        System.out.println("Der Konfigurator wurde gestartet");
        System.out.println();

        String brand = inputString("Bitte geben sie die Automarke ein");
        String carType = inputString("Bitte geben sie eine Autotype ein");

        Car car = new Car(brand + " " + carType);

        int hp = (int) intputInt("Wie viel PS soll ihr Auto habe?");
        ENGINETYPE enginetype = inputEngineType();

        Engine engine = new Engine(hp, enginetype);

        car.addEngine(engine);

        this.cars.add(car);

        System.out.println("Sie haben folgendes Auto konfiguriert:");
        System.out.println(this.cars.get(cars.size() - 1).getCarDataString());

    }

    private int intputInt(String printCommentForConsole) {

        System.out.println(printCommentForConsole);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    private ENGINETYPE inputEngineType() {

        ENGINETYPE engineType = ENGINETYPE.BENZIN;

        boolean isEngineTypeOk = false;

        while (!isEngineTypeOk) {
            System.out.println("Welchen Antriebstyp möchten Sie haben?");
            System.out.println("1 = Benzin");
            System.out.println("2 = Diesel");
            System.out.println("3 = Elektroantrieb");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.next()) {
                case "1":
                    engineType = ENGINETYPE.BENZIN;
                    isEngineTypeOk = true;
                    break;
                case "2":
                    engineType = ENGINETYPE.DIESEL;
                    isEngineTypeOk = true;
                    break;
                case "3":
                    engineType = ENGINETYPE.ELEKTROANTRIEB;
                    isEngineTypeOk = true;
                    break;
                default:
                    System.out.println("Fehler bei der Eingabe.");
                    System.out.println("Bitte neue Eingabe machen");
            }
        }

        return engineType;
    }
}
