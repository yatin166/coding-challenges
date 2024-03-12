package stack;

import java.util.Stack;

public class ValidParentheses {

    private static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char parentheses = s.charAt(index);
            if (parentheses == '(' || parentheses == '[' || parentheses == '{') {
                stack.push(parentheses);
            } else {
                char lastParentheses = !stack.isEmpty() ? stack.pop() : '\0';
                if (parentheses == ')' && lastParentheses != '(') {
                    return false;
                }
                if (parentheses == ']' && lastParentheses != '[') {
                    return false;
                }
                if (parentheses == '}' && lastParentheses != '{') {
                    return false;
                }
            }
            index++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValidParentheses(s));
    }
}
