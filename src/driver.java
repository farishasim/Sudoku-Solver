import java.util.*;

class driver {
    
    public static void main(String[] args){

        //KAMUS
        sudoku S;
        int a,x,y;
        boolean stop = false;
        Scanner in = new Scanner(System.in);

        S = new sudoku();
        S.readFile();
        if (S.isValid(0,0)) {
            S.showBoard();
        } else {
            System.out.println("Not a valid one.");
        }

        a = 2 / 3 * 3;
        System.out.println(a);

        while (!stop) {
            x = in.nextInt();
            y = in.nextInt();
            if (x == 10) {
                stop = true;
            } else {
                if (S.isGoodTile(x,y)) {
                    System.out.println("A Good Tile");
                } else {
                    System.out.println("A Bad Tile");
                }
            }
        }
    }

}