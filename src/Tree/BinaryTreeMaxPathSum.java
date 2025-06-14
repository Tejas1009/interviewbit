package Tree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=problem-list-v2&envId=oizxjoit
 * 124. Binary Tree Maximum Path Sum
 * Hard
 * Topics
 * Companies
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeMaxPathSum {
    private static int RESULT = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int res = dfs(root);
        return Math.max(RESULT, res);
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = Math.max(0, dfs(node.left));
        int maxRight = Math.max(0, dfs(node.right));
        //with split
        int currVal = node.val + maxLeft + maxRight;
        RESULT = Math.max(RESULT, currVal);
        //return without split to parent
        return Math.max(node.val + maxLeft, node.val + maxRight);
    }
}
