package Others.Udemy.BinaryTree;

public class BinaryTreeDiameter {

    private static int getHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        return 1 + Math.max(l, r);
    }

    public static int diameter(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int l_height = getHeight(node.left);
        int r_height = getHeight(node.right);
        int root_height = l_height + r_height;
        return Math.max(l_height, Math.max(r_height, root_height));
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        System.out.println(diameter(root));
    }
}