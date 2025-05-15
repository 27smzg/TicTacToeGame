public class HardAIPlayer extends AIPlayer {
    //constructor (just super)
    public HardAIPlayer(char let, boolean isF) {
        super(let, isF);
    }

    //makeMove(Board a)
    public void makeMove(Board a) {
        //Coords of win and block
        int[] numWin = super.checkForWin(a);
        int[] numBlock = super.checkForBlock(a);
        //Boolean flag variable
        boolean moveMade = false;
        //if there's a win
        if (numWin[0] != -1) {
            //test if it's a valid move
            if (a.isValidMove(numWin[0], numWin[1])) {
                //make the move, and set the flag variable to true
                super.makeMove(a, numWin[0], numWin[1]);
                moveMade = true;
            }
        }
        //if there's a block
        else if (numBlock[0] != -1) {
            //test if it's a valid move
            if (a.isValidMove(numBlock[0], numBlock[1])) {
                //make the move, and set the flag variable to true
                super.makeMove(a, numBlock[0], numBlock[1]);
                moveMade = true;
            }
        }
        //else - make a random move
        if (moveMade == false) {
                super.randomMove(a);
        }
    }
}