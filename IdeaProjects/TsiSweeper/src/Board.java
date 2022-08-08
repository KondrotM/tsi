import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private ArrayList<ArrayList<Tile>> board;


    public Board(int x, int y, int mines) {
        this.board = new ArrayList<ArrayList<Tile>>();

        // populates board with tiles
        for (int i = 0; i < x; i++) {
            ArrayList<Tile> column = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                Tile t = new Tile(x, y);
                column.add(t);
            }
            board.add(column);
        }

        // assigns random mines
        int boardSize = x * y;
        ArrayList<Integer> boardInts = new ArrayList<Integer>();
        for (int i = 0; i < boardSize; i++) {
            boardInts.add(i);
        }

        Collections.shuffle(boardInts);

        ArrayList<Integer> minesIndeces = new ArrayList<>();
        System.arraycopy(boardInts, 0, minesIndeces, 0, mines);
        for (int i = 0; i < mines; i++) {

        }



        // create tile relations

    }



    public ArrayList<ArrayList<Tile>> getBoard() {
        return this.board;
    }


//    TODO: Use JavaFX!!!
    public static void main(String[] args) {
       Board b = new Board(10, 10, 10);
//       b.populateBoard();

       for (Object r: b.getBoard()) {

       System.out.println(r);

       }
//       System.out.println(b.populateBoard());



    }
}
