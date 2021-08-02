package Others.Udemy.BinaryTree;

/*
Max Subset sum:
Find the largest sum of a subset of nodes in a binary tree,
such that if a node is included in the sum then its parent and children
must not be included in the subset sum.

        1
       / \
      2   3
     / \   \
    4   5   6
       /
      7
Output: 18 (7,4,6,1)
 */
public class MaxSubSetSumTree {

    static class SubSetSum {
        int include;
        int exclude;

        public SubSetSum(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }

    public static SubSetSum sum(BinaryTreeNode node) {
        if (node == null) return new SubSetSum(0, 0);
        SubSetSum left = new SubSetSum(0, 0), right = new SubSetSum(0, 0);
        if (node.left != null) {
            left = sum(node.left);
        }
        if (node.right != null) {
            right = sum(node.right);
        }
        int include_sum = node.data + left.exclude + right.exclude;
        int exclude_sum = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);
        return new SubSetSum(include_sum, exclude_sum);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        SubSetSum s = sum(root);
        System.out.println(Math.max(s.exclude, s.include));
    }
}
