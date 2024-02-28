package binary_search;

public class FindMinimumIndexOfTargetInMountainArray {

    private static int findPeakElementIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid +1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 7, 5, 4, 2 };
        int target = 3;
        int peakElementIndex = findPeakElementIndex(nums);
        int minIndexOfTargetInFirstHalf = orderAgnosticBinarySearch(nums, target, 0, peakElementIndex - 1, true);
        if (minIndexOfTargetInFirstHalf == -1)
            minIndexOfTargetInFirstHalf = orderAgnosticBinarySearch(nums, target, peakElementIndex, nums.length - 1, false);
        System.out.println("peakElementIndex:" + peakElementIndex + " minIndexOfTargetInFirstHalf:" + minIndexOfTargetInFirstHalf);
    }
}
