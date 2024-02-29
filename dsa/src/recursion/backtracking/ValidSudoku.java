package recursion.backtracking;

public class ValidSudoku {

    private static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != '.' && isRepeated(board, row, col, board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRepeated(char[][] board, int row, int col, char number) {
        // Check col
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == number) {
                return true;
            }
        }

        // Check for row
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == number) {
                return true;
            }
        }


        // Check for box
        int sqrt = (int)Math.sqrt(board.length);
        int start = row - row % sqrt;
        int end = col - col % sqrt;

        for (int i = start; i < start + sqrt; i++) {
            for (int j = end; j < end + sqrt; j++) {
                if (i != row && j != col && board[i][j] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] sudoku = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(sudoku));
    }
}
