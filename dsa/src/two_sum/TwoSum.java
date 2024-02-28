package two_sum;

import java.util.ArrayList;
import java.util.Collections;

//Used two pointer method
public class TwoSum {

    ArrayList<Pair<Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {

        ArrayList<Pair<Integer>> pairs = new ArrayList<>();
        Collections.sort(arr);
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr.get(start) + arr.get(end);
            if (sum == target) {
                pairs.add(new Pair<>(arr.get(start), arr.get(end)));
                start++;
                end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        if (pairs.isEmpty()) {
            pairs.add(new Pair<>(-1 , -1));
        }

        return pairs;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(3);
        int target = 1;

        arr.add(-1);
        arr.add(2);
        arr.add(-1);
        arr.add(2);
        arr.add(5);
        int n = arr.size();

        TwoSum main = new TwoSum();
        ArrayList<Pair<Integer>> pairs = main.twoSum(arr, target, n);
        pairs.forEach(pair -> System.out.println(pair.x() + " " + pair.y()));
    }
}