package binary_search.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayLargestSum {

    private static int findPieces(int[] nums, int sum) {
        int total = 0;
        int pieces = 1;
        for (int i = 0; i < nums.length; i++) {
            if (total + nums[i] > sum) {
                pieces++;
                total = nums[i];
            } else {
                total += nums[i];
            }
        }
        return pieces;
    }

    private static int findLargestSum(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            var pieces = findPieces(nums, mid);
            if (pieces <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;

    }

    public static void main(String[] args) {

        //int[] arr = { -11, -2, 3, 4, 51, 92 };
        int[] arr = { 1,2,3,4,5 };
        int pieces = findLargestSum(arr, 2);
        System.out.println(pieces);
    }
}
