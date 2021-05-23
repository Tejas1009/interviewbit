package Tree;
/*Invert the Binary Tree
        Asked in:
        Google
        Given a binary tree, invert the binary tree and return it.
        Look at the example for more details.

        Example :
        Given binary tree

        1
        /   \
        2     3
        / \   / \
        4   5 6   7
        invert and return

        1
        /   \
        3     2
        / \   / \
        7   6 5   4*/
public class InvertBinaryTree {

    private TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    public TreeNode invertTree(TreeNode node) {
        return invert(node);
    }

    public static void main(String[] args) {
        InvertBinaryTree i = new InvertBinaryTree();
        BST b = new BST();
        b.root = new TreeNode(1);
        b.root.left = new TreeNode(2);
        b.root.right = new TreeNode(3);
        b.root.left.left = new TreeNode(4);
        b.root.left.right = new TreeNode(5);
        b.root.right.left = new TreeNode(6);
        b.root.right.right = new TreeNode(7);
        i.invertTree(b.root);
    }
}
