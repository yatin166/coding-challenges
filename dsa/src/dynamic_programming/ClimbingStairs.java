package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static int climbingStairsUsingRecursion(int n, int step) {
        if (n == step) {
            return 1;
        }
        if (step > n) {
            return 0;
        }
        return climbingStairsUsingRecursion(n, step + 1) + climbingStairsUsingRecursion(n, step + 2);
    }

    private static int climbingStairsUsingDP(int n, int step, Map<Integer, Integer> map) {
        if (map.containsKey(step)) {
            return map.get(step);
        }
        if (n == step) {
            return 1;
        }
        if (step > n) {
            return 0;
        }
        var result = climbingStairsUsingDP(n, step + 1, map) + climbingStairsUsingDP(n, step + 2, map);
        map.put(step, result);
        return result;
    }

    public static void main(String[] args) {
        int step = 44;
        //System.out.println(climbingStairsUsingRecursion(step, 0));
        System.out.println(climbingStairsUsingDP(step, 0, new HashMap<>()));
    }
}
