package binary_search.bs;

public class MinimumSizeSubArraySum {

    private static int findLength(int[] nums, int start, int target) {
        int arrayLen = 0;
        int sum = 0;
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                arrayLen = i - start + 1;
                break;
            }
        }
        return arrayLen;
    }

    private static int minimumLengthSubArray(int[] nums, int target) {
        /*int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int newLen = nums[i] < target && i == nums.length - 1 ? len : findLength(nums, i, target);
            if (newLen < len) {
                len = newLen;
            }
        }
        return len;*/


        int len = nums.length;
        int wholeSum = 0;
        for (int num: nums) {
            wholeSum += num;
        }
        if (wholeSum < target) {
            return 0;
        }
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
                if (sum >= target && (i - start + 1) <= len) {
                    len = i - start + 1;
                }
            }
        }
        return len;
    }

    private static boolean isTargetSumOrGreaterFound(int[] nums, int mid, int target) {
        int start = 0;
        int end = start + mid;
        int counter = start;
        while (end <= nums.length) {
            int sum = 0;
            while (counter < end) {
                sum += nums[counter];
                counter++;
            }
            if (sum >= target) {
                return true;
            }
            start++;
            end = start + mid;
            counter = start;
        }

        return false;
    }

    private static int findMinimumLength(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isTargetSumOrGreaterFound(nums, mid, target)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /*public static int minSubArrayLen(int[] nums, int target) {
        if (nums == null || target < 0) {
            throw new IllegalArgumentException("Input array is null");
        }

        int len = nums.length;
        int start = 1;
        int end = len;
        int minLen = len + 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int foundWindowSize = windowExists(nums, target, mid);
            if (foundWindowSize > 0) {
                end = foundWindowSize - 1;
                minLen = foundWindowSize;
            } else {
                start = mid + 1;
            }
        }

        return minLen % (len + 1);
    }

    private static int windowExists(int[] nums, int target, int maxWindowSize) {
        int foundWindowSize = 0;
        for (int i = 0; i < nums.length; i++) {
            target -= nums[i];
            foundWindowSize++;

            if (i >= maxWindowSize) {
                foundWindowSize--;
                target += nums[i - maxWindowSize];
            }

            if (target <= 0) {
                return foundWindowSize;
            }
        }

        return -1;
    }*/

    private static boolean couldBeAnAnswer(int[] nums, int target, int window) {
        int counter = 1;
        int sum = 0;
        for (int start = 0, end = start + window; start < end && end <= nums.length; start++) {
            sum += nums[start];

            if (sum >= target) {
                return true;
            }

            if (start == end - 1) {
                start = counter - 1;
                end = counter + window;
                sum = 0;
                counter++;
            }
        }
        return false;
    }

    private static int binarySearchFind(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (couldBeAnAnswer(nums, target, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2,3,1,2,4,3 };
        int findMinimumLength = binarySearchFind(arr,  7);
        System.out.println(findMinimumLength);
    }
}
