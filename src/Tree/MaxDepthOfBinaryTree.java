package Tree;

public class MaxDepthOfBinaryTree {

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l_depth = depth(node.left) + 1;
        int r_depth = depth(node.right) + 1;
        return Math.min(l_depth, r_depth);
    }

    public int maxDepth(TreeNode node) {
        int n = depth(node);
        return n;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(35);
        tree.insert(25);
        //tree.insert(40);
        //tree.insert(75);
        //tree.insert(65);
        MaxDepthOfBinaryTree m = new MaxDepthOfBinaryTree();
        System.out.println(m.maxDepth(tree.root));
    }
}
