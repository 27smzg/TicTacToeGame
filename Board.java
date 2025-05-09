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

    //checkRowWin()
        //Iterates through each row, testing if all three are the same x/o

    //checkColWin()
        //Iterates through each column, testing if all three are the same x/o

    //CheckDiagWin()
        //Iterates through the two diagnowls, testing if all three are the same x/o

    //checkWin() checks if a win condition has been met - returning true or false

        //checkRowWin()
        //checkColWin()
        //CheckDiagWin()

        //else returns false

    //checkFull()
        //iterates through the array, checking for any dashes - returning false if it finds one, true otherwise

    //toString() prints each square with a " | " between each, and a row of "  |   |  ", then a row of "--------", repeated for each row

}