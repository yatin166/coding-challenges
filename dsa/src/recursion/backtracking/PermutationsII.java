package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    private static void swap(int[] nums, int indexOne, int indexTwo) {
        int temp = nums[indexOne];
        nums[indexOne] = nums[indexTwo];
        nums[indexTwo] = temp;
    }

    private static List<List<Integer>> permutationsII(int[] nums, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            return List.of(new ArrayList<>(tempList));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (used[index] || (index > 0 && nums[index] == nums[index - 1] && !used[index - 1])) continue;
            tempList.add(nums[index]);
            used[index] = true;
            result.addAll(permutationsII(nums, tempList, used));
            tempList.remove(tempList.size() - 1);
            used[index] = false;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Arrays.sort(nums);
        System.out.println(permutationsII(nums, new ArrayList<>(), new boolean[nums.length]));
    }
}
