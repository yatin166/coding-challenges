package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private static List<List<Integer>> permutationsUsingRecursion(int[] nums, int start, List<Integer> list) {
        if (list.size() == nums.length) {
            return List.of(new ArrayList<>(list));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int index = start; index < nums.length; index++) {
            if (list.contains(nums[index])) continue;
            list.add(nums[index]);
            result.addAll(permutationsUsingRecursion(nums, 0, list));
            list.remove(list.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permutationsUsingRecursion(nums, 0, new ArrayList<>()));
    }
}
