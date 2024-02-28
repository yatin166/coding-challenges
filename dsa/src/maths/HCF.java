package maths;

public class HCF {

    private static int hcf(int a, int b) {
        if (a == 0) {
            return b;
        }

        return hcf(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println(hcf(105, 224));
    }
}
