public class TicTacToeGame {
    public static void main(String[] args){
        Board a = new Board();
        System.out.println(a.toString());
        a.makeMove(0, 1, 'x');
        System.out.println(a);
    }
    //private instance variable - board
    private Board() board = new Board();
    //current player private instance variable - true for human, false for AI
    private boolean curPlay;

    //prompt user for difficulty and if they want to go first
        //stores these in variables


    //switchPlayer() - switches the

    //while checkWin() != true

        //if current player is human
            //prompt user for a move
                //check if move is possible, reprompting if not
            //print board
        //if current player is ai
            //AI makes a move
            //print board
        //board.checkWin()
        //board.checkFull()

    //announce winner
    //ask if the user would like to play again

}