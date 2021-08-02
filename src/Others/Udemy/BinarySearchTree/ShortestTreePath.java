package Others.Udemy.BinarySearchTree;

/*
Shortest Tree Path
Given a binary tree and values of two nodes that lie inside the tree, find the Shortest
Path length between the two nodes.
 */
public class ShortestTreePath {

    private static BinarySearchTreeNode lca(BinarySearchTreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) return root;
        BinarySearchTreeNode l_node = lca(root.left, a, b);
        BinarySearchTreeNode r_node = lca(root.right, a, b);
        if (l_node != null & r_node != null) return root;
        if (l_node == null && r_node != null) return r_node;
        return l_node;
    }

    private static int getDistance(BinarySearchTreeNode root, int key, int dsf) {
        if (root.data == key) return dsf;
        if (key < root.data) {
            return getDistance(root.left, key, dsf + 1);
        } else {
            return getDistance(root.right, key, 1 + dsf);
        }
    }

    public static int shortestDist(BinarySearchTreeNode root, int a, int b) {
        BinarySearchTreeNode lca = lca(root, a, b);
        int d1 = getDistance(lca, a, 0);
        int d2 = getDistance(lca, b, 0);
        return d1 + d2;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        int arr[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : arr) {
            root = BinarySearchTreeNode.insert(root, i);
        }
        System.out.println(shortestDist(root, 3, 10));
        System.out.println(shortestDist(root, 1, 13));
        System.out.println(shortestDist(root, 7, 14));
    }
}
