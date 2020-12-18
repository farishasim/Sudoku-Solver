import java.util.*;

class main {
    
    public static void main(String[] args){

        //KAMUS
        sudoku S;

        S = new sudoku();
        S.readFile();

        S.showBoard();
    }

}