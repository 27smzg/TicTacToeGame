public class Board {
    //Initiate private instance variable - 3x3 grid for game board
    private char[][] board = new char[3][3];

    //constructor sets each square to a "-"
    public Board() {
        //Iterate through the 2D array with two for loops
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //Set each square to a "-"
                board[i][j] = "-";
            }
        }
    }

    //isValidMove() - checks if the square is a "-"
    public boolean isValidMove(r,c) {
        if (board[r][c].equals("-")) {
            return true;
        }
        else {
            return false;
        }
    }

    //makeMove(r, c, x/o) changes a square at [r][c] (if it is a "-") to an "x" or "o"
    //precondition r, c represent a position in the array [0-2], and isValidMove(), sym is "x" or "o"
    public void makeMove(int r, int c, char sym) {
        //sets board[r][c] to the sym
        board[r][c] = sym;
    }

    //checkRowWin()
    public boolean checkRowWin() {
        //Iterates through each row, testing if all three are the same x/o
        for (int i = 0; i < board.length; i++) {
            if (!board[i][0].equals("-") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true;
            }
        }
        return false;
    }

    //checkColWin()
    public boolean checkColWin() {
        //Iterates through each column, testing if all three are the same x/o
        for (int i = 0; i < board[0].length; i++) {
            if (!board[0][i].equals("-") && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                return true;
            }
        }
        return false;
    }

    //CheckDiagWin()
    public boolean checkDiagWin() {
        //Iterates through the two diagnowls, testing if all three are the same x/o
        if (!board[0][0].equals("-") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true;
        }
        else if (!board[2][0].equals("-") && board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
            return true;
        }
        return false;
    }

    //checkWin() checks if a win condition has been met - returning true or false
    public boolean checkWin() {
        if (checkRowWin()) {
            return true;
        }
        if (checkColWin()) {
            return true;
        }
        if (checkDiagWin()) {
            return true;
        }
        return false;
    }

    //checkFull()
    public boolean checkFull() {
        //iterates through the array, checking for any dashes - returning false if it finds one, true otherwise
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    //toString() returns a String with each square with a " | " between each, and a row of "  |   |  ", then a row of "--------", repeated for each row
    public String toString() {
        String result = "";
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result += board[i][j];
                if (countOne < 2) {
                    result += " | ";
                    countOne++;
                }
                else if (countOne == 2 && countTwo < 2) {
                    result += "\n--------\n";
                    countOne = 0;
                    countTwo++;
                }
            }
        }
        return result;
    }
}