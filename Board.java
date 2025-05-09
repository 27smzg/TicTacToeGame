public class Board
{
    //Initiate private instance variable - 3x3 grid for game board

    //constructor sets each square to a "-"

        //Iterate through the 2D array with two for loops

                //Set each square to a "-"

    //makeMove(r, c, x/o) changes a square at [r][c] (if it is a "-") to an "x" or "o", returning true if changed, false if it was a "-"

        //if statement testing if the [r][c] is a -

            //set [r][c] to x/o and return true

        //else statement

            //return false if not

    //checkWin() checks if a win condition has been met - returning true or false

        //iterate through the array, checking if each square has a matching x/o next/diagnol to it

            //after 1 match, checks in the same direction

            //returns true if count variable reaches 3

        //else returns false

    //toString() prints each square with a " | " between each, and a row of "  |   |  ", then a row of "--------", repeated for each row

}