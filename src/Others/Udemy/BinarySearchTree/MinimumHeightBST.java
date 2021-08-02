package Others.Udemy.BinarySearchTree;

/*
Given a sorted array list.
Build a BST with minimum height.
 */
public class MinimumHeightBST {

    public static BinarySearchTreeNode build(BinarySearchTreeNode node, int s, int e, int arr[]) {
        if (s > e) return null;
        int mid = (s + e) / 2;
        node = new BinarySearchTreeNode(arr[mid]);
        node.left = build(node.left, s, mid - 1, arr);
        node.right = build(node.right, mid + 1, e, arr);
        return node;
    }

    public static BinarySearchTreeNode sortedArrayToBST(int arr[], BinarySearchTreeNode root) {
        root = build(root, 0, arr.length - 1, arr);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        BinarySearchTreeNode root = null;
        root = sortedArrayToBST(arr, root);
        BinarySearchTreeNode.inOrderTraversal(root);
    }
}