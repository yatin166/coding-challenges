package stack;

import java.util.Stack;

public class RemoveOuterMostParentheses {

    private static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                if (!stack.isEmpty()) {
                    sb.append(s.charAt(index));
                }
                stack.push(s.charAt(index));
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(s.charAt(index));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
}
