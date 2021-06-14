package Ninja;
/*Build Identical Trees
        Given two binary trees T1 and T2, you have to find minimum number of insertions to be done in T1 to make it structurally identical to T2. Return -1 if not possible.

        Notes

        Assume insertions are done in a normal fashion in the BSTs.
        Assume while inserting, if the value of a node v is equal to value being inserted, we insert it in left subtree of node v.
        You can insert any positive or negative integer.
        Example :

        Input 1:

        T1:       10
        / \
        9   20

        T2:       5
        / \
        2   7
        /
        1

        If you insert 8 into T1, it will be structurally identical to T2. Hence answer is 1.


        Input 2:

        T1:       10
        / \
        9   20

        T2:       5
        \
        7

        You cannot make T1 and T2 structurally identical. Hence answer is -1.*/
import Tree.BST;
import Tree.TreeNode;

public class BuildIdenticalTrees {

    public int cntMatrixUtil(TreeNode A, TreeNode B, int min, int max) {
        if (A != null && B == null)
            return -1;
        int inserts = -1;
        if (A != null && B != null) inserts = 0;
        else inserts = 1;
        if (B == null && A == null) return 0;
        if (B != null && A == null) A = new TreeNode(min + (max - min) / 2);
        int left = cntMatrixUtil(A.left, B.left, min, A.val);
        int right = cntMatrixUtil(A.right, B.right, A.val, max);
        if (left == -1 || right == -1) return -1;
        return inserts + left + right;
    }

    public int cntMatrix(TreeNode A, TreeNode B) {
        return cntMatrixUtil(A, B, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);

        BST tree2 = new BST();
        tree2.root = new TreeNode(5);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(7);
        tree2.root.left.left = new TreeNode(7);
        BuildIdenticalTrees b = new BuildIdenticalTrees();
        System.out.println(b.cntMatrix(tree.root, tree2.root));
    }
}