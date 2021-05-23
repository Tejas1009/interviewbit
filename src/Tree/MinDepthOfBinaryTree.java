package Tree;

public class MinDepthOfBinaryTree {
    private int depth(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.right == null && node.left != null) {
            return depth(node.left) + 1;
        }
        if (node.left == null && node.right != null) {
            return depth(node.right) + 1;
        }
        return Math.min(depth(node.left), depth(node.right)) + 1;
    }

    public int minDepth(TreeNode node) {
        int n = depth(node);
        return n;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(35);
        tree.insert(25);
        tree.insert(40);
        tree.insert(75);
        //tree.insert(85);
        MinDepthOfBinaryTree m = new MinDepthOfBinaryTree();
        System.out.println(m.minDepth(tree.root));
    }
}
