package Tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=problem-list-v2&envId=oizxjoit
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Medium
 * Topics
 * Companies
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * <p>
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(lowestCommonAncestor(root, root.right, root.left).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p == root) {
                return p;
            }
            if (q == root) {
                return q;
            }
            //there is split
            if (p.val < root.val && q.val > root.val) {
                return root;
            }
            //there is split
            if (p.val > root.val && q.val < root.val) {
                return root;
            }
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
