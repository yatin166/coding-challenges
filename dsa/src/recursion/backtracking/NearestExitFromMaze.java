package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NearestExitFromMaze {

    private static List<String> nearestExitPathsFromMaze(String path, char[][] maze, int row, int col, int[] entrance) {
        if (maze[row][col] == '+') {
            return List.of();
        }

        if ( (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) && !(row == entrance[0] && col == entrance[1])) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        maze[row][col] = '+';
        List<String> list = new ArrayList<>();

        // Move Up
        if (row > 0) {
            list.addAll(nearestExitPathsFromMaze(path+"U", maze, row-1, col, entrance));
        }

        // Move right
        if (col < maze[0].length - 1) {
            list.addAll(nearestExitPathsFromMaze(path+"R", maze, row, col+1, entrance));
        }

        // Move down
        if (row < maze.length - 1) {
            list.addAll(nearestExitPathsFromMaze(path+"D", maze, row+1, col, entrance));
        }

        // Move left
        if (col > 0) {
            list.addAll(nearestExitPathsFromMaze(path+"L", maze, row, col-1, entrance));
        }

        maze[row][col] = '.';

        return list;
    }

    private static int nearestExitFromMaze(char[][] maze, int row, int col, int[] entrance, int ans) {
        if (maze[row][col] == '+') {
            return 0;
        }

        if ( (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) && !(row == entrance[0] && col == entrance[1])) {
            return ans;
        }

        maze[row][col] = '+';
        int currentAns = maze.length * maze[0].length;

        // Move Up
        if (row > 0) {
            int temp = nearestExitFromMaze(maze, row-1, col, entrance, ans + 1);
            currentAns = temp == 0 ? currentAns : Math.min(temp, currentAns);
        }

        // Move right
        if (col < maze[0].length - 1) {
            int temp = nearestExitFromMaze(maze, row, col+1, entrance, ans + 1);
            currentAns = temp == 0 ? currentAns : Math.min(temp, currentAns);
        }

        // Move down
        if (row < maze.length - 1) {
            int temp = nearestExitFromMaze(maze, row+1, col, entrance, ans + 1);
            currentAns = temp == 0 ? currentAns : Math.min(temp, currentAns);
        }

        // Move left
        if (col > 0) {
            int temp = nearestExitFromMaze(maze, row, col-1, entrance, ans + 1);
            currentAns = temp == 0 ? currentAns : Math.min(temp, currentAns);
        }

        maze[row][col] = '.';

        return currentAns;
    }

    public static void main(String[] args) {
        char[][] maze = {
            {'+','.','+','.','.','+','.','.','+','.','.','.','+','+','.','.','.','.','+','.'},
            {'.','+','+','.','+','.','.','.','+','+','+','.','+','.','.','+','.','+','+','.'},
            {'+','.','.','.','.','+','.','.','.','.','.','.','.','.','+','.','.','+','+','.'},
            {'.','.','.','+','+','.','.','.','+','.','+','.','.','+','.','.','+','.','.','.'},
            {'+','.','.','.','.','.','+','.','.','+','.','.','+','+','.','+','+','.','.','.'},
            {'.','+','.','.','.','.','+','.','+','.','.','.','.','.','.','+','.','+','+','+'},
            {'.','.','.','+','.','.','+','.','+','+','.','+','.','.','.','.','.','+','.','.'},
            {'.','.','.','.','.','+','+','+','.','.','.','+','.','+','+','+','+','.','.','.'},
            {'.','.','+','.','.','+','.','+','.','.','+','.','.','.','.','.','.','.','+','.'},
            {'.','.','.','.','.','.','+','.','+','.','.','.','+','.','+','.','.','.','+','.'},
            {'.','+','.','+','.','.','+','.','+','.','.','+','.','+','.','.','.','.','.','+'},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
            {'+','+','+','+','.','.','+','.','.','.','+','.','.','+','+','+','.','.','.','.'},
            {'.','.','+','+','.','+','.','.','.','.','.','+','+','.','.','+','.','.','.','.'},
            {'.','.','.','+','.','.','.','.','.','.','.','+','.','.','.','.','+','.','.','.'},
            {'.','+','+','.','.','+','.','.','.','.','+','+','.','+','+','.','.','.','+','.'},
            {'+','.','.','.','.','.','+','.','.','.','.','+','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','+','.','.','.','+','.','.','+','.','.','.','.','.','.','.','.'}
        };
        int[] entrance = {17, 15};
        int answer = nearestExitFromMaze(maze, entrance[0], entrance[1], entrance, 0);
        int ans = answer == maze.length * maze[0].length ? -1 : answer;
        System.out.println(ans);
    }
}
