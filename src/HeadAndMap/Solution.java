package HeadAndMap;

import java.util.HashMap;

public class Solution {

    class Node {
        int key;
        int val;
        Node next, prev;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private Node start, end;
    private HashMap<Integer, Node> map;

    public Solution(int capacity) {
        this.capacity = capacity;
        start = new Node(-1, -1);
        end = new Node(-1, -1);
        start.next = end;
        end.prev = start;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void set(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.val = val;
            add(node);
        } else {
            if (map.size() == capacity) {
                Node node = end.prev;
                remove(node);
                map.remove(node.key);
            }
            Node temp = new Node(key, val);
            add(temp);
            map.put(key, temp);
        }
    }

    private void add(Node node) {
        node.next = start.next;
        start.next = node;
        node.next.prev = node;
        node.prev = start;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        Solution c = new Solution(1);
        c.set(2, 1);
        c.set(2, 2);
        System.out.println(c.get(2));
        c.set(1, 1);
        c.set(4, 1);
        System.out.println(c.get(2));
    }
}