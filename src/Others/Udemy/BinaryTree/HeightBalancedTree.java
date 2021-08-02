package Others.Udemy.BinaryTree;

/*
Height Balanced Tree:
Given a binary tree, check if it is height balanced:
A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced.
2) Right subtree of T is balanced.
3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class HeightBalancedTree {

    //Following solution is O(N^2)
    public static boolean isBalanced(BinaryTreeNode node) {
        if (node == null) return true;
        int l_height = 0, r_height = 0;
        if (node.left != null) l_height = BinaryTreeNode.height(node.left);
        if (node.right != null) r_height = BinaryTreeNode.height(node.right);
        if (Math.abs(l_height - r_height) <= 1) {
            return true;
        }
        return false;
    }

    //Following solution is O(N)
    public static TreeWithHeight isBalancedOptimized(BinaryTreeNode node) {
        if (node == null) return new TreeWithHeight(0, true);
        TreeWithHeight left = null, right = null;
        int l_height = 0, r_height = 0;
        boolean isBalanced = false;
        if (node.left != null) {
            left = isBalancedOptimized(node.left);
            l_height = left.height;
        }
        if (node.right != null) {
            right = isBalancedOptimized(node.right);
            r_height = right.height;
        }
        if (Math.abs(l_height - r_height) <= 1) isBalanced = true;
        TreeWithHeight new_node = new TreeWithHeight(1 + Math.max(l_height, r_height), isBalanced);
        return new_node;
    }

    public static class TreeWithHeight {
        public int height;
        public boolean isBalanced;

        public TreeWithHeight(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        //root.left.right.left.left = new BinaryTreeNode(8);
        root.right.right = new BinaryTreeNode(6);
        //System.out.println(isBalanced(root));
        TreeWithHeight t = isBalancedOptimized(root);
        System.out.println(t.isBalanced);
    }
}
