package stack;

import java.util.Stack;

public class MinInsertionToBalanceParentheses {

    private static int minInsertionToBalance(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        int needBrackets = 0;
        int closingBracketsFound = 0;
        for (Character ch: s.toCharArray()) {
            if (ch == '(') {
                if (closingBracketsFound == 1) {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        needBrackets++;
                        stack.pop();
                    } else {
                        needBrackets += 2;
                    }
                    closingBracketsFound = 0;
                }
                stack.push(ch);
            } else {
                closingBracketsFound++;
                if (closingBracketsFound == 2) {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        needBrackets++;
                    }
                    closingBracketsFound = 0;
                }
            }
        }

        if (closingBracketsFound == 1) {
            if (!stack.isEmpty()) {
                needBrackets++;
                stack.pop();
            } else {
                needBrackets += 2;
            }
        }

        return (stack.size() * 2) + needBrackets;
    }

    // Optimal solution
    private static int minimumInsertionsToBalance(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int needBrackets = 0;
        int carried = 0;

        for (Character bracket: s.toCharArray()) {
            if (bracket == '(') {
                needBrackets += 2;
                if (needBrackets % 2 != 0) {
                    needBrackets -= 1;
                    carried += 1;
                }
            } else {
                needBrackets -= 1;
                if (needBrackets < 0) {
                    needBrackets += 2;
                    carried += 1;
                }
            }
        }

        return needBrackets + carried;
    }

    public static void main(String[] args) {
        String s = "(()))";
        System.out.println(minimumInsertionsToBalance(s));
    }
}
