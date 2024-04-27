package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    private static int minCostClimbingStairsUsingRecursion(int index, int[] cost, int total) {
        if (index >= cost.length || (index + 2) >= cost.length) {
            return total;
        }

        int withOneStep = index + 1;
        int withTwoStep = index + 2;
        return Math.min(minCostClimbingStairsUsingRecursion(withOneStep, cost, total + cost[withOneStep]), minCostClimbingStairsUsingRecursion(withTwoStep, cost, total + cost[withTwoStep]));
    }

    static int[] dp;

    private static int minCostClimbingStairsUsingDP(int[] cost, int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 0 || index == 1) {
            return cost[index];
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        dp[index] = cost[index] + Math.min(minCostClimbingStairsUsingDP(cost, index - 1), minCostClimbingStairsUsingDP(cost, index - 2));
        return dp[index];
    }

    // Using DP [tabulation]
    private static int minCostClimbingStairsUsingDP(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairsUsingRecursion(-1, cost, 0));
        System.out.println("Using DP");

        dp = new int[cost.length];
        System.out.println(Math.min(minCostClimbingStairsUsingDP(cost, cost.length - 1), minCostClimbingStairsUsingDP(cost, cost.length - 2)));

        System.out.println(minCostClimbingStairsUsingDP(cost));
    }
}
