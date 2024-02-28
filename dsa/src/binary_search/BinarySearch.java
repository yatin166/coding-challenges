package binary_search;

public class BinarySearch {

    private static int orderAgnosticBinarySearch(int[] arr, int searchElement) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == searchElement)
                return middle;

            if (isAsc) {
                if (arr[middle] > searchElement) {
                    end = middle - 1;
                } else if (arr[middle] < searchElement) {
                    start = middle + 1;
                }
            } else {
                if (arr[middle] > searchElement) {
                    start = middle + 1;
                } else if (arr[middle] < searchElement) {
                    end = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        //int[] arr = { -11, -2, 3, 4, 51, 92 };
        int[] arr = { 98, 94, -22, -67, -562};
        int index = orderAgnosticBinarySearch(arr, 94);
        System.out.println(index);
    }
}
