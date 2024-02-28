package recursion;

public class PowerXN {

    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / power(x, Math.abs(n));
        }
        return x * power(x, n-1);
    }

    public static void main(String[] args) {
        System.out.println(power(2,0));
        System.out.println(Math.pow(0.00001, 2147483647));
    }
}
