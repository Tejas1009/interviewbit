package Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> nei = new HashMap<>();
        ArrayList<String> wordList2 = new ArrayList<>(wordList);
        wordList2.add(beginWord);
        for (String word : wordList2) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                nei.putIfAbsent(pattern, new ArrayList<>());
                nei.get(pattern).add(word);
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return level;
                }
                for (int j = 0; j < currWord.length(); j++) {
                    String pattern = currWord.substring(0, j) + "*" + currWord.substring(j + 1);
                    if (nei.containsKey(pattern)) {
                        for (String nextWord : nei.get(pattern)) {
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                queue.add(nextWord);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
