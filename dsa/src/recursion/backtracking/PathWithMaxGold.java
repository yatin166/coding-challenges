package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathWithMaxGold {

    private static int maxGold(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }

        int maxGold = 0;
        int currentCellCold = grid[row][col];
        grid[row][col] = 0;

        // Move up
        if (row > 0) {
            maxGold = Math.max(maxGold, maxGold(grid, row - 1, col));
        }

        // Move Right
        if (col < grid[0].length - 1) {
            maxGold = Math.max(maxGold, maxGold(grid, row, col + 1));
        }

        // Move Down
        if (row < grid.length - 1) {
            maxGold = Math.max(maxGold, maxGold(grid, row + 1, col));
        }

        // Move Left
        if (col > 0) {
            maxGold = Math.max(maxGold, maxGold(grid, row, col - 1));
        }

        grid[row][col] = currentCellCold;
        return maxGold + currentCellCold;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,6,0},
                {5,8,7},
                {0,9,0},
                /*{1,0,7},
                {2,0,6},
                {3,4,5},
                {0,3,0},
                {9,0,20}*/
        };
        int maxGold = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] > 0) {
                    maxGold = Math.max(maxGold(grid, row, col), maxGold);
                }
            }
        }
        System.out.println(maxGold);
    }
}
