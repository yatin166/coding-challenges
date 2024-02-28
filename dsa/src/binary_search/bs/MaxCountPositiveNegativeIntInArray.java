package binary_search.bs;

import java.util.Arrays;
import java.util.List;

public class MaxCountPositiveNegativeIntInArray {

    private static int getStartIndexPositiveNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums.length - start;
    }

    private static int getEndIndexOfPositiveNumber(int[] nums) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        int[] arr = { -2,-1,-1, 1, 1,1,2,3 };
        int startIndexPositiveNumber = getStartIndexPositiveNumber(arr);
        int endIndexOfPositiveNumber = getEndIndexOfPositiveNumber(arr);
        System.out.println(Math.max(startIndexPositiveNumber, endIndexOfPositiveNumber));
    }
}
