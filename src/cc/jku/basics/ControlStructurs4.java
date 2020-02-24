package cc.jku.basics;

import java.util.Random;

public class ControlStructurs4 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber1 = random.nextInt(100);
        int randomNumber2 = random.nextInt(100);

        if (randomNumber1<randomNumber2 && randomNumber1 <20){
            System.out.print("Zahl 1 ist kleiner als Zahl 2 und Mini"+ "\n");
        }
        if (randomNumber1 < 30 || randomNumber2 <30){
            System.out.print("Eine der beiden ist kleiner als 30"+ "\n");
        }
        if (randomNumber1<50 && randomNumber2 !=50 ){
            System.out.print("Erste Zahl klein, zweite kein 50iger"+ "\n");
        }

        System.out.print("Random Number 1: " + randomNumber1+ "\n");
        System.out.print("Random Number 2: " + randomNumber2+ "\n");


    }
}
