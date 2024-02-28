package binary_search;

public class SQRT {

    private static long findSqrt(long x) {
        long start = 0;
        long end = x;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if ((mid * mid) == x) {
                return mid;
            }

            if ((mid * mid) > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println(findSqrt(2147395599));
    }
}
