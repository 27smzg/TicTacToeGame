public class AIPlayer extends Player {
    //private instance variables - boolean isFirst
    private boolean isFirst;

    //constructor - sets instance variables (true for x and isFirst) & (false for o and !isFirst)
    public AIPlayer(char let, boolean isF) {
        super(let);
        isFirst = isF;
    }

    //getIsFirst() - returns isFirst;
    public char getIsFirst() {
        return isFirst;
    }

    //checkRow(int r) - checks the row, returning the array of that row

    //checkCol

    //checkDiag
/* having issues with the ai functionality */
    //checkForBlock(board, letter) return int[] {r,c} if there's a block, {-1, -1} otherwise
    public checkForBlock(board b, char let) {
        for (int i = 0; i < board.length; i++) {
            if (())
        }

        //if there's a matching x or o, checks if there is a - in the same direciton

        //or the opposite, if there it exceeds the size of the array
    }

    //checkForWin(board, letter) return int[] {r, c} if there's a win, {-1, -1} otherwise
        //iterates through the 2D array, checking if any square has a matching x or o (same as letter) next/diagnol to it

        //if there's a matching x or o, checks if there is a - in the same direciton

        //or the opposite, if there it exceeds the size of the array

    //randomMove()
        //find move by using random number (0-2) for the row and column indices, makeMove() with that returns false, try again if it returns false

}