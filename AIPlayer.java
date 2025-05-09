public class AIPlayer extends Player
{
    //private instance variables - boolean isFirst

    //constructor - sets instance variables (true for x and isFirst) & (false for o and !isFirst)

    //checkForBlock(board, letter) return int[] {r,c} if there's a block, {-1, -1} otherwise
        //iterates through the 2D array, checking if any square has a matching x or o (opposite of letter) next/diagnol to it

        //if there's a matching x or o, checks if there is a - in the same direciton

        //or the opposite, if there it exceeds the size of the array


    //checkForWin(board, letter) return int[] {r, c} if there's a win, {-1, -1} otherwise
        //iterates through the 2D array, checking if any square has a matching x or o (same as letter) next/diagnol to it

        //if there's a matching x or o, checks if there is a - in the same direciton

        //or the opposite, if there it exceeds the size of the array

    //randomMove() - returns true when made, false otherwise
        //find move by using random number (0-2) for the row and column indices, makeMove() with that returns false, try again if it returns false
}