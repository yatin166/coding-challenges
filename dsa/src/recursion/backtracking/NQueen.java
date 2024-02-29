package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueen {

    private static int nQueen(boolean[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(getResult(board));
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueen(board, row + 1, result);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static List<String> getResult(boolean[][] board) {
        List<String> list = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            StringBuilder sb = new StringBuilder();
            for (int colIndex = 0; colIndex < board.length; colIndex++) {
                if (board[rowIndex][colIndex]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> result = new ArrayList<>();
        /*nQueen(new boolean[n][n], 0, result);*/
        System.out.println(nQueen(new boolean[n][n], 0, result));
        //System.out.println(nQueen(new String[n][n], 0, n));
    }
}
