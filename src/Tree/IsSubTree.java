package Tree;

/**
 * 572. Subtree of Another Tree
 * Easy
 * Topics
 * Companies
 * Hint
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class IsSubTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.right = new TreeNode(5);
        root.left = new TreeNode(1);
        TreeNode subRoot = new TreeNode(1);
        //subRoot.left = new TreeNode(1);
        //subRoot.right = new TreeNode(2);
        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 == null) {
            return false;
        }

        if (node1 == null && node2 != null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}
