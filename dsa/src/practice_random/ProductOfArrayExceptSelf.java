package practice_random;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    private static int[] productExceptSelf(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        int current = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] *= current;
            current *= arr[i];
        }
        current = 1;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            result[i] *= current;
            current *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,0,6};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
