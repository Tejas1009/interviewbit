package LinkedList;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 146. LRU Cache
 * Medium
 * Topics
 * Companies
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class LRUCache {
    public static void main(String[] args) {

    }

    class Node {
        Node next;
        Node prev;
        int key;
        int val;

        Node(int key, int val) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtRight(Node node) {
        node.prev = this.right.prev;
        this.right.prev = node;
        node.next = this.right;
        node.prev.next = node;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            this.remove(node);
            this.insertAtRight(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = this.cache.get(key);
        if (node != null) {
            this.remove(node);
        }
        node = new Node(key, value);
        this.cache.put(key, node);
        this.insertAtRight(node);
        if (this.cache.size() > this.capacity) {
            Node removeNode = this.left.next;
            this.remove(removeNode);
            this.cache.remove(removeNode.key);
        }
    }
}
