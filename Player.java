public class Player {
    //private instance variables - letter "x" or "o" - and board
    private char sym;

    //constructor - sets instance variable takes true (for x), false (for o)
    //precondition - let = 'x' or 'o'
    public Player(char let) {
        sym = let;
    }

    //getLetter() - returns the letter "x" or "o"
    public char getLetter() {
        return sym;
    }


    //makeMove(board, r, c)
    //precondition - move is valid
    public void makeMove(Board b, int r, int c) {
        //triggers the board makeMove() with r, c, and the instance variable letter
        b.makeMove(r, c, sym);
    }

    //makeMoveOpposite(board, r, c) - makes a move with the opposite symbole
    //precondition - move is valid
    public void makeMoveOpposite(Board b, int r, int c) {
        //same as makeMove, but swaps the letter
        if (sym == 'X') {
            b.makeMove(r, c, 'O');
        }
        else if (sym == 'O') {
            b.makeMove(r, c, 'X');
        }
    }
}