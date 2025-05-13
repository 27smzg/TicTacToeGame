public class Board {
    //Initiate private instance variable - 3x3 grid for game board
    private char[][] board = new char[3][3];

    //getArr - returns the 3x3 array board
    public char[][] getArr() {
        return board;
    }

    //constructor sets each square to a "-"
    public Board() {
        //Iterate through the 2D array with two for loops
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //Set each square to a "-"
                board[i][j] = '-';
            }
        }
    }

    //constructor
    public Board(char[][] arr) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //Set each square to a "-"
                board[i][j] = arr[i][j];
            }
        }
    }

    //isValidMove() - checks if the square is a "-", or if r or c are outside the bounds [0,2]
    public boolean isValidMove(int r,int c) {
        //checks if r and c are in [0,2]
        if (r < 0 || r > 2) {
            return false;
        }
        else if (c < 0 || c > 2) {
            return false;
        }
        //checks if the space is "empty"
        else if (board[r][c] != '-') {
            return false;
        }
        return true;
    }

    //makeMove(r, c, x/o) changes a square at [r][c] (if it is a "-") to an "x" or "o"
    //precondition r, c represent a position in the array [0,2], and isValidMove(), sym is "x" or "o"
    public void makeMove(int r, int c, char sym) {
        //sets board[r][c] to the sym
        board[r][c] = sym;
    }

    //cloneBoard(Board a), returns a copy of the board input
    public static Board cloneBoard(Board a) {
        Board b = new Board();
        //iterates through each square in board a, copying it onto board b
        for (int i = 0; i < a.getArr().length; i++) {
            for (int j = 0; j < a.getArr()[0].length; j++) {
                b.getArr()[i][j] = a.getArr()[i][j];
            }
        }
        return b;
    }

    //compareBoard(Board a, Board b) - compares one board's array with the array by checking if each entry is the same as the entry in the corresopnding 2d arrays
    public static boolean compareBoard(Board a, char[][] b) {
        //use two for loops to iterate through the 2D arrays, comparing each entry, if not the same return false
        for (int i = 0; i < a.getArr().length; i++) {
            for (int j = 0; j < a.getArr()[0].length; j++) {
                if (a.getArr()[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        //if all are the same, return true
        return true;
    }

    //checkRowWin()
    public boolean checkRowWin() {
        //Iterates through each row, testing if all three are the same x/o
        for (int i = 0; i < board.length; i++) {
            if (!(board[i][0] == '-') && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    //checkColWin()
    public boolean checkColWin() {
        //Iterates through each column, testing if all three are the same x/o
        for (int i = 0; i < board[0].length; i++) {
            if (!(board[0][i] == '-') && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    //CheckDiagWin()
    public boolean checkDiagWin() {
        //Iterates through the two diagnowls, testing if all three are the same x/o
        if (!(board[0][0] == '-') && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        else if (!(board[2][0] == '-') && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
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
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    //toString() returns a String with each square with a " | " between each, and a row of "  |   |  ", then a row of "--------", repeated for each row
    public String toString() {
        String result = "    a | b | c \n 1 ";
        int countOne = 0;
        int countTwo = 0;
        int row = 2;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result += " " + board[i][j];
                if (countOne < 2) {
                    result += " |";
                    countOne++;
                }
                else if (countOne == 2 && countTwo < 2) {
                    result += "\n-----------\n " + row + " ";
                    row++;
                    countOne = 0;
                    countTwo++;
                }
            }
        }
        return result;
    }
}