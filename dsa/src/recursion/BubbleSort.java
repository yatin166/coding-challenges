package recursion;

import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSortUsingRecursion(int[] arr, int i, int j) {
        if (i == 0) return;
        if (j < i) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSortUsingRecursion(arr, i, j+1);
        } else {
            bubbleSortUsingRecursion(arr, i-1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        bubbleSortUsingRecursion(arr, arr.length - 1,0);
        System.out.println(Arrays.toString(arr));
    }
}
