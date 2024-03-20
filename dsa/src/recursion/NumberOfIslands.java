package recursion;

public class NumberOfIslands {

    private static void numberOfIslandsUsingRecursion(char[][] grid, int row, int col) {
        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';
        // Move up
        if (row > 0) {
            numberOfIslandsUsingRecursion(grid, row - 1, col);
        }

        // Move right
        if (col < grid[0].length - 1) {
            numberOfIslandsUsingRecursion(grid, row, col + 1);
        }

        // Move down
        if (row < grid.length - 1) {
            numberOfIslandsUsingRecursion(grid, row + 1, col);
        }

        // Move left
        if (col > 0) {
            numberOfIslandsUsingRecursion(grid, row, col - 1);
        }
    }

    private static int numIslands(char[][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslandsUsingRecursion(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
}
