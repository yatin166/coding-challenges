package maths;

public class LCM {

    private static int hcf(int a, int b) {
        if (a == 0) {
            return b;
        }

        return hcf(b % a, a);
    }

    private static int lcm(int a, int b) {
        return (a * b) / hcf(a, b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(3,7));
    }
}
