package cc.jku.basics;

import java.util.Scanner;

public class PrintCharacterArray {
    public static void main(String[] args) {
        System.out.println("Bitte geben Sie einen Buchstabe ein: ");
        Scanner scanner = new Scanner(System.in);
        String inputCharacter = scanner.next();

        boolean  [][] printArray= new boolean[5][5];
        String printingCharacter = inputCharacter;
        String backgroundCharacter = " ";

        definePrintArray(inputCharacter, printArray);

        printCharacter(printArray, printingCharacter, backgroundCharacter);

    }

    private static void definePrintArray(String inputCharacter, boolean[][] printArray) {
        switch (inputCharacter) {
            case "J":
            case "j":
                printArray[0][0]= false; printArray[0][1]= false; printArray[0][2]= false; printArray[0][3]= false; printArray[0][4]= true;
                printArray[1][0]= false; printArray[1][1]= false; printArray[1][2]= false; printArray[1][3]= false; printArray[1][4]= true;
                printArray[2][0]= false; printArray[2][1]= false; printArray[2][2]= false; printArray[2][3]= false; printArray[2][4]= true;
                printArray[3][0]= true; printArray[3][1]= false; printArray[3][2]= false; printArray[3][3]= false; printArray[3][4]= true;
                printArray[4][0]= false; printArray[4][1]= true; printArray[4][2]= true; printArray[4][3]= true; printArray[4][4]= false;
               break;

            case "K":
            case "k":
                printArray[0][0]= true; printArray[0][1]= false; printArray[0][2]= false; printArray[0][3]= true; printArray[0][4]= false;
                printArray[1][0]= true; printArray[1][1]= false; printArray[1][2]= true; printArray[1][3]= false; printArray[1][4]= false;
                printArray[2][0]= true; printArray[2][1]= true; printArray[2][2]= false; printArray[2][3]= false; printArray[2][4]= false;
                printArray[3][0]= true; printArray[3][1]= false; printArray[3][2]= true; printArray[3][3]= false; printArray[3][4]= false;
                printArray[4][0]= true; printArray[4][1]= false; printArray[4][2]= false; printArray[4][3]= true; printArray[4][4]= false;
               break;

            default:
                printArray[0][0]= true; printArray[0][1]= true; printArray[0][2]= true; printArray[0][3]= true; printArray[0][4]= true;
                printArray[1][0]= true; printArray[1][1]= true; printArray[1][2]= true; printArray[1][3]= true; printArray[1][4]= true;
                printArray[2][0]= true; printArray[2][1]= true; printArray[2][2]= true; printArray[2][3]= true; printArray[2][4]= true;
                printArray[3][0]= true; printArray[3][1]= true; printArray[3][2]= true; printArray[3][3]= true; printArray[3][4]= true;
                printArray[4][0]= true; printArray[4][1]= true; printArray[4][2]= true; printArray[4][3]= true; printArray[4][4]= true;
                break;

        }
    }

    private static void printCharacter(boolean[][] printArray, String printingCharacter, String backgroundCharacter) {
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0; j<5;j++) {
                if(printArray[i][j]){
                    System.out.print(printingCharacter);
                }else {
                    System.out.print(backgroundCharacter);
                }
            }
            System.out.println();
        }
    }
}
