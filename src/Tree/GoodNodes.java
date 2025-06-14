package Tree;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 1448. Count Good Nodes in Binary Tree
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class GoodNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val <= maxVal) {
            res++;
        }
        maxVal = Math.max(node.val, maxVal);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);
        return res;
    }
}
