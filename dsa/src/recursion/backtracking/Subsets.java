package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static List<List<Integer>> subsets(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));

        for (int index = start; index < nums.length; index++) {
            list.add(nums[index]);
            subsets(nums, index + 1, list, result);
            list.remove(list.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
}
