package cc.jku.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ExceptionMain {
    public static void main(String[] args) {   /// es kann hier auch: throws CalculatorException {   // ergänzt werden
        System.out.println("Exception");

        List<String> strings = new ArrayList<>();

        try {
            System.out.println(strings.get(0));  // im Element 0 steht noch nichts!!!
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ehler: " + e.getMessage());
        }

        Calculator calculator = new Calculator();

        try {
            System.out.println(calculator.addition(2, 6));
        } catch (CalculatorException e) {
            e.printStackTrace();
            System.out.println("Fehler bei der Berechnung: " + e.getMessage());
        }
        try {
            System.out.println(calculator.addition(0, 6));
        } catch (CalculatorException e) {
            System.out.println("Fehler bei der Berechnung: " + e.getMessage());
        }
        try {
            System.out.println(calculator.addition(0, 0));
        } catch (CalculatorException e) {
            System.out.println("Fehler bei der Berechnung: " + e.getMessage());
        }

        try {
            System.out.println(calculator.addition(1, 0));
        } catch (CalculatorException e) {
            System.out.println("Fehler bei der Berechnung: " + e.getMessage());
        }

        try {
            System.out.println(calculator.division(4, 2));
        } catch (CalculatorException e) {
            System.out.println("Fehler bei der Berechnung: " + e.getMessage());
        }

        try {
            System.out.println(calculator.division(2, 0));
        } catch (CalculatorException e) {
            System.out.println("Fehler bei der Berechnung: " + e.getMessage());
        }


    }
}
