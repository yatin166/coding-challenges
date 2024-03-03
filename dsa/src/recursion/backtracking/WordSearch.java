package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    private static boolean wordSearch(char[][] board, String possibleAnswer, String word, int row, int col) {
        if (possibleAnswer.equals(word)) {
            return true;
        }

        if (!word.startsWith(possibleAnswer)) {
            return false;
        }

        if (board[row][col] == ' ') {
            return false;
        }

        char ch = board[row][col];
        board[row][col] = ' ';
        boolean ans = false;

        // Move up
        if (row > 0) {
            ans = ans || wordSearch(board, possibleAnswer + ch, word, row - 1, col);
            if (ans) return true;
        }

        // Move Right
        if (col < board[0].length - 1) {
            ans = ans || wordSearch(board, possibleAnswer + ch, word, row, col + 1);
            if (ans) return true;
        }

        // Move Down
        if (row < board.length - 1) {
            ans = ans || wordSearch(board, possibleAnswer + ch, word, row + 1, col);
            if (ans) return true;
        }

        // Move Left
        if (col > 0) {
            ans = ans || wordSearch(board, possibleAnswer + ch, word, row, col - 1);
            if (ans) return true;
        }

        // backtrack
        board[row][col] = ch;
        return ans;
    }

    private static List<List<Integer>> getEntries(char[][] board, String word) {
        List<List<Integer>> entries = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    entries.add(List.of(row, col));
                }
            }
        }
        return entries;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}

            /*{'a'}*/

            /*{'a','a','b','a','a','b'},
            {'b','a','b','a','b','b'},
            {'b','a','b','b','b','b'},
            {'a','a','b','a','b','a'},
            {'b','b','a','a','a','b'},
            {'b','b','b','a','b','a'}*/
        };
        String word = "SEE";
        boolean ans = false;
        List<List<Integer>> entries = getEntries(board, word);
        if (entries.size() == 1 && word.length() == 1 && board[entries.get(0).get(0)][entries.get(0).get(1)] == word.charAt(0)) {
            ans = true;
        }
        for (List<Integer> entry: entries) {
            if (wordSearch(board, "", word, entry.get(0), entry.get(1))) {
                ans = true;
                break;
            }
        }
        System.out.println(ans);
        //System.out.println(wordSearch(board, "", word, entry[0], entry[1]));
    }
}
