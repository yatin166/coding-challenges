package sorting;

import java.util.Arrays;

public class BubbleSort2 {

    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1,6};
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
