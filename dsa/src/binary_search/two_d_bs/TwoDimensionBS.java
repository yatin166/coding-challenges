package binary_search.two_d_bs;

import java.util.Arrays;

public class TwoDimensionBS {

    private static int[] binarySearch(int[][] nums, int target) {
        int row = 0;
        int col = nums.length - 1;
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return new int[] { row, col };
            } else if (nums[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] arr = {
            { 10, 20, 30 },
            { 40, 50, 60 },
            { 70, 80, 90 }
        };
        System.out.println(Arrays.toString(binarySearch(arr,  40)));
    }
}
