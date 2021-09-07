package Others.Udemy.BinaryTree;

import sun.reflect.generics.tree.Tree;

public class SubTreeOfAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static boolean isSubTree(TreeNode a, TreeNode b) {
        TreeNode start = getNode(a, b);
        if (start == null) return false;
        return areSame(start, b);
    }

    private static boolean areSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a.left != null && b.left == null) return false;
        if (a.right != null && b.right == null) return false;
        return a.val == b.val && areSame(a.left, b.left) && areSame(a.right, b.right);
    }

    private static TreeNode getNode(TreeNode root, TreeNode b) {
        if (root == null) return null;
        if (root.val == b.val) return root;
        if (root.left != null) {
            return getNode(root.left, b);
        } else {
            return getNode(root.right, b);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);
        System.out.println(isSubTree(root, tree2));

    }
}
