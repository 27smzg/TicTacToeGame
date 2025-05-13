public class HardAIPlayer extends AIPlayer {
    //constructor (just super)
    public HardAIPlayer (char let, boolean isF) {
        super(let, isF);
    }

    //makeMove(Board a)
    public void makeMove(Board board) {
        boolean moveMade = false;
        //if isFirst is true:
        if (super.getIsFirst() == true) {
            //if board is empty:
            char[][] one = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
            if (board.compareBoard(board, one) && moveMade == false) {
                //play in bottom left corner
                super.makeMove(board, 2, 0);
                moveMade = true;
            }
            //if board is BL, Center -> TR
            char[][] two = {{'-', '-', '-'}, {'-', 'O', '-'}, {'X', '-', '-'}};
            else if (board.compareBoard(board, two) && moveMade == false) {
                super.makeMove(board, 0, 2);
                moveMade = true;
            }
            //if board is BL, C, TR, (TL || BR)
            char[][] three = {{'O', '-', 'X'}, {'-', 'O', '-'}, {'X', '-', '-'}};
            char[][] four ={{'-', '-', 'X'}, {'-', 'O', '-'}, {'X', '-', 'O'}};
            else if ((board.compareBoard(board, three) || board.compareBoard(board, four)) && moveMade == false) {
                //Play opposite left over corner
                if (board.isValidMove(2, 2) == true) {
                    super.makeMove(board, 2, 2);
                }
                else if (board.isValidMove(0, 0) == true) {
                    super.makeMove(board, 0, 0);
                }
                //set isFirst to false
                super.setIsFirst(false);
                moveMade = true;
            }
            //if board is BL, any edge, play corner opposite of edge - so if BE, TL, etc.
            char[][] five = {{'-', 'O', '-'}, {'-', '-', '-'}, {'X', '-', '-'}};
            char[][] six = {{'-', '-', '-'}, {'-', '-', '-'}, {'X', 'O', '-'}};
            else if (board.compareBoard(board, five) || board.compareBoard(board, six) && moveMade == false) {
                super.makeMove(board, 0, 0);
                moveMade = true;
            }
            char[][] seven = {{'-', '-', '-'}, {'O', '-', '-'}, {'X', '-', '-'}};
            char[][] eight = {{'-', '-', '-'}, {'-', '-', 'O'}, {'X', '-', '-'}};
            else if (board.compareBoard(board, seven) || board.compareBoard(board, eight) && moveMade == false) {
                super.makeMove(board, 2, 2);
                moveMade = true;
            }
            //count the number of edges that are 'o's and corners that are 'x's
            int edgeCount = 0;
            int cornerCount = 0;
            if (board.getArr()[0][0] == 'X')
                cornerCount++;
            if (board.getArr()[2][0] == 'X')
                cornerCount++;
            if (board.getArr()[0][2] == 'X')
                cornerCount++;
            if (board.getArr()[2][2] == 'X')
                cornerCount++;
            if (board.getArr()[0][1] == 'O')
                edgeCount++;
            if (board.getArr()[1][0] == 'O')
                edgeCount++;
            if (board.getArr()[1][2] == 'O')
                edgeCount++;
            if (board.getArr()[2][1] == 'O')
                edgeCount++;
            //if board is BL, any two edges, and another corner - TR
            else if (edgeCount == 2 && cornerCount == 2  && moveMade == false) {
                super.makeMove(board, 0, 2);
                //set isFirst to false
                super.setIsFirst(false);
                moveMade = true;
            }
            //if board is BL (any corner) play either BR or TL, depnding on if either is take
            char[][] nine = {{'O', '-', '-'}, {'-', '-', '-'}, {'X', '-', '-'}};
            char[][] ten = {{'-', '-', 'O'}, {'-', '-', '-'}, {'X', '-', '-'}};
            char[][] eleven = {{'-', '-', '-'}, {'-', '-', '-'}, {'X', '', 'O'}};
            else if (board.compareBoard(board, nine) || board.compareBoard(board, ten) || board.compareBoard(board, eleven) && moveMade == false) {
                if (board.isValidMove(2, 2) == true) {
                    super.makeMove(board, 2, 2);
                }
                else if (board.isValidMove(0, 0) == true) {
                    super.makeMove(board, 0, 0);
                }
                moveMade = true;
            }
            //if board is BL, TL or BR (x, bc x goes first) any edge, and a corner (o) - remaning corner
            else if (cornerCount = 2 && edgeCount = 1 && moveMade == false) {
                //set isFirst to false
                if (board.isValidMove(2, 2) == true) {
                    super.makeMove(board, 2, 2);
                }
                else if (board.isValidMove(0, 0) == true) {
                    super.makeMove(board, 0, 0);
                }
                else if (board.isValidMove(0, 2) == true) {
                    super.makeMove(board, 0, 2);
                }
                super.setIsFirst(false);
                moveMade = true;
            }
            //if none of these, set isFirst to false
            else {
                super.setIsFirst(false);
            }
        }
        //else:
        else {
            //check for win - plays win if return != {-1, -1}
            if (super.checkForWin(board)[0] != -1 && moveMade == false) {
                super.makeMove(board, super.checkForWin(board)[0], super.checkForWin(board)[1]);
                moveMade = true;
            }
            //check for block - plays block if return != {-1, -1}
            if (super.checkForBlock(board)[0] != -1 && moveMade == false) {
                super.makeMove(board, super.checkForBlock(board)[0], super.checkForBlock(board)[1]);
                moveMade = true;
            }
            //checks every square (that isn't a "-") by iterating through the array
            for (int i = 0; i < board.getArr().length; i++) {
                for (int j = 0; j < board.getArr()[0].length; j++) {
                    //makes a clone of the Board
                    Board b = board.cloneBoard(board);
                    if (b.isValidMove(i, j)) {
                        b.makeMove(i, j, super.getLetter());
                        //if checkForWin() on an updated temporary board doesn't return {-1, -1} play that move
                        if (super.checkForWin(b)[0] != -1 && moveMade == false) {
                            super.makeMove(b, i, j);
                            moveMade = true;
                            break;
                        }
                    }
                }
            }
        }
        //if no move was made
        if (moveMade == false) {
            super.randomMove(board);
        }
    }
}