package Strings;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-words/description/
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 3;
        topKFrequent(words, k).stream().forEach(x -> System.out.println(x));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Data(entry.getKey(), entry.getValue()));
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().word);
        }
        return result;
    }

    static class Data implements Comparable<Data> {
        String word;
        Integer count;

        Data(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Data o) {
            if (Objects.equals(o.count, this.count)) {
                return this.word.compareTo(o.word);
            }
            return o.count - this.count;
        }
    }
}
