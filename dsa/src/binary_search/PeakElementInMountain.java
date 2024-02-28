package binary_search;

// https://leetcode.com/problems/find-peak-element/
public class PeakElementInMountain {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 5, 8 };
        System.out.println(peakIndexInMountainArray(nums));
    }
}
