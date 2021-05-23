package Tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    private void traverse(TreeNode node, TreeMap<Integer, ArrayList<Integer>> map, int key) {
        if (node == null) {
            return;
        }
        map.putIfAbsent(key, new ArrayList<>());
        ArrayList<Integer> a = map.get(key);
        a.add(node.val);
        map.put(key, a);
        traverse(node.left, map, key - 1);
        traverse(node.right, map, key + 1);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        traverse(node, map, 0);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal v = new VerticalOrderTraversal();
        BST tree = new BST();
        tree.insert(50);
        tree.insert(35);
        tree.insert(25);
        tree.insert(40);
        tree.insert(75);
        tree.insert(65);
        tree.insert(85);
        v.verticalOrderTraversal(tree.root);
    }
}
