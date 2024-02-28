package binary_search;

import java.util.Arrays;

public class MatrixBinarySearch {

    private static int[] binarySearch(int[][] nums, int target) {
        int row = 0;
        int col = nums[0].length - 1;
        int[] ans = { -1, -1 };
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                ans[0] = row;
                ans[1] = col;
                return ans;
            }

            if (nums[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 20, 30 },
                { 15, 25 }
        };

        System.out.println(Arrays.toString(binarySearch(matrix, 35)));
    }
}
