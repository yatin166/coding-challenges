package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    private static List<List<Integer>> combinationSumIII(int depth, int target, int ans, int start, List<Integer> possibleAnswer) {
        if (ans > target || possibleAnswer.size() > depth) {
            return List.of();
        }

        if (ans == target && possibleAnswer.size() == depth) {
            return List.of(new ArrayList<>(possibleAnswer));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int index = start; index <= 9; index++) {
            if (index > target) {
                break;
            }
            possibleAnswer.add(index);
            result.addAll(combinationSumIII(depth, target, ans + index, index + 1, possibleAnswer));
            possibleAnswer.remove(possibleAnswer.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(combinationSumIII(3, 9, 0, 1, new ArrayList<>()));
    }
}
