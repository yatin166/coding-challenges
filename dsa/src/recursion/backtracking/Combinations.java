package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private static void combinations(int n, int k, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int index = start; index <= n; index++) {
            tempList.add(index);
            combinations(n, k, index + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(1, 1, 1, new ArrayList<>(), result);
        System.out.println(result);
    }
}
