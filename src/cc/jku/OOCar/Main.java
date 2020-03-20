package cc.jku.OOCar;

import com.sun.jdi.Mirror;

public class Main {
    public static void main(String[] args) {

        Engine engine1 = new Engine(104, Engine.TYPE.DIESEL);
        Engine engine2 = new Engine(160, Engine.TYPE.PETROL);

        FuelTank fuelTank1 = new FuelTank(57);
        FuelTank fuelTank2 = new FuelTank(58);

        RearMirror r1 = new RearMirror(100,0);
        RearMirror r2 = new RearMirror(90, -40);

        Car firstCar = new Car("Mazda", engine1, "blue", 6, "M123", fuelTank1);

        // mirrors
        firstCar.addMirror(r1);
        firstCar.addMirror(r2);
        System.out.println("mirror positoin 0: " + firstCar.getMirrors().get(0).getPosition());
        System.out.println("mirror positoin 1: " + firstCar.getMirrors().get(1).getPosition());

        // tires - unterschiedliche Werte zum testen
        Tire tire1 = new Tire(195,65,"R",15,91,"H");
        Tire tire2 = new Tire(205,50,"R",16,92,"I");
        Tire tire3 = new Tire(215,40,"R",17,93,"J");
        Tire tire4 = new Tire(225,30,"R",18,94,"K");

        firstCar.addTire(tire1);
        firstCar.addTire(tire2);
        firstCar.addTire(tire3);
        firstCar.addTire(tire4);

        for (int i = 0; i <4 ; i++) {
            System.out.println("Tire " + i + " Type: " + firstCar.getTires().get(i).getTireTyp());
        }

        System.out.println("Reifenhöhe auf 20 ändern");
        tire1.setHeight(20);
        tire2.setHeight(20);
        tire3.setHeight(20);
        tire4.setHeight(20);

        for (int i = 0; i <4 ; i++) {
            System.out.println("Tire " + i + " Type: " + firstCar.getTires().get(i).getTireTyp());
        }

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
