package stack;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctChars {

    private static String removeDuplicateLetters(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int[] lastIndex = new int[26];
        for (int index = 0; index < s.length(); index++) {
            lastIndex[s.charAt(index) - 'a'] = index;
        }

        boolean[] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            int currentCharValue = s.charAt(index) - 'a';
            if (visited[currentCharValue]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > currentCharValue && index < lastIndex[stack.peek()]) {
                int lastChar = stack.pop();
                visited[lastChar] = false;
            }

            stack.push(currentCharValue);
            visited[currentCharValue] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}
