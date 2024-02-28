package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NumberOfPathsInMaze {

    private static int numberOfPathsInMaze(int row, int col, int depth) {
        if (row == depth || col == depth) {
            return 1;
        }

        int downWays = numberOfPathsInMaze(row + 1, col, depth);
        int rightWays = numberOfPathsInMaze(row, col + 1, depth);

        return downWays + rightWays;
    }

    private static int numberOfPathsInMazeIncludingDiagonally(int row, int col, int depth) {
        if (row == depth || col == depth) {
            return 1;
        }

        int downWays = numberOfPathsInMazeIncludingDiagonally(row + 1, col, depth);
        int diagonalWays = numberOfPathsInMazeIncludingDiagonally(row + 1, col + 1, depth);
        int rightWays = numberOfPathsInMazeIncludingDiagonally(row, col + 1, depth);

        return downWays + diagonalWays + rightWays;
    }

    private static List<String> pathsInMaze(String p, int row, int col, int depth) {
        if (row == depth && col == depth) {
            List<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        List<String> result = new ArrayList<>();

        if (row < depth) {
            result.addAll(pathsInMaze(p + 'D', row + 1, col, depth));
        }

        if (col < depth) {
            result.addAll(pathsInMaze(p + 'R', row, col + 1, depth));
        }

        return result;
    }

    private static List<String> pathsInMazeIncludingDiagonally(String p, int row, int col, int depth) {
        if (row == depth && col == depth) {
            List<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        List<String> result = new ArrayList<>();

        if (row < depth) {
            result.addAll(pathsInMazeIncludingDiagonally(p + 'D', row + 1, col, depth));
        }

        if (row < depth && col < depth) {
            result.addAll(pathsInMazeIncludingDiagonally(p + 'd', row + 1, col + 1, depth));
        }

        if (col < depth) {
            result.addAll(pathsInMazeIncludingDiagonally(p + 'R', row, col + 1, depth));
        }

        return result;
    }

    private static List<String> pathsInMazeWithObstacle(String p, boolean[][] maze, int row, int col, int depth) {
        if (row < maze.length && col <  maze[0].length && !maze[row][col]) {
            return List.of();
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (row < maze.length) {
            list.addAll(pathsInMazeWithObstacle(p + "D", maze, row + 1, col, depth));
        }

        if (col <  maze[0].length) {
            list.addAll(pathsInMazeWithObstacle(p + "R", maze, row, col + 1, depth));
        }

        return list;
    }

    public static void main(String[] args) {
        // System.out.println(numberOfPathsInMaze(0, 0, 2));
        // System.out.println(pathsInMaze("", 0, 0, 2));
        /*System.out.println(numberOfPathsInMazeIncludingDiagonally(0, 0, 2));
        System.out.println(pathsInMazeIncludingDiagonally("", 0, 0, 2));*/
        System.out.println(pathsInMazeWithObstacle("", new boolean[][] { {true, true, true}, {true, false, true}, {true, true, true} },0, 0, 2));
    }
}
