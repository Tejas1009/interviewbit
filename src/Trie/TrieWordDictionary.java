package Trie;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=problem-list-v2&envId=oizxjoit
 * 211. Design Add and Search Words Data Structure
 * Medium
 * Topics
 * Companies
 * Hint
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * <p>
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 */
public class TrieWordDictionary {
    public static void main(String[] args) {
        WordDictionary trie = new WordDictionary();
        trie.addWord("bad");
        trie.addWord("dad");
        trie.addWord("mad");
        //System.out.println(trie.search("pad"));
        //System.out.println(trie.search("bad"));
        System.out.println(trie.search(".ad"));
        System.out.println(trie.search("b.."));
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    private boolean search(TrieNode node, String word, int index) {
        if (word.length() == index) {
            return node.isEnd;
        }
        if (word.charAt(index) == '.') {
            TrieNode[] childs = node.children;
            for (TrieNode child : childs) {
                if (child == null) {
                    continue;
                }
                if (search(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = word.charAt(index) - 'a';
            TrieNode child = node.children[idx];
            if (child == null) {
                return false;
            }
            return search(child, word, index + 1);
        }
    }
}
