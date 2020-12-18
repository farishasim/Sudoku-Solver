import java.util.*;
import java.io.File;

class sudoku {

    // Attribute
    int[][] board = new int[9][9];
    int RowSize;
    int ColSize;

    // Constructor
    sudoku() {
        int x,x;
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
            
            /*
            i = 0;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                dataBrs = data.trim().split(" ");
                for(j=0; j<dataBrs.length; j++){
                    this.Mat[i][j] = Float.parseFloat(dataBrs[j]);
                }
                i++;
            }
            */
            for (y = 0; y < this.RowSize; y++) {
                data = myReader.nextLine();
                dataBrs = data.trim().split(" ");
                for(x = 0; x < this.ColSize; x++) {
                    this.board[y][x] = Integer.parseInt(dataBrs[j]);
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
}
