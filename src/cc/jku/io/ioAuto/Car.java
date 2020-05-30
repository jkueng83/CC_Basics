package cc.jku.io.ioAuto;

public class Car {
    private String name;
    private Engine engine;

    private int carPriceTotal;
    private String priceString;


    public Car(String name) {

        this.name = name;
        System.out.println("add default engine - 75 PS, Benzin");
        this.engine = new Engine(75, ENGINETYPE.BENZIN); // default Engine
        calculateCarPrice();

    }

    public void addEngine(Engine engine) {
        this.engine = engine;
        calculateCarPrice();
    }

    private void calculateCarPrice() {

        double carPrice = this.engine.getEnginePricePrice() * 1.1;
        double enginePrice = this.engine.getEnginePricePrice();

        this.carPriceTotal = (int) (carPrice + enginePrice);
    }

    private void generatePriceString() {

        String string = Integer.toString(this.carPriceTotal);

        if (string.length() > 6) {
            // Punkt für eine Million einfügen (1.000000)

            String s1 = string.substring(string.length() - 6, string.length());
            //System.out.println(s1); // zum Testen
            String s2 = string.substring(0, string.length() - 6);
            //System.out.println(s2); // zum Testen
            string = s2 + "." + s1;
        }

        if (string.length() > 3) {
            // Punkt für Tausend einfügen (1.000)

            String s1 = string.substring(string.length() - 3, string.length());
            // System.out.println(s1); zum Testen
            String s2 = string.substring(0, string.length() - 3);
            // System.out.println(s2); // zum Testen
            string = s2 + "." + s1;

        }

        this.priceString = string;

        // System.out.println("output: " + string); // zum Testen

    }

    public String getCarDataString() {
        /*
        hier soll ein String in diesem Format erzeut weden
            Auto;Treibstoff;PS;Preis
            BMX X3;DIESEL;200;60.000
            BMW X3;BENZIN;150;50.000
         */

        generatePriceString();

        String carDataString = (this.name + ";" + this.engine.getEngineType() + ";" + this.engine.getHp() + ";" +
                this.priceString);
        return carDataString;
    }
}
