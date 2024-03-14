package stack;

import java.util.Stack;

public class DecodeString {

    private static String decodeStringUsingStack(String s) {
        Stack<String> stack = new Stack<>();
        for (Character ch: s.toCharArray()) {
            if (ch != ']') {
                stack.push(Character.toString(ch));
            } else {
                String word = "";
                while (stack.peek().charAt(0) != '[') {
                    word = stack.pop() + word;
                }
                stack.pop();
                String k = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k = stack.pop() + k;
                }
                int num = k.length() > 0 ? Integer.parseInt(k) : 0;
                for (int i = 0; i < num; i++) {
                    stack.push(word);
                }
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(decodeStringUsingStack("2[abc]3[cd]ef"));
    }
}
