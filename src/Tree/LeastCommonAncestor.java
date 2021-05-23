package Tree;

/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

        Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
        Example :


        _______3______
        /              \
        ___5__          ___1__
        /      \        /      \
        6      _2_     0        8
        /   \
        7    4
        For the above tree, the LCA of nodes 5 and 1 is 3.

        LCA = Lowest common ancestor
        Please note that LCA for nodes 5 and 4 is 5.

        You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
        No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
        There are no duplicate values.
        You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.*/
public class LeastCommonAncestor {

    private boolean exists(TreeNode node, int val) {
        if (node == null) return false;
        if (node.val == val) return true;
        boolean found = false;
        found = exists(node.left, val);
        found = found == true ? true : exists(node.right, val);
        return found;
    }

    private TreeNode findLca(TreeNode node, int b, int c) {
        if (node == null) return null;
        if (node.val == b || node.val == c) return node;
        TreeNode l = findLca(node.left, b, c);
        TreeNode r = findLca(node.right, b, c);
        if (l != null && r != null) return node;
        if (l == null && r != null) return r;
        return l;
    }

    public int lca(TreeNode A, int B, int C) {
        if (!exists(A, B) || !exists(A, C))
            return -1;
        TreeNode r = findLca(A, B, C);
        return r.val;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(35);
        tree.insert(25);
        tree.insert(40);
        //tree.insert(75);
        tree.insert(65);
        tree.insert(85);
        LeastCommonAncestor lca = new LeastCommonAncestor();
        lca.lca(tree.root, 25, 35);
    }
}