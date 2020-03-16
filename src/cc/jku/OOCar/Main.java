package cc.jku.OOCar;

public class Main {
    public static void main(String[] args) {

        Engine engine1 = new Engine(104, Engine.TYPE.DIESEL);
        Engine engine2 = new Engine(160, Engine.TYPE.PETROL);

        FuelTank fuelTank1 = new FuelTank(57);
        FuelTank fuelTank2 = new FuelTank(58);


        Car firstCar = new Car("Mazda", engine1, "blue", 6, "M123", fuelTank1);
        Car secondCar = new Car("VW", engine2, "green", 5, "VW213", fuelTank2);


        firstCar.getFuelTank().fillUpFuel(50);
        secondCar.getFuelTank().fillUpFuel(77);

        System.out.println("fuel amount first car: " + firstCar.getFuelTank().getFuelAmount());
        System.out.println("fuel amount second car: " + secondCar.getFuelTank().getFuelAmount());

        for (int i = 0; i < 10; i++) {
            firstCar.honk(i + 1);
            firstCar.drive(i*10);
            firstCar.printFuelAmount();
            firstCar.turboBoost();

            if (firstCar.getRemainingRange() <= 0.0) {
                firstCar.breakCar();
                break;

            }

        }

    }
}
