package binary_tree.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    private static int ladderLength(String beginWord, String endWord, List<String> dictionary) {
        if (!dictionary.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int len = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            len++;
            for (int i = 0; i < queueSize; i++) {
                String curretnString = queue.poll();

                for (int j = 0; j < curretnString.length(); j++) {
                    char[] tempArr = curretnString.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        tempArr[j] = ch;
                        String newWord = new String(tempArr);

                        if (newWord.equals(endWord)) {
                            return len + 1;
                        }

                        if (dictionary.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> dictionary = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, dictionary));
    }
}
