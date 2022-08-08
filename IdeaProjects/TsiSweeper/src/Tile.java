import java.util.ArrayList;

public class Tile {
    private int x, y;
    private boolean isMine;

    private boolean revealed;
    private boolean flagged;
    private char visibleVal;

    private ArrayList<Tile> neighbours;
    private int neighbourMineNumber;


    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.isMine = false;

        this.revealed = false;
        this.flagged = false;
        this.visibleVal = '*';

        this.neighbours = new ArrayList<>();
        this.neighbourMineNumber = 0;
    }

    public boolean reveal() {
        if (isMine) {
            visibleVal = '!';
            revealed = true;
            // returning true means a mine has been revealed, the game is lost!
            return true;
        } else {
            visibleVal = (char) neighbourMineNumber;
            revealed = true;
            return false;
        }
    }

    public void flag() {
        if (!revealed) {
            if(!flagged) {
                flagged = true;
                visibleVal = 'F';
            } else {
                flagged = false;
                visibleVal = '*';
            }
        }
    }

    public void propagate () {
        // sanity check
        if (isMine) return;
        if (revealed) return;
        reveal();
        // could be an issue if mines are flagged
        if (neighbourMineNumber == 0) {
            for (Tile t2 : neighbours) {
                t2.propagate();
            }
        }
    }



}
