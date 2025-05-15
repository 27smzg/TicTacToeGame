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

    //setIsFirst(boolean isF) - changes the value of isFirst to the boolean input isF
    public void setIsFirst(boolean isF) {
        isFirst = isF;
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
                if (b.checkWin() && a.isValidMove(i, j)) {
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
        //create a random # 1-9, 1 for the top left, 2 for the top middle -> 9 for the bottom right (according to the getSquare(int) helper method)
        int random = (int) (Math.random() * 9) + 1;
        int orig = random;
        //while loop testing if the move is valid
        while (random > 1 && b.isValidMove(getSquare(random)[0], getSquare(random)[1]) == false) {
            //keep generating random moves
            random--;
        }
        while (random < 9 && b.isValidMove(getSquare(random)[0], getSquare(random)[1]) == false) {
            //keep generating random moves
            random++;
        }
        super.makeMove(b, getSquare(random)[0], getSquare(random)[1]);
    }

    //getSquare(int a) - helper method for randomMove() which gets the r and c for any int 1-9 - 1 for the top left, 2 for the top middle -> 9 for the bottom right
    //precondition int a is [1,9]
    public int[] getSquare(int a) {
        if (a == 1) {
            int[] b = {0, 0};
            return b;
        }
        if (a == 2) {
            int[] b = {0, 1};
            return b;
        }
        if (a == 3) {
            int[] b = {0, 2};
            return b;
        }
        if (a == 4) {
            int[] b = {1, 0};
            return b;
        }
        if (a == 5) {
            int[] b = {1, 1};
            return b;
        }
        if (a == 6) {
            int[] b = {1, 2};
            return b;
        }
        if (a == 7) {
            int[] b = {2, 0};
            return b;
        }
        if (a == 8) {
            int[] b = {2, 1};
            return b;
        }
        if (a == 9) {
            int[] b = {2, 2};
            return b;
        }
        int[] b = {-1, -1};
        return b;
    }
}