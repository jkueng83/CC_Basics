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
    private String color = "";
    private double fuelConsumption = 5.0; // l per 100 km
    private String serialNumber = "";
    private double fuelAmountCapacity = 60.0;
    private double fuelAmount = fuelAmountCapacity;

    public double getRemainingRange() {
        double remaindingRange = this.fuelAmount / this.fuelConsumption * 100 ;
        System.out.println("the remainding Range is " + remaindingRange + " [km]");
        return remaindingRange;
    }

    public void honk(int amountOfRepetitions) {

        for (int i = 0; i < amountOfRepetitions; i++) {
            System.out.println("Tuuut");
        }

    }

    public void turboBoost() {

        if (this.fuelAmount > (this.fuelAmountCapacity * 0.1)) {
            System.out.println("SuperBoostMode");
        } else {
            System.out.println("Not enough fuel to go to Superboost");
            printFuelAmount();           //System.out.println("" + this.fuelAmount + "[l] fule in the car");
        }

    }

    public Car(String color, double fuelConsumption, String serialNumber, double fuelAmount) {

        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.serialNumber = serialNumber;
        this.fuelAmount = fuelAmount;
    }

    // Methode
    public void drive() {

        this.fuelAmount = this.fuelAmount - this.fuelConsumption;
        System.out.println("i am driving");

    }

    // Methode
    public void printFuelAmount() {

        System.out.println("The fuel amount is: " + this.fuelAmount + " [l]");

    }

    public void breakCar() {

        System.out.println("i am breaking");

    }
}
