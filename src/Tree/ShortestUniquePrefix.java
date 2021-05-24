package Tree;

import java.util.ArrayList;
import java.util.Arrays;

/*Find shortest unique prefix to represent each word in the list.

        Example:

        Input: [zebra, dog, duck, dove]
        Output: {z, dog, du, dov}
        where we can see that
        zebra = z
        dog = dog
        duck = du
        dove = dov
        NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.*/

public class ShortestUniquePrefix {
    static final int MAX_ALPHABETS = 26;

    class TrieNode {
        TrieNode[] child = new TrieNode[MAX_ALPHABETS];
        int count;
        //char ch;
        boolean end;

        TrieNode() {
            end = false;
            count = 0;
            for (int i = 0; i < child.length; i++) child[i] = null;
        }
    }

    TrieNode root = new TrieNode();

    void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (node.child[idx] == null) {
                //node.child[idx].ch = str.charAt(i);
                node.child[idx] = new TrieNode();
                node.child[idx].count = 1;
            } else {
                node.child[idx].count++;
            }
            node = node.child[idx];
        }
        node.end = true;
    }

    String findPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            node = node.child[word.charAt(i) - 'a'];
            prefix = prefix.append(word.charAt(i));
            if (node.count == 1) break;
        }
        return prefix.toString();
    }

    public ArrayList<String> prefix(ArrayList<String> a) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : a) {
            this.insert(s);
        }
        for (String s : a) {
            res.add(findPrefix(s));
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestUniquePrefix s = new ShortestUniquePrefix();
        s.prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove")));
    }

}