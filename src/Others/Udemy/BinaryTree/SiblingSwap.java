package Others.Udemy.BinaryTree;

/*
Determine if a binary tree can be converted to another by doing any number of swaps of children.

 */
public class SiblingSwap {

    public static boolean equal(BinaryTreeNode x, BinaryTreeNode y) {
        if (x.data == y.data) return true;
        if (x != null && y != null) {
            boolean x_left_equals_y_right = equal(x.left, y.right);
            boolean x_right_equals_y_left = equal(x.right, y.left);
            return x_left_equals_y_right && x_right_equals_y_left;
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode X = new BinaryTreeNode(6);
        X.left = new BinaryTreeNode(3);
        X.right = new BinaryTreeNode(8);
        X.left.left = new BinaryTreeNode(1);
        X.left.right = new BinaryTreeNode(7);
        X.right.left = new BinaryTreeNode(4);
        X.right.right = new BinaryTreeNode(2);
        X.right.left.left = new BinaryTreeNode(1);
        X.right.left.right = new BinaryTreeNode(7);
        X.right.right.right = new BinaryTreeNode(3);

        // construct the second tree
        BinaryTreeNode Y = new BinaryTreeNode(6);
        Y.left = new BinaryTreeNode(8);
        Y.right = new BinaryTreeNode(3);
        Y.left.left = new BinaryTreeNode(2);
        Y.left.right = new BinaryTreeNode(4);
        Y.right.left = new BinaryTreeNode(7);
        Y.right.right = new BinaryTreeNode(1);
        Y.left.left.left = new BinaryTreeNode(3);
        Y.left.right.left = new BinaryTreeNode(1);
        Y.left.right.right = new BinaryTreeNode(7);
        if (equal(X, Y)) {
            System.out.print("Binary tree can be converted");
        } else {
            System.out.print("Binary tree cannot be converted");
        }
    }
}