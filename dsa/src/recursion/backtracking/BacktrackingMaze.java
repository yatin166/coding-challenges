package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingMaze {

    private static List<String> backtrackMaze(String p, boolean[][] maze, int row, int col) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        if (row < maze.length && col < maze.length && !maze[row][col]) {
            return List.of();
        }

        List<String> list = new ArrayList<>();

        // Mark the cell as visited
        maze[row][col] = false;

        if (row < maze.length - 1) {
            list.addAll(backtrackMaze(p + "D", maze, row + 1, col));
        }

        if (col < maze[0].length - 1) {
            list.addAll(backtrackMaze(p + "R", maze, row, col + 1));
        }

        if (row > 0) {
            list.addAll(backtrackMaze(p + "U", maze, row - 1, col));
        }

        if (col > 0) {
            list.addAll(backtrackMaze(p + "L", maze, row, col - 1));
        }

        maze[row][col] = true;

        return list;
    }

    public static void main(String[] args) {
        System.out.println(backtrackMaze("", new boolean[][] { {true, true, true}, {true, true, true}, {true, true, true} }, 0, 0));
    }
}
