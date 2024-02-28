package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    private static List<List<Integer>> combinationSumIIIncludingDuplicates(int[] candidates, int target, int ans, int start, List<Integer> tempList) {
        if (ans > target) {
            return List.of();
        }

        if (ans == target) {
            return List.of(new ArrayList<>(tempList));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            result.addAll(combinationSumIIIncludingDuplicates(candidates, target, ans + candidates[i], i + 1, tempList));
            tempList.remove(tempList.size() - 1);
        }

        return result;
    }

    private static void helper(int[] arr, int start, int mid, int end) {
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
            i++;
            k++;
        }

        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int index = 0; index < mix.length; index++) {
            arr[start + index] = mix[index];
        }
    }

    private static void sort(int[] arr, int start, int end) {
        if (end - start == 1) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid, end);
        helper(arr, start, mid, end);
    }

    private static List<List<Integer>> combinationSumIIExcludingDuplicates(int[] candidates, int target, int ans, int start, List<Integer> tempList) {
        if (ans > target) {
            return List.of();
        }

        if (ans == target) {
            return List.of(new ArrayList<>(tempList));
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = start; i < candidates.length; i++) {
            // Skip the duplicate number
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            tempList.add(candidates[i]);
            list.addAll(combinationSumIIExcludingDuplicates(candidates, target, ans + candidates[i], i + 1, tempList));
            tempList.remove(tempList.size() - 1);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1,5};
        int target = 8;
        sort(candidates, 0, candidates.length - 1);
        System.out.println(combinationSumIIExcludingDuplicates(candidates, target, 0, 0, new ArrayList<>()));
    }
}
