package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

    private static void wordBreak(String processedString, String[] wordDictionary, List<String> result, StringBuilder possibleAns) {

        if (processedString.length() == 0) {
            result.add(possibleAns.substring(0, possibleAns.length() - 1));
            return;
        }

        for (String word : wordDictionary) {
            if (processedString.startsWith(word)) {
                possibleAns.append(word).append(" ");
                wordBreak(processedString.substring(word.length()), wordDictionary, result, possibleAns);
                possibleAns.replace(possibleAns.length() - (word.length() + 1), possibleAns.length() + 1, "");
            }
        }

    }

    public static void main(String[] args) {
        String s = "catsandog";
        String[] wordDictionary = {"cat","cats","and","sand","dog"};
        List<String> result = new ArrayList<>();
        wordBreak(s, wordDictionary, result, new StringBuilder());
        System.out.println(result);
    }
}
