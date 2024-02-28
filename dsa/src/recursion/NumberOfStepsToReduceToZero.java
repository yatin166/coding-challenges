package recursion;

public class NumberOfStepsToReduceToZero {

    private static int numberOfSteps(int n, int count) {
        if (n == 0) {
            return count;
        }

        if (n % 2 == 0) {
            return numberOfSteps(n / 2, count + 1);
        }

        return numberOfSteps(n - 1, count + 1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(8, 0));
    }
}
