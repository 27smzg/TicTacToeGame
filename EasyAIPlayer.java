public class EasyAIPlayer extends AIPlayer {
    //constructor (just super)
    public EasyAIPlayer (char let, boolean isF) {
        super(let, isF);
    }

    //makeMove(Board a)
    public void makeMove(Board a) {
        //Find coords of a win and a block
        int[] numWin = super.checkForWin(a);
        int[] numBlock = super.checkForBlock(a);
        //Odds that the win and block are played
        int playWin = (int) (Math.random() * 2) + 1;
        int playBlock = (int) (Math.random() * 5) + 1;
        //Boolean flag variable
        boolean moveMade = false;
        //if there's a win, plays it 50% of the time
        if (numWin[0] != -1) {
            //tests if its a valid move
            if (a.isValidMove(numWin[0], numWin[1])) {
                //50% of the time
                if (playWin == 1) {
                    //make the move, and set the flag variable to true
                    super.makeMove(a, numWin[0], numWin[1]);
                    moveMade = true;
                }
            }
        }
        //if there's a block, plays it 40% of the time
        else if (numBlock[0] != -1) {
            if (a.isValidMove(numBlock[0], numBlock[1])) {
                //40% of the time
                if (playBlock <= 2) {
                    //make the move, and set the flag variable to true
                    super.makeMove(a, numBlock[0], numBlock[1]);
                    moveMade = true;
                }
            }
        }
        //else - make a random move
        if (moveMade == false) {
            super.randomMove(a);
        }
    }
}