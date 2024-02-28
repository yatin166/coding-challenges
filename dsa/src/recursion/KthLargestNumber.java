package recursion;

public class KthLargestNumber {

    private static void usingQuickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int pivot = nums[start + (end - start) / 2];

        while (start <= end) {
            while (nums[start] > pivot) {
                start++;
            }
            while (nums[end] < pivot) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        usingQuickSort(nums, low, end);
        usingQuickSort(nums, start, high);
    }

    private static int usingQuickSelect(int[] nums, int low, int high, int k) {
        int pivot = nums[high];
        int p = low;
        for (int i = 0; i < high; i++) {
            if (nums[i] <= pivot) {
                // swap itself
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        // swap p with last element
        int temp = nums[p];
        nums[p] = nums[high];
        nums[high] = temp;

        if (k < p) {
            // search on left side
            return usingQuickSelect(nums, low, p-1, k);
        } else if (k > p) {
            // search on right side
            return usingQuickSelect(nums, p+1, high, k);
        }

        return nums[p];

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        /*usingQuickSort(nums, 0, nums.length - 1);
        System.out.println(nums[k - 1]);*/
        System.out.println(usingQuickSelect(nums, 0, nums.length - 1, nums.length - k));
    }
}
