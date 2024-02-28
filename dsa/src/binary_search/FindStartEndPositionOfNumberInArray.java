package binary_search;

import java.util.Arrays;

public class FindStartEndPositionOfNumberInArray {

    private static int binarySearch(int[] nums, int target, boolean firstIndexSearch) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if(firstIndexSearch) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    private static int[] positionInArray(int[] nums, int target) {
        int startIndex = binarySearch(nums, target, true);
        int endIndex = binarySearch(nums, target, false);

        return new int[] { startIndex, endIndex };
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 7, 7, 8};
        int[] positions = positionInArray(nums, 0);
        System.out.println(Arrays.toString(positions));
    }
}
