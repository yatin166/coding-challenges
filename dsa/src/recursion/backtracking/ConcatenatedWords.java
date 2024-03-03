package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

    private static boolean findConcatenatedWords(String word, int start, List<String> words) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < word.length(); i++) {
            sb.append(word.charAt(i));
            if (words.contains(sb.toString())) {
                if (findConcatenatedWords(word, i + 1, words)) {
                    return true;
                }
            }
        }

        return sb.length() > 0 && sb.length() < word.length() && words.contains(sb.toString());
    }

    public static void main(String[] args) {
        String[] words = { "cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat" };

        for (int i = 0; i < words.length; i++) {
            if (findConcatenatedWords(words[i], 0, Arrays.asList(words))) {
                System.out.println(words[i]);
            }
        }
    }
}
