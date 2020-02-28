package cc.jku.rechnerExtended2000;

import java.util.Arrays;

public class rechnerExtended2000 {
    public static void main(String[] args) {

        String inputCalculation = "((9,5/4) *8) + (16/7) - 4";
        System.out.println(inputCalculation);

        String inputCalculationWithoutSpace = inputCalculation.replace(" ", "");
        inputCalculationWithoutSpace = inputCalculationWithoutSpace.replace(",", ".");
        System.out.println(inputCalculationWithoutSpace);


        String inputStringArray[] = new String[100];


        Double numbers[] = new Double[100];

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
                    inputStringArray[counter] = string;
                    //counter++;
                    break;
                default:
                    inputStringArray[counter] = "";
                    for (int j = i; j < inputCalculationWithoutSpace.length(); j++) {

                        string = inputCalculationWithoutSpace.substring(j, (j + 1));
                        string = inputCalculationWithoutSpace.substring(j, (j + 1));
                        String[] arr = {"(", ")", "+", "-", "*", "/"};
                        int indexOf = Arrays.binarySearch(arr, string);
                        if (indexOf >= 0) {
                            //counter++;
                            i=j-1;
                            break;
                        } else {
                            inputStringArray[counter] += string;

                        }
                    }

                    break;
            }
            counter++;
        }

     //   for (int i = 0; i < inputStringArray.length ; i++) {

       //     Double number =  Double.parseDouble(inputStringArray[1]);


        //}




        for (int i = 0; i < 20; i++) {
            System.out.print(inputStringArray[i]);

        }
        System.out.println();
        
        int posKlammerAuf = -1 ;
        int posKlemmerZu = -1 ;
        for (int i = 0; i < 1; i++) {
            
        }
        
        
        
        

        double result = ( Double.parseDouble(  inputStringArray[2] ) /  Double.parseDouble(  inputStringArray[4] ) ) ;
        System.out.println("Ergebnis " + result);



    }


}
