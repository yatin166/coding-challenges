package binary_search;

import java.util.Arrays;

public class MissingNum {

    private static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    private static int missingNumber(int[] nums) {

        Arrays.sort(nums);

        int missingNum = 0;
        while(binarySearch(nums, missingNum)) {
            missingNum++;
        }

        return missingNum;
    }

    private static int optimisedSolution(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;

        while(start < end){
            int mid = (start+end)/2;

            if(nums[mid] > mid) end = mid;
            else start = mid+1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1, 2 };
        System.out.println(optimisedSolution(nums));
    }

}
