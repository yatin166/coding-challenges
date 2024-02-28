package binary_search.two_d_bs;

public class CountNegativeNosInSortedMatrix {

    private static int negativeNumbersInMatrix(int[][] matrix) {
        int row = 0;
        int col = matrix[0].length - 1;
        int totalNegativeNumbersInMatrix = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < 0) {
                totalNegativeNumbersInMatrix += matrix.length - row;
                col--;
            } else {
                row++;
            }
        }
        return totalNegativeNumbersInMatrix;
    }

    // Using Binary search
    private static int binarySearch(int[][] matrix, int rowIndex) {
        int start = 0;
        int end = matrix[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[rowIndex][mid] < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static int negativeNumbersInMatrixUsingBS(int[][] matrix) {
        int totalNegativeNumbersInMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            totalNegativeNumbersInMatrix += matrix[row].length - binarySearch(matrix, row);
        }
        return totalNegativeNumbersInMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {4,3,2,-1},
            {3,2,-1,-1},
            {1,-1,-1,-2},
            {-1,-1,-2,-3}
        };
        System.out.println(negativeNumbersInMatrixUsingBS(matrix));
    }
}
