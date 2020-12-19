import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class sudoku {

    // Attribute
    int[][] board = new int[9][9];
    int RowSize;
    int ColSize;


    // Constructor
    sudoku() {
        int x,y;
        this.RowSize = 9;
        this.ColSize = 9;

        for (y=0; y<this.RowSize; y++) {
            for (x=0; x<this.ColSize; x++) {
                this.board[y][x] = 0;
            }
        }
    }


    //*******  Methods *******//
    //*** I/O ***//
    void readFile() {
        try {
            File fileObj = new File("input.txt");
            Scanner myReader = new Scanner(fileObj);
            String data;
            String[] dataBrs = new String[0];
            int x,y;
            
            for (y = 0; y < this.RowSize; y++) {
                data = myReader.nextLine();
                dataBrs = data.trim().split(" ");
                for(x = 0; x < this.ColSize; x++) {
                    this.board[y][x] = Integer.parseInt(dataBrs[x]);
                }
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void showBoard() {
        // menuliskan isi matriks ke layar
        // contoh : M.tulisMatriks(); --> tulis isi matriks M
        int x,y;

        for (y = 0; y < this.RowSize; y++) {
            for (x = 0; x < this.ColSize; x++) {
                System.out.print(this.board[y][x] + " ");
            }
            System.out.println();
        }
    }


    //*** Solving Algorithm ***//
    boolean isValid(int x, int y) {
        // Kamus Lokal
        boolean testTile;

        // Algorithm
        if (x == this.ColSize) {
            return this.isValid(0,y+1); // go to next row
        } else {
            testTile = (this.board[y][x] <= this.RowSize) && (this.board[y][x] >= 0);

            if (x == this.ColSize-1 && y == this.RowSize-1) { // at the low-right end of the board
                return testTile;
            } else {
                return testTile && this.isValid(x+1,y);
            }
        }
    }

    boolean isEmptyTile(int x, int y) {
        // true if (x,y) is an empty tile
        return this.board[y][x] == 0;
    }

    boolean isGoodTile(int x,int y) {
        /* Check for row, column, area */
        // Kamus Lokal
        int i,j;
        int areaRow, areaCol;
        boolean good;

        // Algorithm
        good = true;

        // Check row
        for(i = 0; i < this.ColSize; i++) {
            if (this.board[y][x] == this.board[y][i]) {
                if (x != i) {
                    return false;
                }
            }
        }

        // Check column
        for(i = 0; i < this.RowSize; i++) {
            if (this.board[y][x] == this.board[i][x]) {
                if (y != i) {
                    return false;
                }
            }
        }

        // Check Area
        areaRow = y / 3 * 3;
        areaCol = x / 3 * 3;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (this.board[areaRow+i][areaCol+j] == this.board[y][x]) {
                    if (x != areaCol+j && y != areaRow+i) {
                        return false;
                    }
                }
            }
        }

        return good;
    }

    boolean solve(int x, int y) {
        if (x == this.ColSize) 
        {
            return this.solve(0,y+1); // go to next row
        } 
        else if (!isEmptyTile(x, y)) 
        {
            if (x == this.ColSize-1 && y == this.RowSize-1) 
            {
                return this.isGoodTile(x,y);
            } 
            else 
            {
                return this.isGoodTile(x,y) && this.solve(x+1,y);
            }
        }
        else 
        {
            int i;
            boolean solved = false;

            i = 1;
            while (i <= 9 && !solved) {
                this.board[y][x] = i;
                this.showBoard();
                System.out.println("========== TEST ==========");
                if (this.isGoodTile(x,y)) {
                    if (x == this.ColSize-1 && y == this.RowSize-1) 
                    {
                        solved = true; // base case
                    }
                    else
                    {
                        solved = this.solve(x+1,y);
                    }
                } 
                if (!solved) {
                    this.board[y][x] = 0;
                }
                i++;
            }

            return solved;
        }
    }
}
