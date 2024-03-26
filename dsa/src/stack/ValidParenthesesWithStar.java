package stack;

import java.util.Stack;

public class ValidParenthesesWithStar {

    public static boolean checkValidString(String s) {
        Stack<Integer> openingBrackets = new Stack<>();
        Stack<Integer> starBrackets = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                openingBrackets.push(index);
            } else if (s.charAt(index) == '*') {
                starBrackets.push(index);
            } else {
                if (openingBrackets.isEmpty() && starBrackets.isEmpty()) {
                    return false;
                } else if (!openingBrackets.isEmpty()) {
                    openingBrackets.pop();
                } else if (!starBrackets.isEmpty()) {
                    starBrackets.pop();
                }
            }
        }

        while (!openingBrackets.isEmpty() && !starBrackets.isEmpty()) {
            if (openingBrackets.pop() > starBrackets.pop()) {
                return false;
            }
        }

        return openingBrackets.isEmpty();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(checkValidString(s));
    }
}
