package recursion.backtracking;

import java.util.List;

public class UniquePathsIII {

    public static int uniquePaths(int[][] grid, String p, int row, int col, int totalWalkableCells) {

        if (grid[row][col] == -1 || grid[row][col] == -2) {
            return 0;
        }

        if (grid[row][col] == 2) {
            if (p.length() == totalWalkableCells) {
                return 1;
            }
            return 0;
        }

        int answer = 0;
        grid[row][col] = -2;

        // Move Up
        if (row > 0) {
            answer += uniquePaths(grid, p + "U", row - 1, col, totalWalkableCells);
        }

        // Move Right
        if (col < grid[0].length - 1) {
            answer += uniquePaths(grid, p + "R", row, col + 1, totalWalkableCells);
        }

        // Move Down
        if (row < grid.length - 1) {
            answer += uniquePaths(grid, p + "D", row + 1, col, totalWalkableCells);
        }

        // Move Left
        if (col > 0) {
            answer += uniquePaths(grid, p + "L", row, col - 1, totalWalkableCells);
        }

        grid[row][col] = 0;

        return answer;
    }

    public static void main(String[] args) {
        int[][] grid = {
            { 1,0,0,0 },
            { 0,0,0,0 },
            { 0,0,2,-1 }

            /*{1,0,0,0},
            {0,0,0,0},
            {0,0,0,2}*/

            /*{0,1},
            {2,0}*/
        };

        int totalWalkableCells = 0;
        int entry[] = {-1,-1};
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    entry[0] = row;
                    entry[1] = col;
                }
                if (grid[row][col] == 0) {
                    totalWalkableCells += 1;
                }
            }
        }
        totalWalkableCells++;

        System.out.println(uniquePaths(grid, "", entry[0], entry[1], totalWalkableCells));
    }
}
