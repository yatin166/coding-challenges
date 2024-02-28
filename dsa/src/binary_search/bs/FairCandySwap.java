package binary_search.bs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class FairCandySwap {

    private static boolean isValuePresent(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    private static int[] findFairCandySwap(int[] alice, int[] bob) {
        int aliceSum = IntStream.of(alice).sum();
        int bobSum = IntStream.of(bob).sum();

        Arrays.sort(bob);

        int mid = (aliceSum + bobSum) / 2;
        for (int j : alice) {
            int x = mid - (aliceSum - j);
            if (isValuePresent(bob, x)) {
                return new int[]{j, x};
            }
        }

        return new int[]{-1,-1};
    }

    private static int[] optimalSolution(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) S.add(a);
        for (int b : B)
            if (S.contains(b + dif))
                return new int[] {b + dif, b};
        return new int[0];
    }

    public static void main(String[] args) {
        int[] alice = new int[] {5,3,6,8};
        int[] bob = new int[] {3,4,11,2};
        System.out.println(Arrays.toString(optimalSolution(alice, bob)));
    }
}
