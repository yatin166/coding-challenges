package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicates {

    private static String removeAdjacentDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (int index = 0; index < s.length(); index++) {
            if (!queue.isEmpty() && queue.getLast() == s.charAt(index)) {
                queue.pollLast();
            } else {
                queue.add(s.charAt(index));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeAdjacentDuplicates(s));
    }
}
