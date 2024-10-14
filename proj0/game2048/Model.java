package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author syx
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board changed, set the
        // changed local variable to true.
        board.setViewingPerspective(side);
        int size = board.size();
        for (int i = 0; i < size; i++) { // col
            int length = 0; //the length of existing tile
            //the below is to calculate the length of existing tile(i.e. length)
            for (int j = size - 1; j >= 0; j--) { // row
                if (board.tile(i, j) != null) {
                    length++;
                }
            }
            //no existing tile
            if (length == 0) {


            } else if (length == 1) { //one existing file
                //the only tile is on the top, so doesn't change
                if (board.tile(i, size - 1) != null) {

                } else { // the only tile is not on the top, so change
                    changed = true;
                    for (int j = size - 1; j >= 0; j--) {
                        Tile temp = board.tile(i, j);
                        if (temp != null) {
                            board.move(i, size - 1, temp);
                            break;
                        }
                    }
                }
            } else if (length == 2) { // two existing tile
                //the above is to get the two existing tile
                Tile firstTile = null;
                Tile secondTile = null;
                int number = 0;
                for (int j = size - 1; j >= 0; j--) {
                    Tile temp = board.tile(i, j);
                    if (temp != null) {
                        if (number == 0) {
                            firstTile = temp;
                            number += 1;
                        } else if (number == 1) {
                            secondTile = temp;
                            break;
                        }
                    }
                }
                //value is equal
                if (firstTile.value() == secondTile.value()) {
                    score += 2 * firstTile.value();
                    board.move(i, size - 1, firstTile);
                    board.move(i, size - 1, secondTile);
                    changed = true;
                } else { // value is not equal
                    if (firstTile.row() == size - 1 && secondTile.row() == size - 2) {

                    } else {
                        board.move(i, size - 1, firstTile);
                        board.move(i, size - 2, secondTile);
                        changed = true;
                    }
                }
            } else if (length == 3) { // three existing tile
                //the above is to get the three existing tile
                Tile firstTile = null;
                Tile secondTile = null;
                Tile thirdTile = null;
                int number = 0;
                for (int j = size - 1; j >= 0; j--) {
                    Tile temp = board.tile(i, j);
                    if (temp != null) {
                        if (number == 0) {
                            firstTile = temp;
                            number += 1;
                        } else if (number == 1) {
                            secondTile = temp;
                            number += 1;
                        } else if (number == 2) {
                            thirdTile = temp;
                            break;
                        }
                    }
                }
                //do not exist merge
                if (firstTile.value() != secondTile.value() && secondTile.value() != thirdTile.value()) {
                    //changed is false if the three exist at the top
                    if (firstTile.row() == size - 1 && secondTile.row() == size - 2 && thirdTile.row() == size - 3) {

                    } else {
                        board.move(i, size - 1, firstTile);
                        board.move(i, size - 2, secondTile);
                        board.move(i, size - 3, thirdTile);
                        changed = true;
                    }
                } else if (firstTile.value() == secondTile.value()) { // the first two merge
                    score += 2 * firstTile.value();
                    board.move(i, size - 1, firstTile);
                    board.move(i, size - 1, secondTile);
                    board.move(i, size - 2, thirdTile);
                    changed = true;
                } else if (firstTile.value() != secondTile.value() && secondTile.value() == thirdTile.value()) {
                    score += 2 * secondTile.value();
                    board.move(i, size - 1, firstTile);
                    board.move(i, size - 2, secondTile);
                    board.move(i, size - 2, thirdTile);
                    changed = true;
                }
            } else { // four existing tile
                //the above is to get the four existing tile
                Tile firstTile = null;
                Tile secondTile = null;
                Tile thirdTile = null;
                Tile fourthTile = null;
                int number = 0;
                for (int j = size - 1; j >= 0; j--) {
                    Tile temp = board.tile(i, j);
                    if (temp != null) {
                        if (number == 0) {
                            firstTile = temp;
                            number += 1;
                        } else if (number == 1) {
                            secondTile = temp;
                            number += 1;
                        } else if (number == 2) {
                            thirdTile = temp;
                            number += 1;
                        } else {
                            fourthTile = temp;
                            break;
                        }
                    }
                }
                // do not merge
                if (firstTile.value() != secondTile.value() && secondTile.value() != thirdTile.value() && thirdTile.value() != fourthTile.value()) {

                } else if (firstTile.value() == secondTile.value() && thirdTile.value() == fourthTile.value()) { // merge two
                    changed = true;
                    score += 2 * firstTile.value();
                    score += 2 * thirdTile.value();
                    board.move(i, size - 1, secondTile);
                    board.move(i, size - 2, thirdTile);
                    board.move(i, size - 2, fourthTile);
                } else if (firstTile.value() == secondTile.value() && thirdTile.value() != fourthTile.value()) { //first and two merge, three and four does not merge
                    changed = true;
                    score += 2 * firstTile.value();
                    board.move(i, size - 1, secondTile);
                    board.move(i, size - 2, thirdTile);
                    board.move(i, size - 3, fourthTile);
                } else if (firstTile.value() != secondTile.value() && secondTile.value() == thirdTile.value()) { // two and three merge
                    changed = true;
                    score += 2 * secondTile.value();
                    board.move(i, size - 2, thirdTile);
                    board.move(i, size - 3, fourthTile);
                } else if (firstTile.value() != secondTile.value() && secondTile.value() != thirdTile.value() && thirdTile.value() == fourthTile.value()) { // three and four merge
                    changed = true;
                    score += 2 * thirdTile.value();
                    board.move(i, size - 3, fourthTile);

                }
            }

        }
//        if (score > maxScore) {
//            maxScore = score;
//        }
        board.setViewingPerspective(Side.NORTH);
        checkGameOver();
        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {
        int size = b.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b.tile(i, j) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        int size = b.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Tile temp = b.tile(i, j);
                if (temp != null && temp.value() == MAX_PIECE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        int size = b.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b.tile(i, j) == null) {
                    return true;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) {
                    if (b.tile(i, j).value() == b.tile(i, j + 1).value()) {
                        return true;
                    }
                    if (b.tile(i + 1, j).value() == b.tile(i, j).value()) {
                        return true;
                    }
                } else if (i == 0 && j == size - 1) {
                    if (b.tile(i, j).value() == b.tile(i, j - 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i + 1, j).value()) {
                        return true;
                    }

                } else if (i == 0) {
                    if (b.tile(i, j).value() == b.tile(i, j - 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i, j + 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i + 1, j).value()) {
                        return true;
                    }

                } else if (i == size - 1 && j == 0) {
                    if (b.tile(i, j).value() == b.tile(i, j + 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i - 1, j).value()) {
                        return true;
                    }

                } else if (i == size - 1 && j == size - 1) {
                    if (b.tile(i, j).value() == b.tile(i, j - 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i - 1, j).value()) {
                        return true;
                    }

                } else if (i == size - 1) {
                    if (b.tile(i, j).value() == b.tile(i, j - 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i, j + 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i - 1, j).value()) {
                        return true;
                    }
                } else if (j == 0) {
                    if (b.tile(i, j).value() == b.tile(i - 1, j).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i + 1, j).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i, j + 1).value()) {
                        return true;
                    }

                } else if (j == size - 1) {
                    if (b.tile(i, j).value() == b.tile(i, j - 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i + 1, j).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i - 1, j).value()) {
                        return true;
                    }
                } else {
                    if (b.tile(i, j).value() == b.tile(i, j - 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i, j + 1).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i + 1, j).value()) {
                        return true;
                    }
                    if (b.tile(i, j).value() == b.tile(i - 1, j).value()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
