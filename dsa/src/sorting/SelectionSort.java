package sorting;

import java.util.Arrays;

public class SelectionSort {

    private static int[] selectionSort(int[] arr, boolean isAsc) {
        for (int i = 0; i < arr.length; i++) {
            int swapIndexOne = 0;
            int swapIndexTwo = 0;
            if (isAsc) {
                swapIndexOne = arr.length - i - 1;
                swapIndexTwo = findMaximumNumberIndex(arr, 0, swapIndexOne);
            } else {
                swapIndexOne = i;
                swapIndexTwo = findMaximumNumberIndex(arr, swapIndexOne, arr.length - 1);
            }
            swap(arr, swapIndexOne, swapIndexTwo);
        }
        return arr;
    }

    private static void swap(int[] arr, int endIndex, int maxIndex) {
        int temp = arr[endIndex];
        arr[endIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static int findMaximumNumberIndex(int[] arr, int startIndex, int endIndex) {
        int maxNumberIndex = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[maxNumberIndex] < arr[i]) {
                maxNumberIndex = i;
            }
        }
        return maxNumberIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,44,33,3,55};
        System.out.println(Arrays.toString(selectionSort(arr, false)));
    }
}
