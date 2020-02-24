package cc.jku.basics;

public class ForLoop2 {
    public static void main(String[] args) {
        int sumOfI = 0;

        for (int i = 2; i < 1001; i = i + 2) {
            sumOfI = sumOfI + i;
            //System.out.println("actual value of i:" + i);
            //System.out.println("The sum of i is: " + sumOfI);

        }

        System.out.println("The sum of i is: " + sumOfI);

    }
}
