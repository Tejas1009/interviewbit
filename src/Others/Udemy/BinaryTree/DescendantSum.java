package Others.Udemy.BinaryTree;

/*
Replace with sum
Given a binary tree, replace every node by sum of all it's
descendants, leave  leaf nodes intact.
Input:
        1
       / \
      2   3
     / \   \
    4   5   6
       /
      7

Output:
        27
       / \
      16  6
      / \  \
     4   7  6
        /
        7

 */
public class DescendantSum {
    public static int build(BinaryTreeNode node) {
        if (node.left == null && node.right == null) return node.data;
        int root_data = node.data, left_data = 0, right_data = 0;
        if (node.left != null) {
            left_data = build(node.left);
        }
        if (node.right != null) {
            right_data = build(node.right);
        }
        node.data = left_data + right_data;
        return node.data + root_data;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        build(root);
        System.out.println(root);
    }
}