package binary_search.two_d_bs;

import java.util.Arrays;

public class StrictBS {

    private static int[] binarySearch(int matrix[][], int rowIndex, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[rowIndex][mid] == target) {
                return new int[]{rowIndex, mid};
            }
            if (matrix[rowIndex][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] strictSortedMatrixBinarySearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        while (rStart < (rEnd - 1)) {
            int rMid = rStart + (rEnd - rStart) / 2;
            if (matrix[rMid][cMid] == target) {
                return new int[]{rMid, cMid};
            }
            if (matrix[rMid][cMid] > target) {
                rEnd = rMid;
            } else {
                rStart = rMid;
            }
        }

        // check if the
        if (matrix[rStart][cMid] == target) return new int[]{rStart, cMid};
        if (matrix[rEnd][cMid] == target) return new int[]{rEnd, cMid};

        //check 1st row 1st half
        if (matrix[rStart][cMid] > target) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

        if (matrix[rStart][cMid] < target && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }

        if (matrix[rEnd][cMid] > target) {
            return binarySearch(matrix, rEnd, 0, cMid - 1, target);
        }

        if (matrix[rEnd][cMid] < target && target <= matrix[rEnd][cols - 1]) {
            return binarySearch(matrix, rEnd, cMid + 1, cols - 1, target);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1}, {3}, {5}
        };
        System.out.println(Arrays.toString(strictSortedMatrixBinarySearch(arr,  1)));
    }
}
