package binary_search;

public class SearchInRotetedArray {

    private static int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 3 };
        int peakElementIndex = findPeak(nums);
        int target = 5;
        int findTargetElementIndex = binarySearch(nums, target, 0, peakElementIndex);
        if (findTargetElementIndex == -1) {
            findTargetElementIndex = binarySearch(nums, target, peakElementIndex + 1, nums.length - 1);
        }

        System.out.println(peakElementIndex + ", " + findTargetElementIndex);
    }
}
