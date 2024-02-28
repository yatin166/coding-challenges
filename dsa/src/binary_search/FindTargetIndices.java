package binary_search;

// https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class FindTargetIndices {

    private static int binarySearch(int[]nums, int target, boolean searchForFirstOccurrence) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid =  start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (searchForFirstOccurrence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 5};
        int target = 2;
        int firstIndex = binarySearch(nums, target, true);
        int lastIndex = binarySearch(nums, target, false);
        System.out.println(firstIndex + "," + lastIndex);
    }
}
