import java.util.Scanner;
public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToeGame run = new TicTacToeGame();
    }

    Scanner scan = new Scanner(System.in);

    //private instance variable - board
    private Board board = new Board();
    //current player private instance variable - true for human, false for AI
    private boolean curPlay;
    //For AIPlayer - isFirst instance variable
    private boolean isFirst;
    //private instance variable - AI Player
    private AIPlayer playerAI;
    //private isntance variable - for the AI's symbol
    private char symbol;
    //private instance variable - for if the user would like to play
    private boolean play = true;

    //switchPlayer() - switches the current player
    public void switchPlayer () {
        curPlay = !curPlay;
    }

    /* Attempted to make a constructor to run the game --- I'm a  little confused how to get this to work */
    public TicTacToeGame() {
        while (play) {
            //setup for game:
            //prompt user for difficulty, storing their answer
            System.out.println("What difficulty would you like? (Easy/Hard)");
            String dif = scan.nextLine();
            while (!dif.toLowerCase().equals("easy") || !dif.toLowerCase().equals("Hard")) {
                System.out.println("That was not a valid option, please type \"Easy\" or \"Hard\"");
                dif = scan.nextLine();
            }

            //prompt user asking if they want to go first, storing their answer
            System.out.println("Would you like to go first? (Yes/No)");
            String first = scan.nextLine();
            while (!first.toLowerCase().equals("yes") || !first.toLowerCase().equals("no")) {
                System.out.println("That was not a valid option, please type \"Yes\" or \"No\"");
                first = scan.nextLine();
            }
            if (first.toLowerCase().equals("yes")) {
                curPlay = true;
                isFirst = false;
                symbol = 'o';
            } else {
                curPlay = false;
                isFirst = true;
                symbol = 'x';
            }

            //Create an AI bot based on the user's answers
            if (dif.toLowerCase().equals("easy")) {
                playerAI = new EasyAIPlayer(symbol, isFirst);
            } else {
                playerAI = new HardAIPlayer(symbol, isFirst);
            }

            //main game loop:
            System.out.println(board);
            //while checkWin() != true
            while (board.checkWin() != true) {
                //if current player is human
                if (curPlay == true) {
                    int r = -1;
                    int c = -1;
                    while (!board.isValidMove(r, c)) {
                        //prompt user for a move
                        System.out.println("Please choose a move (x coordinate (a-c), then hit enter, then y coordinate (1-3))");
                        //check if move is possible, reprompting if not
                        String xCoord = scan.nextLine().toLowerCase();
                        int yCoord = scan.nextInt();
                        while (!xCoord.equals("a") || !xCoord.equals("b") || !xCoord.equals("c")) {
                            System.out.println("Please enter a valid x coordinate (a-c)");
                            xCoord = scan.nextLine().toLowerCase();
                        }
                        while (yCoord < 1 || yCoord > 3) {
                            System.out.println("Please enter a valid y coordinate (1-3)");
                            yCoord = scan.nextInt();
                        }
                    }
                    System.out.println(board);
                }

                //if current player is ai
                if (curPlay == false) {
                    //AI makes a move
                    playerAI.makeMove(board);
                    //print board
                    System.out.println(board);
                }

                //Switch current player
                switchPlayer();

                //check if the board is full, or if their is a winner, responding appropriately
                if (board.checkWin()) {
                    if (curPlay) {
                        System.out.println("CONGRATULATIONS, YOU HAVE WON!!! (:");
                    } else {
                        System.out.println("I'm sorry, but you have been defeated! ):");
                    }
                }
                if (board.checkFull()) {
                    System.out.println("The game has ended in a draw.");
                }
                //ask if the user would like to play again, and handle input
                System.out.println("Would you like to play again? (Yes or No)");
                String again = scan.nextLine();
                while (!again.toLowerCase().equals("yes") || !again.toLowerCase().equals("no")) {
                    System.out.println("That was not a valid option, please type \"Yes\" or \"No\"");
                    again = scan.nextLine();
                }
                if (again.toLowerCase().equals("yes")) {
                    play = true;
                    System.out.println("Okay, enjoy your next game!");
                } else {
                    play = false;
                    System.out.println("I'm sorry to see you go, I sincerely hope you have a good day.");
                }
            }
        }
    }
}