public class AIPlayer extends Player {
    //private instance variables - boolean isFirst
    private boolean isFirst;

    //constructor - sets instance variables (true for x and isFirst) & (false for o and !isFirst)
    public AIPlayer(char let, boolean isF) {
        super(let);
        isFirst = isF;
    }

    //getIsFirst() - returns isFirst;
    public boolean getIsFirst() {
        return isFirst;
    }

    //checkForBlock(board) return int[] {r,c} if there's a block, {-1, -1} otherwise
    public int[] checkForBlock(Board a) {
        int[] out = {-1, -1};
        //check each square with a clone of the board, and test if it would produce a win for the opposite symbol
        for (int i = 0; i < a.getArr().length; i++) {
            for (int j = 0; j < a.getArr()[0].length; j++) {
                Board b = new Board(a.getArr());
                super.makeMoveOpposite(b, i, j);
                if (b.checkWin()) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    //checkForWin(board) return int[] {r, c} if there's a win, {-1, -1} otherwise
    public int[] checkForWin(Board a) {
        int[] out = {-1, -1};
        //check each square with a clone of the board, and test if it would produce a win
        for (int i = 0; i < a.getArr().length; i++) {
            for (int j = 0; j < a.getArr()[0].length; j++) {
                Board b = a.cloneBoard(a);
                super.makeMove(b, i, j);
                if (b.checkWin()) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
    return out;
    }

    //randomMove(Board b)
    public void randomMove(Board b) {
        //while loop testing if the move is valid
        int r = (int) Math.random() * 3;
        int c = (int) Math.random() * 3;
        while(b.isValidMove(r, c) == false) {
            //keep generating random moves
            r = (int) Math.random() * 3;
            c = (int) Math.random() * 3;
        }
        //when a valid move is found, make it
        super.makeMove(b, r, c);
    }
}