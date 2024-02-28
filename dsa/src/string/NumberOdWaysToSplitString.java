package string;

public class NumberOdWaysToSplitString {

    private static int numberOfWays(String s) {
        int total = 0;
        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '1') {
                total++;
            }
        }

        if (total == 0) {
            return ((s.length() - 2) * (s.length() - 1)) / 2;
        }

        if (total % 3 != 0) {
            return 0;
        }

        int totalOnes = 0, blockOne = 0, blockTwo = 0;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '1') {
                totalOnes++;
            }
            if (totalOnes == (total / 3)) {
                blockOne++;
            }
            if (totalOnes == ((total / 3) * 2)) {
                blockTwo++;
            }
        }

        return (blockOne * blockTwo) % 1_000_000_007;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays("100100010100110"));
    }
}
