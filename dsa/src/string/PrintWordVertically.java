package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/print-words-vertically/
public class PrintWordVertically {

    // Can be optimized to use only one StringBuilder
    public static List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] stringArray = s.split(" ");
        int longestWordLength = 0;
        for (String string: stringArray) {
            longestWordLength = Math.max(longestWordLength, string.length());
        }
        int index = 0;
        while (longestWordLength > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder beforeSpaces = new StringBuilder("");
            for (String string: stringArray) {
                if (index < string.length()) {
                    sb.append(beforeSpaces);
                    sb.append(string.charAt(index));
                    beforeSpaces = new StringBuilder("");
                } else {
                    beforeSpaces.append(" ");
                }
            }
            result.add(sb.toString());
            index++;
            longestWordLength--;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "HOW ARE YOU";

        System.out.println(Arrays.toString(printVertically(s).toArray()));
    }
}
