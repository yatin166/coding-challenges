package binary_search.bs;

public class RotationCount {

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > nums[target])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int findPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1])
                return mid;
            if (mid > start && nums[mid] < nums[mid - 1])
                return mid - 1;
            if (start < end && nums[start] < nums[start + 1])
                return start + 1;
            start++;
            if (end > start && nums[end] > nums[end - 1])
                return end;
            end--;
        }
        return -1;
    }

    public static void main(String[] args) {

        //int[] arr = { -11, -2, 3, 4, 51, 92 };
        int[] arr = { 15, 18, 2, 3, 6, 12 };
        int pivotElement = findPivotIndex(arr);
        System.out.println(pivotElement + 1);
    }
}
