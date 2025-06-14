package Tree;

/**
 * https://leetcode.com/problems/same-tree/description/?envType=problem-list-v2&envId=oizxjoit
 * 100. Same Tree
 * Easy
 * Topics
 * Companies
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * <p>
 * <p>
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.left = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        q.left = new TreeNode(3);
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
