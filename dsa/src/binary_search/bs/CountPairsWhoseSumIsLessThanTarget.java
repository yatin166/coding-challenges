package binary_search.bs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// BOTH APPROACH WITH TAKE N LOG N COMPLEXITY
public class CountPairsWhoseSumIsLessThanTarget {

    private static int findPairsWithBinarySearch(List<Integer> nums, int target) {
        Collections.sort(nums);
        int noOfPairs = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            int start = i + 1;
            int end = nums.size() - 1;
            while (start <= end && start < nums.size()) {
                int mid = start + (end - start) / 2;
                if (nums.get(i) + nums.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            noOfPairs += end - i;
        }
        return noOfPairs;
    }

    // two pointer approach
    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                // If the sum is less than the target, then all pairs with the current left element
                // will also satisfy the condition. So, increment count by (right - left).
                count += right - left;
                left++;
            } else {
                // If the sum is greater than or equal to the target, decrement the right pointer.
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList( 4, 8, 2, -6, -1, 3, -4);
        int findMinimumLength = findPairsWithBinarySearch(arr,  -2);
        System.out.println(findMinimumLength);
    }
}
