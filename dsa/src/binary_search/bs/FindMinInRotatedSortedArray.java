package binary_search.bs;

public class FindMinInRotatedSortedArray {

    private static int findPeakElementIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //int[] arr = { -11, -2, 3, 4, 51, 92 };
        int[] arr = { 3,3,4, 4,5,5, 0, 0, 0, 1,2, 2 };
        int pivotElement = findPeakElementIndex(arr);
        System.out.println(pivotElement + 1);
    }
}
