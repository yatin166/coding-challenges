package recursion.backtracking;

public class NKnights {

    private static void nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            displayBoard(board);
            return;
        }

        if (row == board.length) {
            return;
        }

        if (col == board.length) {
            nKnights(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        } else {
            nKnights(board, row, col + 1, knights);
        }
    }

    private static void displayBoard(boolean[][] board) {
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int colIndex = 0; colIndex < board.length; colIndex++) {
                System.out.print(board[rowIndex][colIndex] ? "K " : "x ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check upper 2 positions
        if (row - 2 >= 0 && col - 1 >= 0 && board[row-2][col-1]) return false;
        if (row - 2 >= 0 && col + 1 < board.length && board[row-2][col+1]) return false;

        // check right position
        if (row - 1 >= 0 && col + 2 < board.length && board[row-1][col+2]) return false;

        // check left position
        if (row - 1 >= 0 && col - 2 >= 0 && board[row-1][col-2]) return false;

        return true;
    }

    public static void main(String[] args) {
        int n = 4, target = 8;
        boolean[][] board = new boolean[n][n];
        nKnights(board, 0, 0, target);
    }
}
