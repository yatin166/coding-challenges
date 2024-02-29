package recursion.backtracking;

public class SudokuSolver {

    private static boolean sudokuSolve(char[][] board) {
        int n = board.length;
        int start = -1;
        int end = -1;
        boolean isEmptyCellFound = false;

        // Find empty cell in whole sudoku
        // if you found empty cell mark isEmptyCellFound to true
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    start = row;
                    end = col;
                    isEmptyCellFound = true;
                }
            }
            // You can break, no need to proceed further since the empty cell is found
            if (isEmptyCellFound) {
                break;
            }
        }

        // No empty cell found, means the sudoku is solved
        if (!isEmptyCellFound) {
            return true;
        }

        for (int number = 1; number <= 9; number++) {
            char num = Character.forDigit(number, 10);
            if (isSafe(board, start, end, num)) {
                board[start][end] = num;
                if (sudokuSolve(board)) {
                    // With the last change number in board the sudoku is solved, return back;
                    return true;
                } else {
                    board[start][end] = '.';
                }
            }
        }
        return false;
    }

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

    private static boolean isSafe(char[][] board, int row, int col, char number) {
        // Check col
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == number) {
                return false;
            }
        }

        // Check for row
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }


        // Check for box
        int sqrt = (int)Math.sqrt(board.length);
        int start = row - row % sqrt;
        int end = col - col % sqrt;

        for (int i = start; i < start + sqrt; i++) {
            for (int j = end; j < end + sqrt; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
       /* char[][] sudoku = {
            {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
            {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
            {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
            {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
            {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
            {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
            {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        if (sudokuSolve(sudoku)) {
            for (char[] row: sudoku) {
                for (char num: row) {
                    System.out.print(num + ' ');
                }
                System.out.println();
            }
        }*/


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
