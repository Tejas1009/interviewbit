package Tree;

/**
 * 98. Validate Binary Search Tree
 * Medium
 * Topics
 * Companies
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        p.left = new TreeNode(4);
        p.right = new TreeNode(6);
        p.right.right = new TreeNode(7);
        p.right.left = new TreeNode(3);
        System.out.println(isValidBST(p));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }
        System.out.println(node.val + "-" + minVal + "-" + maxVal);
        if (!(node.val > minVal && node.val < maxVal)) {
            return false;
        }
        return isValid(node.left, minVal, node.val) && isValid(node.right, node.val, maxVal);
    }
}
