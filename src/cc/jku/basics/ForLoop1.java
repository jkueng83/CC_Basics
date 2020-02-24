package cc.jku.basics;

public class ForLoop1 {
    public static void main(String[] args) {

        int sumOfI = 0;

        for (int i = 0; i < 101; i++) {
            sumOfI = sumOfI + i;
            // System.out.println("actual value of i:" + i);
            // System.out.println("The sum of i : " + sumOfI);

        }

        System.out.println("The sum of i is: " + sumOfI);
    }
}
