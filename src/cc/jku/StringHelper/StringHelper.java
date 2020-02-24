package cc.jku.StringHelper;

import java.util.Scanner;

public class StringHelper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie einen Text ein: ");
        String scanText = scanner.nextLine();

        System.out.println("Ihre Eingabe lautet:");
        System.out.println(scanText);



    }
}
