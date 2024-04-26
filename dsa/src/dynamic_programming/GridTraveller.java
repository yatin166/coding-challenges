package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    private static String getKey(int rowIndex, int colIndex) {
        return String.valueOf(rowIndex) + String.valueOf(colIndex);
    }

    private static int findWays(int rows, int cols, int rowIndex, int colIndex, Map<String, Integer> map) {
        if (map.containsKey(getKey(rowIndex, colIndex))) {
            return map.get(getKey(rowIndex, colIndex));
        }

        if (rowIndex == (rows - 1) || colIndex == (cols - 1)) {
            return 1;
        }

        var result = findWays(rows, cols, rowIndex + 1, colIndex, map) + findWays(rows, cols, rowIndex, colIndex + 1, map);
        map.put(getKey(rowIndex, colIndex), result);
        return result;
    }

    public static void main(String[] args) {
        int startRow = 0;
        int startCol = 0;
        System.out.println(findWays(20, 20, startRow, startCol, new HashMap<>()));
    }
}
