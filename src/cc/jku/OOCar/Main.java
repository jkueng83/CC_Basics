package cc.jku.OOCar;

public class Main {
    public static void main(String[] args) {

        Car firstCar = new Car("blue", 6, "M123", 60);
        Car secondCar = new Car("green", 5, "VW213", 50);

        firstCar.turboBoost();
        firstCar.printFuelAmount();
        firstCar.drive();
        firstCar.printFuelAmount();

        for (int i = 0; i < 10; i++) {
            firstCar.honk(i + 1);
            firstCar.drive();
            firstCar.printFuelAmount();
            firstCar.turboBoost();

            if (firstCar.getRemainingRange() <= 0.0) {
                firstCar.breakCar();
                break;

            }

        }

    }
}
