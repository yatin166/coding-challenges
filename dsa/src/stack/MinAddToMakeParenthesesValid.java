package stack;

import java.util.Stack;

public class MinAddToMakeParenthesesValid {

    private static int minAddToMakeValidString(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (Character ch: s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String s = "()))";
        System.out.println(minAddToMakeValidString(s));
    }
}
