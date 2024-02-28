package binary_search.bs;

public class PerfectValidSquare {

    private static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num / 2;
        if (num == 1) {
            return true;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            Long square = (mid * 1L) * (mid * 1L);
            if (square == (long)num) {
                return true;
            }
            if (square > (long)num || square < -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(9));
    }
}
