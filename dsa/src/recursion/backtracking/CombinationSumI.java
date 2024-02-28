package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    private static List<List<Integer>> combinationSum(int[] nums, int target, List<Integer> templList, int ans, int start) {
        if (ans > target) {
            return List.of();
        }

        if (ans == target) {
            List<List<Integer>> list2 = new ArrayList<>();
            list2.add(new ArrayList<>(templList));
            return list2;
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = start; i < nums.length; i++) {
            // add the num in templList
            templList.add(nums[i]);
            list.addAll(combinationSum(nums, target, templList, ans + nums[i], i));
            //backtrack and remove from tempList
            templList.remove(templList.size() - 1);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] num = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum(num, target, new ArrayList<>(), 0, 0));
    }
}
