package Others.Udemy.BinarySearchTree;

public class CheckIfBST {

    public static boolean isBST(BinarySearchTreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.data < root.left.data) {
            return false;
        }
        if (root.right != null && root.data > root.right.data) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        int arr[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : arr) {
            root = BinarySearchTreeNode.insert(root, i);
        }
        System.out.println(isBST(root));
        BinarySearchTreeNode root2 = new BinarySearchTreeNode(1);
        root2.left = new BinarySearchTreeNode(2);
        root2.left.left = new BinarySearchTreeNode(4);
        root2.right = new BinarySearchTreeNode(3);
        root2.right.right = new BinarySearchTreeNode(6);
        System.out.println(isBST(root2));
    }
}
