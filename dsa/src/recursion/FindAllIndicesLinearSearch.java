package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllIndicesLinearSearch {

    private static List<Integer> findAllIndices(int[] arr, int index, int target, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndices(arr, index + 1, target, list);
    }

    // Using individual list for each function call
    private static List<Integer> findAllIndices(int[] arr, int index, int target) {
        List<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        List<Integer> ansFromFutureCalls = findAllIndices(arr, index + 1, target);
        list.addAll(ansFromFutureCalls);

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 5, 5, 5, 5, 5};
        System.out.println(Arrays.toString(findAllIndices(arr, 0, 5).toArray()));
    }
}
