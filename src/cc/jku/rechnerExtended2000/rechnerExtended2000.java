package cc.jku.rechnerExtended2000;

import java.util.ArrayList;
import java.util.Arrays;

public class rechnerExtended2000 {
    public static void main(String[] args) {

        String inputCalculation = "((9,5/4) *8) + (16/7) - 4";

         inputCalculation = "12,3512- 1-17,2635";
        System.out.println(inputCalculation);

        String inputCalculationWithoutSpace = inputCalculation.replace(" ", "");
        inputCalculationWithoutSpace = inputCalculationWithoutSpace.replace(",", ".");
        System.out.println(inputCalculationWithoutSpace);


        String calculationStringArray[] = new String[inputCalculationWithoutSpace.length()];

        int counter = 0;


        for (int i = 0; i < inputCalculationWithoutSpace.length(); i++) {
            String string = inputCalculationWithoutSpace.substring(i, (i + 1));

            switch (string) {
                case "(":
                case ")":
                case "+":
                case "-":
                case "*":
                case "/":
                    calculationStringArray[counter] = string;
                    //counter++;
                    break;
                default:
                    calculationStringArray[counter] = "";
                    for (int j = i; j < inputCalculationWithoutSpace.length(); j++) {

                        string = inputCalculationWithoutSpace.substring(j, (j + 1));
                        string = inputCalculationWithoutSpace.substring(j, (j + 1));
                        String[] arr = {"(", ")", "+", "-", "*", "/"};
                        //Arrays.sort(arr);
                        Arrays.sort(arr);
                        int indexOf = Arrays.binarySearch(arr, string); // Das Array muss richtig sortiert sein, damit der Vergleich funktioniert.
                        if (indexOf >= 0) {
                            //counter++;
                            i = j - 1;
                            break;
                        } else {
                            calculationStringArray[counter] += string;

                        }
                    }

                    break;
            }
            counter++;
        }

        boolean calculationIsFinished = false;

        int calculationCounter = 0;

        while (!calculationIsFinished) {

            calculationCounter++;
            if (calculationCounter > 100) {
                calculationIsFinished = true;
            }

            //Update calculation
            calculationStringArray = updateCalculation(calculationStringArray);

            printCalculation(calculationStringArray);

            int numberOfBracketsInCalkulation = getNumberOfBracketInStringArray(calculationStringArray);

            int posStartCalculation = 1;
            int posEndCalculation = getLengthOfCalculation(calculationStringArray);

            if (posEndCalculation <= 1) {
                calculationIsFinished = true;
                System.out.println();
                System.out.println("the calculation is finish. the result is: " + calculationStringArray[0]);
            }

            if (numberOfBracketsInCalkulation > 0) {


                int positionBracketClose = getFirstPositionBracketClose(calculationStringArray);

                int positionBracketOpen = getPositionBracketOpenBeforePosition(calculationStringArray, positionBracketClose);

                if ((positionBracketClose - positionBracketOpen == 2)) {
                    // Delete Brackets
                    calculationStringArray[positionBracketOpen] = "X";
                    calculationStringArray[positionBracketClose] = "X";
                    continue;
                } else {
                    posStartCalculation = positionBracketOpen;
                    posEndCalculation = positionBracketClose;
                }

            }

            int numberOfDotCalculations = getNumberOfDotCalculations(calculationStringArray, posStartCalculation, posEndCalculation);
            if (numberOfDotCalculations > 0) {

                makeDotCalculation(calculationStringArray, posStartCalculation, posEndCalculation);
                continue;
            }

            int numberOfLineCalculations = getNumberOfLineCalculations(calculationStringArray, posStartCalculation, posEndCalculation);

            if (numberOfLineCalculations > 0) {
                makeLineCalculation(calculationStringArray, posStartCalculation, posEndCalculation);
                continue;
            }

        }

    }

    private static int getLengthOfCalculation(String[] stringArray) {
        int lengthOfArray = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null) {
                lengthOfArray++;
            }
        }
        return lengthOfArray;
    }

    private static String[] updateCalculation(String[] inputCalculationStringArray) {
        String[] tempStringArray = new String[inputCalculationStringArray.length];
        int counterModifyArray = 0;

        for (int i = 0; i < inputCalculationStringArray.length; i++) {
            String tempString = inputCalculationStringArray[i];
            boolean isEqual = tempString == "X";
            if (!isEqual) {
                tempStringArray[counterModifyArray] = tempString;
                counterModifyArray++;
            }
            if (tempString == null) {
                break;
            }
        }
        return tempStringArray;
    }


    private static String[] makeDotCalculation(String[] inputCalculationStringArray, int startPositoin, int endPosition) {
        String[] calculationArray = new String[inputCalculationStringArray.length];
        calculationArray = inputCalculationStringArray;

        for (int i = startPositoin; i < endPosition; i++) {
            String stringTemp = calculationArray[i];

            if (stringTemp.equals("*")) {
                calculationArray[i] = calculation((calculationArray[i - 1]), (calculationArray[i]), (calculationArray[i + 1]));
                calculationArray[i - 1] = "X";
                calculationArray[i + 1] = "X";
                break;
            }

            if (stringTemp.equals("/")) {

                calculationArray[i] = calculation((calculationArray[i - 1]), (calculationArray[i]), (calculationArray[i + 1]));
                calculationArray[i - 1] = "X";
                calculationArray[i + 1] = "X";
                break;
            }
        }

        return calculationArray;
    }

    private static String[] makeLineCalculation(String[] inputCalculationStringArray, int startPositoin, int endPosition) {
        String[] calculationArray = new String[inputCalculationStringArray.length];
        calculationArray = inputCalculationStringArray;

        for (int i = startPositoin; i < endPosition; i++) {
            String stringTemp = calculationArray[i];

            if (stringTemp.equals("+")) {
                calculationArray[i] = calculation((calculationArray[i - 1]), (calculationArray[i]), (calculationArray[i + 1]));
                calculationArray[i - 1] = "X";
                calculationArray[i + 1] = "X";
                break;
            }

            if (stringTemp.equals("-")) {
                calculationArray[i] = calculation((calculationArray[i - 1]), (calculationArray[i]), (calculationArray[i + 1]));
                calculationArray[i - 1] = "X";
                calculationArray[i + 1] = "X";
                break;
            }
        }

        return calculationArray;
    }


    private static int getNumberOfBracketInStringArray(String[] stringArray) {
        int numberOfBrackets = 0;
        for (int i = 0; i < stringArray.length; i++) {
            String tempString = stringArray[i];
            if (tempString == null) {
                break;
            }
            if ((tempString.equals("(")) || (tempString.equals(")"))) {
                numberOfBrackets++;
            }
        }
        return numberOfBrackets;
    }

    private static int getNumberOfDotCalculations(String[] stringArray, int startPosition, int endPosition) {
        int numberOfDotCalculations = 0;
        for (int i = startPosition; i < endPosition; i++) {
            String tempString = stringArray[i];
            if (tempString == null) {
                break;
            }
            if ((tempString.equals("*")) || (tempString.equals("/"))) {
                numberOfDotCalculations++;
            }
        }
        return numberOfDotCalculations;
    }

    private static int getNumberOfLineCalculations(String[] stringArray, int startPosition, int endPosition) {
        int numberOfLineCalculations = 0;
        for (int i = startPosition; i < endPosition; i++) {
            String tempString = stringArray[i];
            if (tempString == null) {
                break;
            }
            if ((tempString.equals("+")) || (tempString.equals("-"))) {
                numberOfLineCalculations++;
            }
        }
        return numberOfLineCalculations;
    }


    private static int getPositionBracketOpenBeforePosition(String[] inputCalculationStringArray, int startPosition) {
        int positionBracketOpen = -1;

        for (int i = startPosition; i >= 0; i--) {
            String stringTemp = inputCalculationStringArray[i];

            if (stringTemp.equals("(")) {
                positionBracketOpen = i;
                break;
            }
        }
        return positionBracketOpen;
    }

    private static int getFirstPositionBracketClose(String[] inputCalculationStringArray) {
        int positionBracketClose = -1;
        for (int i = 0; i < inputCalculationStringArray.length; i++) {
            String stringTemp = inputCalculationStringArray[i];

            if (stringTemp.equals(")")) {
                positionBracketClose = i;
                break;
            }
        }
        return positionBracketClose;
    }

    private static void printCalculation(String[] inputCalculationStringArray) {
        System.out.print("the calculation is: ");

        for (int i = 0; i < inputCalculationStringArray.length; i++) {
            String tempSring = inputCalculationStringArray[i];
            //int stringLenth = tempSring.length();

            if (!(tempSring == null)) {
                // if (!(tempSring.isBlank())) {// Abfrage not Null
                System.out.print(inputCalculationStringArray[i]);
            }
        }
        System.out.println();
    }

    private static String calculation(String number1, String operand, String number2) {

        char operandChar = operand.charAt(0);

        //System.out.println("the calculation is " + number1 +" " + operand + " " + number2);

        double number1Double = Double.parseDouble(number1);
        double number2Double = Double.parseDouble(number2);
        double result = 0.0;

        switch (operandChar) {
            case '*':
                result = number1Double * number2Double;
                break;
            case '/':
                result = number1Double / number2Double;
                break;
            case '+':
                result = number1Double + number2Double;
                break;
            case '-':
                result = number1Double - number2Double;
                break;
        }

        System.out.println("the actual calculation is: " + number1 + " " + operand + " " + number2 + " = " + result);

        return "" + result;
    }


    public static ArrayList GetMyValues() { // von Marc - Vergessen, da ich es noch nicht  kenne!!
        ArrayList arrList = new ArrayList();
        double[] calclationArray = {1.2, 2.9};
        String[] stringArray = {"test", "test1"};
        arrList.add(calclationArray);
        arrList.add(stringArray);
        return arrList;
    }

}
