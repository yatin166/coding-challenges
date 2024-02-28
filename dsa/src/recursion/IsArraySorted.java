package recursion;

public class IsArraySorted {

    private static boolean isSorted(int[] arr, int i) {
        if (i + 1 == arr.length) {
            return true;
        }
        return arr[i] < arr[i + 1] && isSorted(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 13, 5, 7, 9};
        System.out.println(isSorted(arr, 0));
    }
}
