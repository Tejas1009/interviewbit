package Tree;
/*Problem Description

        Given two Binary Trees A and B, you need to merge them in a single binary tree.

        The merge rule is that if two nodes overlap, then sum of node values is the new value of the merged node.

        Otherwise, the non-null node will be used as the node of new tree.



        Problem Constraints
        1 <= Number of Nodes in A , B <= 105



        Input Format
        First argument is an pointer to the root of binary tree A.

        Second argument is an pointer to the root of binary tree B.



        Output Format
        Return a pointer to the root of new binary tree.



        Example Input
        Input 1:

        A =   2

        / \

        1   4

        /

        5


        B =   3
        / \
        6  1
        \   \
        2   7

        Input 2:

        A =   12

        / \

        11  14


        B =   3
        / \
        6  1



        Example Output
        Output 1:

        5
        / \
        7   5
        / \   \
        5   2   7
        Output 2:

        15
        / \
        17  15


        Example Explanation
        Explanation 1:

        After merging both the trees you get:
        5
        / \
        7   5
        / \   \
        5   2   7
        Explanation 2:

        After merging both the trees we get:
        15
        / \
        17  15*/
public class MergeBinaryTree {

    public TreeNode merge(TreeNode a, TreeNode b) {
        if (a == null) return b;
        if (b == null) return a;
        TreeNode node = new TreeNode(a.val + b.val);
        node.left = merge(a.left, b.left);
        node.right = merge(a.right, b.right);
        return node;
    }

    public TreeNode solve(TreeNode A, TreeNode B) {
        return merge(A, B);
    }

    public static void main(String[] args) {
        MergeBinaryTree m = new MergeBinaryTree();
        BST a = new BST();
        a.root = new TreeNode(2);
        a.root.left = new TreeNode(1);
        a.root.left.left = new TreeNode(5);
        a.root.right = new TreeNode(4);
        BST b = new BST();
        b.root = new TreeNode(3);
        b.root.left = new TreeNode(6);
        b.root.left.right = new TreeNode(2);
        b.root.right = new TreeNode(1);
        b.root.right.right = new TreeNode(7);
        m.solve(a.root, b.root);
    }
}