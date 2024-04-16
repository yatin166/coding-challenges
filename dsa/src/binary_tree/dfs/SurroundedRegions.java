package binary_tree.dfs;

public class SurroundedRegions {

    private static void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        // Move up
        if (row > 0) {
            dfs(board, row - 1, col);
        }

        // Move right
        if (col < board[0].length - 1) {
            dfs(board, row, col + 1);
        }

        // Move down
        if (row < board.length - 1) {
            dfs(board, row + 1, col);
        }

        // Move left
        if (col > 0) {
            dfs(board, row, col - 1);
        }
    }

    private static void captureSurrondedRegions(char[][] board) {
        int rowSize = board.length;
        if (rowSize == 0) {
            return;
        }
        int colSize = board[0].length;

        // Check for first & last column boundary
        for (int i = 0; i < rowSize; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][colSize - 1] == 'O') {
                dfs(board, i, colSize - 1);
            }
        }

        // Check for first and last row boundary
        for (int i = 0; i < colSize; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[rowSize - 1][i] == 'O') {
                dfs(board, rowSize - 1, i);
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void print(char[][] board) {
        for (char[] row: board) {
            for (char col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        print(board);
        captureSurrondedRegions(board);
        System.out.println();
        print(board);
    }
}
