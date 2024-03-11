package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NDigitNumbersInIncreasingOrder {

    private static void increasingNumberOrder(int n, String num, List<Integer> list) {
        if (num.length() > n) {
            return;
        }

        if (num.length() > 1) {
            int lastDigit = Character.getNumericValue(num.charAt(num.length() - 1));
            int secondLastDigit = Character.getNumericValue(num.charAt(num.length() - 2));

            if (lastDigit <= secondLastDigit) {
                return;
            }
        }

        if (num.length() == n) {
            list.add(Integer.parseInt(num));
            return;
        }

        for (int i = 1; i <= 9; i++) {
            increasingNumberOrder(n, num + i, list);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<Integer> list = new ArrayList<>();
        if (n == 1) list.add(0);
        increasingNumberOrder(n, "", list);
        System.out.println(list);
    }
}
