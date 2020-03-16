package cc.jku.OOCar;

/*
Aufgabe - Car Erweitere das Auto
Füge eine Methode break() ein. Die Methode gibt den String "Ich bremse" aus.
Füge eine Methode turboBoost() ein. Diese Methode prüft ob der Benzinstand größer als 10% des Tankvolumens ist.
    Wenn ja gibt die Methode den Text "SuperBoostMode" aus. Ansonsten wird "Not enough fuel to go to Superboost".
Füge eine Methode honk(int amountOfRepetitions) ein.
    Die Methode honk hupt (gibt auf der Konsole den Text "Tuuut" aus.
    Über den Parameter amountOfRepetitions kann gesteuert werden wie oft gehupt wird.
Füge eine Methode getRemainingRange() ein. Diese Methode liefert die Rest-Reichweite des Autos zurück.
    Diese wird berechnet über den Tankstand und den Verbrauch.
 */

public class Car {

    private String brand;
    private String serialNumber = "";
    private Engine engine;
    private FuelTank fuelTank;
    private String color = "";
    private double fuelConsumption = 5.0; // l per 100 km

    public Car(String brand, Engine engine, String color, double fuelConsumption, String serialNumber, FuelTank fuelTank) {

        this.brand = brand;
        this.engine = engine;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.serialNumber = serialNumber;
        this.fuelTank = fuelTank;
    }

    public double getRemainingRange() {
        double remaindingRange = this.getFuelTank().getFuelAmount() / this.fuelConsumption * 100;
        System.out.println("the remainding Range is " + remaindingRange + " [km]");
        return remaindingRange;
    }

    public void honk(int amountOfRepetitions) {

        for (int i = 0; i < amountOfRepetitions; i++) {
            System.out.println("Tuuut");
        }

        System.out.println("i am a " + this.brand + " and my color is " + this.color +
                " and have " + this.getEngine().getHorsePower() + " horse power");

    }

    public void turboBoost() {

        if (this.getFuelTank().getFuelAmount() > (this.getFuelTank().getFuelAmountCapacity() * 0.1)) {
            System.out.println("SuperBoostMode");
        } else {
            System.out.println("Not enough fuel to go to Superboost");
            printFuelAmount();           //System.out.println("" + this.fuelAmount + "[l] fule in the car");
        }

    }

    // Methode
    public void drive(double speed) { // speed in km/h

        double fuelConsumption = 0.0005 * speed * speed - 0.09 * speed + 10;
        System.out.println("the fule consumption ist " + fuelConsumption);

        this.getFuelTank().usedFuel(fuelConsumption);
        System.out.println("i am driving with " + speed + " km/h");

    }

    // Methode
    public void printFuelAmount() {

        System.out.println("The fuel amount is: " + this.getFuelTank().getFuelAmount() + " [l]");

    }

    public void breakCar() {

        System.out.println("i am breaking");

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }
}
