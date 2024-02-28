package binary_search.bs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndDoubleExist {

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static boolean usingBinarySearch(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int index = binarySearch(arr, arr[i] * 2);
            if (index != -1 && index != i) {
                return true;
            }
        }
        return false;
    }

    private static boolean optimizedSolution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr) {
            if ((num % 2 == 0 && set.contains(num / 2)) || (set.contains(num * 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-10,-20,5,3};
        System.out.println(optimizedSolution(arr));
    }
}
