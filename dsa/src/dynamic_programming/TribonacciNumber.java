package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class TribonacciNumber {

    private static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    private static int tribonacciUsingDP(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        var result = tribonacciUsingDP(n - 1, map) + tribonacciUsingDP(n - 2, map) + tribonacciUsingDP(n - 3, map);
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(tribonacciUsingDP(25, new HashMap<>()));
    }
}
