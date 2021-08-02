package Others.Udemy.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
/*
Input:
        1
       / \
      2   3
     / \   \
    4   5   6
       /
      7
Output: 1,2,4,7
 */

public class LeftViewOfBinaryTree {

    public static void leftView(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size(), i = 0;
            while (size-- > 0) {
                BinaryTreeNode curr_node = queue.poll();
                if (i++ == 0) {
                    System.out.println(curr_node.data);
                }
                if (curr_node.left != null) queue.add(curr_node.left);
                if (curr_node.right != null) queue.add(curr_node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        leftView(root);
    }
}
