package cc.jku.OOCar;

public class FuelTank {
    private double fuelAmount; // [l]
    private double fuelAmountCapacity;

    public FuelTank(double fuelAmountCapacity) {
        this.fuelAmountCapacity = fuelAmountCapacity;
    }

    public void usedFuel(double amountUse) {

        if (amountUse > 0) {
            this.fuelAmount = this.fuelAmount - amountUse;
        } else {
            this.fuelAmount = this.fuelAmount + amountUse;
        }

        if (this.fuelAmount <= 0 ){
            this.fuelAmount = 0 ;
            System.out.println("fuel is empty!");
        }
    }

    public void fillUpFuel(double amountFillUp) {

        if (amountFillUp>0) {
            this.fuelAmount = this.fuelAmount + amountFillUp;
        }

        if (this.fuelAmount > this.fuelAmountCapacity) {
            this.fuelAmount = this.fuelAmountCapacity;
        }

    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelAmountCapacity() {
        return fuelAmountCapacity;
    }
}
