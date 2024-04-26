package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    private static int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static long fibUsingDP(int n, Map<Integer, Long> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 2) {
            return 1;
        }

        var result = fibUsingDP(n - 1, map) + fibUsingDP(n - 2, map);
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Long> map = new HashMap<>();
        System.out.println(fibUsingDP(2, map));
        System.out.println(fibUsingDP(50, map));
    }
}
