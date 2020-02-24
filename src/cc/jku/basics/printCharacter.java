package cc.jku.basics;

public class printCharacter {

    public static void main(String[] args) {
        for (int i = 0 ;i<5 ; i++) {
            for (int j = 0 ; j < 5 ; j++){
                if ( (  (i<4)&& (j>=4) ) || ( (i==4) && ( j>0 ) && ( j<4 ) ) || ((i==3) && (j==0)  )){
                    System.out.print("X");
                } else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}
