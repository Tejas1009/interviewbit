package Graph;

import java.util.*;

/**
 *
 */
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node originalNode = queue.poll();
            Node clonedNode = map.get(originalNode);
            List<Node> neighbours = originalNode.neighbors;
            for (Node neighbour : neighbours) {
                if (!map.containsKey(neighbour)) {
                    map.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }
                clonedNode.neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
    }
}
