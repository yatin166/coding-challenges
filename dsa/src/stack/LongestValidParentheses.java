package stack;

import java.util.Stack;

public class LongestValidParentheses {

    private static int longestValidParentheseUsingStack(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                stack.push(index);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(index);
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }

        int pointerOne = s.length();
        int pointerTwo = 0;
        int answer = 0;
        while (!stack.isEmpty()) {
            pointerTwo = stack.pop();
            answer = Math.max(answer, pointerOne - pointerTwo - 1);
            pointerOne = pointerTwo;
        }
        return Math.max(answer, pointerOne);
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(longestValidParentheseUsingStack(s));
    }
}
