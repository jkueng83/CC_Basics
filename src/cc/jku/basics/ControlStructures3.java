package cc.jku.basics;

import java.sql.SQLOutput;
import java.util.Random;

public class ControlStructures3 {

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumper = 5 + random.nextInt(6);

        System.out.println("the number is: " + randomNumper);

        switch (randomNumper) {
            case 10:
                System.out.println("Ten");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 5:
                System.out.println("Five");
                break;
            default:
                System.out.println("The number is: " + randomNumper);
                break;
        }


    }
}
