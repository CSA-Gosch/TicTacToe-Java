import java.util.Random;
import java.util.Scanner;

public class main {

    //The char array makes up the contents of the board
    private static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, { '7', '8', '9'}};
    public static void main(String[] args)
    {
        char x;
        Scanner input = new Scanner(System.in);
        title.title();

        displayBoard();

        for (int i = 0; i < 9; i++)
        {
            //Randomized  AI
            Random randCol = new Random();
            Random randRow = new Random();
            int randomCol = randCol.nextInt(2);
            int randomRow = randRow.nextInt(2);

            //Player(user) input for marking the board
            System.out.println("Enter the number you would to play at >>>");
            x = input.next().charAt(0);

            //Placing the AI and player's mark in the array
            for (int k = 0; k < board.length; k++)
            {
                for (int j = 0; j < board.length; j++) {
                    //Player
                    if ((x == board[k][j]) && (board[k][j] != 'O')) {
                        board[k][j] = 'X';
                        playerWin();
                    }
                    //AI
                    else if (board[randomRow][randomCol] != 'X' && board[randomRow][randomCol] != 'O')
                    {
                          board[randomRow][randomCol] = 'O';
                          aiWin();
                    }
                }
            }
            if (playerWin())
            {
                System.out.println("Congrats on winning!");
                i = 9;
            }
            else if (aiWin())
            {
                System.out.println("Sorry, you lost... :(");
                i = 9;
            }
            else
                System.out.println("It was a draw?!?!?!?");
            displayBoard();
        }
    }
    //Displays the Tic-Tac-Toe  board
    public static void displayBoard()
    {
        for (int j = 0; j < board.length; j++){
            for (int i = 0; i < board.length; i++) {
                System.out.print(board[j][i] + " | ");
                if (i == 2) {
                    System.out.println("\n---------");
                }
            }
        }
        System.out.println("");
    }
//    Determines if the player has won
    public static boolean playerWin()
    {
        for (int i = 0; i < 3; i++)
        {
            //Checks columns for win
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && i == 'X'){ return true; }
            //Checks rows for win
            else if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && i == 'X'){ return true; }
            //Checks for a diagonal win
            else if ((board[0][0] == board[1][1] && board[0][0] == board[2][2]) || (board[0][2] == board[1][1] && board[0][2] == board[2][0]) && i == 'X'){ return true; }
        }
        return false;
    }
    //Determines if the AI has won
    public static boolean aiWin()
    {
        for (int i = 0; i < 3; i++)
        {
            //Checks columns for win
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && i == 'O'){ return true; }
            //Checks rows for win
            else if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && i =='O'){ return true; }
            //Checks for a diagonal win
            else if ((board[0][0] == board[1][1] && board[0][0] == board[2][2]) || (board[0][2] == board[1][1] && board[0][2] == board[2][0]) && i == 'O'){ return true; }
        }
        return false;
    }
}
