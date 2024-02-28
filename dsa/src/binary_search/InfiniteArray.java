package binary_search;

// Find target in infinite array
public class InfiniteArray {

    // Problem with this approach is IndexOutOfBound for the target that is present at the end
    private static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = 1;
        int arraySize = 2;
        while (start <= end && nums[start] <= target) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (end < start) {
                start = arraySize;
                end = (arraySize * 2) + 1;
                arraySize = end + 1;
            }
        }

        return -1;
    }

    private static int optimizedBinarySearch(int[] nums, int target) {
        // find the start and end to process the chunk of array
        int start = 0;
        int end = 1;

        while (target > nums[end]) {
            int newStart = end + 1;
            // end will be prevEnd + (size of array processed * 2)
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

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
        int[] nums = { 3, 5, 7, 9, 12, 14, 45 };
        System.out.println(optimizedBinarySearch(nums, 45));
    }
}
