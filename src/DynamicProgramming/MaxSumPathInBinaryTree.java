package DynamicProgramming;

import Tree.BST;
import Tree.TreeNode;

/*Max Sum Path in Binary Tree
        Asked in:
        Directi
        Amazon
        Given a binary tree T, find the maximum path sum.

        The path may start and end at any node in the tree.

        Input Format:

        The first and the only argument contains a pointer to the root of T, A.
        Output Format:

        Return an integer representing the maximum sum path.
        Constraints:

        1 <= Number of Nodes <= 7e4
        -1000 <= Value of Node in T <= 1000
        Example :

        Input 1:

        1
        / \
        2   3

        Output 1:
        6

        Explanation 1:
        The path with maximum sum is: 2 -> 1 -> 3

        Input 2:

        -10
        /  \
        -20  -30

        Output 2:
        -10

        Explanation 2
        The path with maximum sum is: -10
        Seen thi*/

public class MaxSumPathInBinaryTree {

    class Result {
        int r;
    }

    private int recur(TreeNode node, Result res) {
        if (node == null) return 0;
        int l = recur(node.left, res);
        int r = recur(node.right, res);
        int ms = Math.max(Math.max(l, r) + node.val, node.val);
        int ms2 = Math.max(ms, l + r + node.val);
        res.r = Math.max(res.r, ms2);
        return ms;
    }

    public int maxPathSum(TreeNode node) {
        Result r = new Result();
        r.r = Integer.MIN_VALUE;
        recur(node, r);
        return r.r;
    }

    public static void main(String[] args) {
        MaxSumPathInBinaryTree m = new MaxSumPathInBinaryTree();
        BST tree = new BST();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        m.maxPathSum(tree.root);
    }
}
