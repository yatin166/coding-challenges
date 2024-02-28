package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    private static void subsetsII(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));
        for (int index = start; index < nums.length; index++) {
            if (index > start && nums[index] == nums[index - 1])
                continue;
            tempList.add(nums[index]);
            subsetsII(nums, index + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsII(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
}
