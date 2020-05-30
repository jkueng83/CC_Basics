package cc.jku.io.ioAuto;

public class Engine {

    private int hp;
    private ENGINETYPE engineType;
    private int enginePrice;

    public Engine(int hp, ENGINETYPE engineType) {

        this.hp = hp;
        this.engineType = engineType;
        calculateEnginePrice();

    }

    public double getEnginePricePrice() {

        calculateEnginePrice();

        return this.enginePrice;
    }

    public ENGINETYPE getEngineType() {
        return engineType;
    }

    public int getHp() {
        return hp;
    }

    private void calculateEnginePrice() {

        double enginePrice = 0;
        if (hp > 500)
            enginePrice = hp * 350;
        else if (hp > 200)
            enginePrice = hp * 300;
        else if (hp > 150)
            enginePrice = 40000;
        else if (hp > 100)
            enginePrice = 15000;
        else
            enginePrice = 10000;

        switch (this.engineType) {
            case BENZIN:
                enginePrice = enginePrice;
                break;
            case DIESEL:
                enginePrice = enginePrice * 1.2f;
                break;
            case ELEKTROANTRIEB:
                enginePrice = enginePrice * 1.8;
                break;
        }

        this.enginePrice = (int) enginePrice;
    }
}

