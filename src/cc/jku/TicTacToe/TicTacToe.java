package cc.jku.TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println();

        System.out.println("Welcome at TicTacToe");

        int numberOfLines = 3 ;
        int numberOfColumns = 3 ;

        char [][] fieldsInTicTacToe = new char [numberOfLines][numberOfColumns];

        fieldsInTicTacToe[0][0] = 'O' ;
        fieldsInTicTacToe[0][1] = 'O' ;
        fieldsInTicTacToe[0][2] = 'O' ;

        fieldsInTicTacToe[1][0] = 'O' ;
        fieldsInTicTacToe[1][1] = 'O' ;
        fieldsInTicTacToe[1][2] = 'O' ;

        fieldsInTicTacToe[2][0] = 'X' ;
        fieldsInTicTacToe[2][1] = 'X' ;
        fieldsInTicTacToe[2][2] = 'X' ;

        for (int i = 0; i < numberOfLines ; i++) {
            System.out.print("| ");
            for (int j = 0; j <numberOfColumns ; j++) {
                System.out.print( "" + fieldsInTicTacToe[i][j] +" | ");

            }
            System.out.println();

        }


   }}
