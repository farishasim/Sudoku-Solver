import java.util.*;

class main {
    
    public static void main(String[] args){

        //KAMUS
        sudoku S;
        int a;

        S = new sudoku();
        S.readFile();
        if (S.isValid(0,0)) {
            if (S.solve(0,0)) {
                
            } else {
                System.out.println("Cannot be solved.");
            }
            S.showBoard();
        } else {
            System.out.println("Not a valid one.");
        }
    }

}