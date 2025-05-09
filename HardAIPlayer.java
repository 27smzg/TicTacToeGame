public class HardAIPlayer extends AIPlayer
{
    //constructor (just super)

    //makeMove(isFirst) - returns true when made, false otherwise

        //if isFirst is true:

            //if board is empty:

                //play in bottom left corner

            //if board is BL, Center -> TR

                //if board is BL, C, TR, (TL || BR)

                    //Play opposite left over corner
                    //set isFirst to false

            //if board is BL, any edge, play corner opposite of edge - so if BE, TL, etc.

                //if board is BL, any two edges, and another corner - TR
                    //set isFirst to false

            //if board is BL (any corner) play either BR or TL, depnding on if either is take

                //if board is BL, TL or BR (x, bc x goes first) any edge, and a corner (o) - remaning corner
                    //set isFirst to false

        //else:

            //check for win - plays win if return != {-1, -1}

            //check for block - plays block if return != {-1, -1}

            //checks every square (that isn't a "-") by iterating through the array

                //if checkForWin() on an updated temporary board doesn't return {-1, -1} play that move

}