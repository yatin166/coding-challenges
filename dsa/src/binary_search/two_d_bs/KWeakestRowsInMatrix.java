package binary_search.two_d_bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
public class KWeakestRowsInMatrix {

   /* private static int[] soldiersPerRow(int[][] matrix) {
        int[] spr = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            int soldiers = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    soldiers++;
                }
            }
            spr[row] = soldiers;
        }

        return spr;
    }

    private static int[] kWeakestRows(int[][] matrix, int k) {
        int[] spr = soldiersPerRow(matrix);
        HashSet<Integer> uniqueSpr = Arrays.stream(spr)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
        List<Integer> sortedSpr = new ArrayList<>(uniqueSpr);
        Collections.sort(sortedSpr);
        int[] kWeakestRows = new int[k];
        int kIndex = 0;
        for (int i = 0; i < sortedSpr.size() && kIndex < k; i++) {
            for (int j = 0; j < spr.length; j++) {
                if (kIndex < k && sortedSpr.get(i) == spr[j]) {
                    kWeakestRows[kIndex] = j;
                    kIndex++;
                }
            }
        }
        return kWeakestRows;
    }*/

    private static int numberOfSoldiersInRow(int[][] matrix, int rowIndex) {
        int start = 0;
        int end = matrix[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[rowIndex][mid] > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end + 1;
    }

    private static int[] kWeakestRows(int[][] matrix, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            int numberOfSoldiers = numberOfSoldiersInRow(matrix, row);
            System.out.println(numberOfSoldiers);
            arr.add((numberOfSoldiers * 10) + row);
        }
        Collections.sort(arr);
        int[] kWeakestRows = new int[k];
        for (int i = 0; i < k; i++) {
            kWeakestRows[i] = arr.get(i) % 10;
        }
        return kWeakestRows;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
            {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
        System.out.println(Arrays.toString(kWeakestRows(arr, 5)));
    }
}
