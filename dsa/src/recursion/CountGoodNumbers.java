package recursion;

public class CountGoodNumbers {

    private static long power(long x, long n, int mod) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        long power = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                power = (power * x) % mod;
            }

            x = (x * x) % mod;
            n = n>>1;
        }

        return power;
    }

    private static int countGoodNumbers(long digit) {
        int mod = (int)1e9+7;
        long numOfFives = digit % 2 == 0 ? power(5, digit/2, mod) % mod : power(5, (digit/2) + 1, mod) % mod;
        long numberOfFour = power(4, digit / 2, mod) % mod;
        return (int ) ((numberOfFour * numOfFives) % mod);
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
}
