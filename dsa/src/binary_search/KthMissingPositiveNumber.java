package binary_search;

// https://leetcode.com/submissions/detail/976473320/
public class KthMissingPositiveNumber {

    private static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 2;
        int num = 1;
        while (k > 0) {
            if (!binarySearch(nums, num)) {
                k--;
            }
            num++;
        }

        System.out.println(num - 1);
    }
}
