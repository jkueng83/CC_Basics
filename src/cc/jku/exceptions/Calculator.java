package cc.jku.exceptions;

public class Calculator {

    public double addition(double a, double b) throws CalculatorException {
        if (a == 0 && b == 0) {
            throw new CalculatorException("a = 0 und b =0! Addition von \"0\" nicht sinnvoll!");
        } else if (a == 0) {
            throw new CalculatorException("a = 0! Addition von \"0\" nicht sinnvoll!");
        } else if (b == 0) {
            throw new CalculatorException("b = 0! Addition von \"0\" nicht sinnvoll!");
        }
        return a + b;
    }


    public double division(double a, double b) throws CalculatorException {
        if (b == 0) {
            throw new CalculatorException("Division durch \"0\" nicht möglich!");
        }
        return a / b;
    }
}
