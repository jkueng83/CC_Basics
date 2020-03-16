package cc.jku.OOCar;

public class Engine {
    public enum TYPE {DIESEL, PETROL}

    private int horsePower;
    private TYPE type; // Diesel oder Benzin

    public Engine(int horsePower, TYPE type) {
        this.horsePower = horsePower;
        this.type = type;
    }

    /*
        the amount should be between 0 and 100 %
    */
    public void drive(int amount) {
        System.out.println("The engine is running with " + amount + "%");
    }

    public int getHorsePower() {
        return horsePower;
    }

    public TYPE getType() {
        return type;
    }
}
