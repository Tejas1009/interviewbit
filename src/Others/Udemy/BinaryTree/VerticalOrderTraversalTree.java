package Others.Udemy.BinaryTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
Input:
        1
       / \
      2   3
     / \   \
    4   5   6
       /
      7
 */
public class VerticalOrderTraversalTree {
    private static Map<Integer, ArrayList<Integer>> map;

    public static void verticalOrderPrint(BinaryTreeNode node, int level) {
        if (node == null) return;
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(node.data);
        if (node.left != null) verticalOrderPrint(node.left, level - 1);
        if (node.right != null) verticalOrderPrint(node.right, level + 1);
    }

    public static void main(String[] args) {
        map = new TreeMap<>();
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        verticalOrderPrint(root, 0);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for (Integer v : entry.getValue()) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
