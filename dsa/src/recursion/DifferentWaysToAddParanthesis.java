package recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParanthesis {

    private static List<Integer> differentWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();

        for (int index = 0; index < expression.length(); index++) {
            if (!Character.isDigit(expression.charAt(index))) {
                List<Integer> firstExpression = differentWaysToCompute(expression.substring(0, index));
                List<Integer> secondExpression = differentWaysToCompute(expression.substring(index + 1));
                for (int num1: firstExpression) {
                    for (int num2: secondExpression) {
                        if (expression.charAt(index) == '+') {
                            int evaluation = num1 + num2;
                            ans.add(evaluation);
                        } else if (expression.charAt(index) == '-') {
                            int evaluation = num1 - num2;
                            ans.add(evaluation);
                        } else {
                            int evaluation = num1 * num2;
                            ans.add(evaluation);
                        }
                    }
                }
            }
        }

        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "11";
        System.out.println(differentWaysToCompute(str));
    }
}
