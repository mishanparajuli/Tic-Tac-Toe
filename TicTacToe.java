import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    // create empty board
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

  
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public static void playGame() {
        boolean gameRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn:");
            System.out.print("Enter row (0, 1, 2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0, 1, 2): ");
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameRunning = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a tie!");
                gameRunning = false;
            } else {
                switchPlayer();
            }
        }
        scanner.close();
    }

    // Switch player
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check if the player won or not
    public static boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    // Check if the board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
