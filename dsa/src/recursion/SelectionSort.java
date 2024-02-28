package recursion;

import java.util.Arrays;

public class SelectionSort {

    private static void selectionSortUsingRecursion(int[] arr, int max, int i, int j) {
        max = Math.max(arr[i], max);

    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        //selectionSortUsingRecursion(arr);
        System.out.println(Arrays.toString(arr));
    }
}
