public class TicTacToeGame {
    Scanner scan = new Scanner(System.in);

    //private instance variable - board
    private Board() board = new Board();
    //current player private instance variable - true for human, false for AI
    private boolean curPlay;
    //For AIPlayer - isFirst instance variable
    private boolean isFirst;
    //private instance variable - difficulty - true for hard, false for easy
    private boolean difficulty;

    public static void main(String[] args) {
        //prompt user for difficulty, storing their answer in the instance variable
        System.out.println("What difficulty would you like? (Easy/Hard)");
        String dif = scan.nextLine();
        while (!dif.toLowerCase().equals("easy") || !dif.toLowerCase().equals("Hard")) {
            System.out.println("That was not a valid option, please type \"Easy\" or \"Hard\"");
            dif = scan.nextLine();
        }
        if (dif.toLowerCase().equals("easy")) {
            difficulty = false;
        }
        else {
            difficulty = true;
        }

        //prompt user asking if they want to go first, storing this in the instance variable
        System.out.println("Would you like to go first? (Yes/No)");
        String first = scan.nextLine();
        while (!first.toLowerCase().equals("yes") || !first.toLowerCase().equals("no")) {
            System.out.println("That was not a valid option, please type \"Yes\" or \"No\"");
            first = scan.nextLine();
        }
        if (first.toLowerCase().equals("yes")) {
            curPlay = true;
            isFirst = false;
        }
        else {
            curPlay = false;
            isFirst = true;
        }



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
}