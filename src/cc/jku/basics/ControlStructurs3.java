package cc.jku.basics;

import java.util.Random;

public class ControlStructurs3 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        System.out.print("The number is: " + randomNumber + "\n");

        if (randomNumber < 20) {
            System.out.print("Mini" + "\n");
        } else if (randomNumber >= 20 && randomNumber <= 50) {
            System.out.print("Medium" + "\n");
        } else {
            System.out.print("Large" + "\n");
        }

    }
}
