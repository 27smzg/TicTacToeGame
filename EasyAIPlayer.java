public class EasyAIPlayer extends AIPlayer {
    //constructor (just super)
    public EasyAIPlayer (char let, boolean isF) {
        super(let, isF);
    }

    //makeMove()
    public void makeMove(Board a) {
        int[] numWin = super.checkForWin(a);
        int[] numBlock = super.checkForBlock(a);
        //if there's a win, plays it 75% of the time
        if (numWin[0] != -1) {
            //Make a random number 1-4, if 1-3, plays the win, 4 does not
            int numRandom = (int) (Math.random() * 4) + 1;
            if (numRandom <= 3) {
                super.makeMove(a, numWin[0], numWin[1]);
            }
        }
        //if there's a block, plays it 50% of the time
        else if (numBlock[0] != -1) {
            //Make a random number 1-2, if 1, plays the block, 2 does not
            int numRandom = (int) (Math.random() * 2) + 1;
            if (numRandom == 1) {
                super.makeMove(a, numBlock[0], numBlock[1]);
            }
        }
        //else - make a random move
        else {
            randomMove(a);
        }
    }
}