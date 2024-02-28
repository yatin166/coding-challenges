package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = { 3, -11, 5, 2, 34 };
        boolean swapped;

        for (int i = 0; i < nums.length; i++) {
            swapped = false;
            for (int j = i + 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
