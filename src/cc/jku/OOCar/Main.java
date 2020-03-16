package cc.jku.OOCar;

public class Main {
    public static void main(String[] args) {

        Engine engine1 = new Engine(104, Engine.TYPE.DIESEL);
        Engine engine2 = new Engine(160, Engine.TYPE.PETROL);




        Car firstCar = new Car("Mazda",engine1,"blue", 6, "M123", 60);
        Car secondCar = new Car("VW",engine2, "green", 5, "VW213", 50);

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
