import java.util.*;

class main {
    
    public static void main(String[] args){

        //KAMUS
        sudoku S;
        int a;

        S = new sudoku();
        S.readFile();
        if (S.isValid(0,0)) {
            S.showBoard();
        } else {
            System.out.println("Not a valid one.");
        }

        a = 2 / 3 * 3;
        System.out.println(a);
    }

}