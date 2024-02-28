package recursion;

public class TargetSum {

    private static int targetSumCombinations(int[] arr, int index, int total, int target) {
        if (index == arr.length) {
            if (total == target) {
                return 1;
            }
            return 0;
        }

        return targetSumCombinations(arr, index + 1, total + arr[index], target) + targetSumCombinations(arr, index + 1, total - arr[index], target);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-1,1};
        int target = 3;
        System.out.println(targetSumCombinations(arr, 0, 0, target));
    }
}
