package recursion;

import java.util.Arrays;

public class MergeSort {

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] sortedMergedArray = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sortedMergedArray[k] = arr1[i];
                i++;
            } else {
                sortedMergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            sortedMergedArray[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2.length) {
            sortedMergedArray[k] = arr2[j];
            k++;
            j++;
        }

        return sortedMergedArray;
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeArrays(arr1, arr2);
    }

    // In place sorting
    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            k++;
            i++;
        }

        while (j < end) {
            mix[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }

    private static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1) return;
        int mid = start + (end - start) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);
        mergeInPlace(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = {3,4,8,5,6,12,2,2};
        //System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}
