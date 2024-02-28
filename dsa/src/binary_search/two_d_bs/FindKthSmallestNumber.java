package binary_search.two_d_bs;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class FindKthSmallestNumber {

    private static int countNumberLessThanOrEqual(int[][] matrix, int num) {
        int row = 0;
        int col = matrix[0].length - 1;
        int count = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > num) {
                col--;
            } else {
                count += col + 1;
                row++;
            }
        }

        return count;
    }

    private static int kThSmallest(int[][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix[0].length - 1];
        while (min != max) {
            int mid = min + (max - min) / 2;
            if (countNumberLessThanOrEqual(matrix, mid) < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {-2,-1,6},
                { 0,10,11 },
                { 1,21,121 }
        };
        System.out.println(kThSmallest(arr, 11));
    }
}
