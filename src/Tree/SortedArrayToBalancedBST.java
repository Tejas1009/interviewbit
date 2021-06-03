package Tree;

import java.util.HashSet;

public class SortedArrayToBalancedBST {

    private TreeNode create(int s, int e, int[] arr) {
        if (s > e) {
            return null;
        }
        int mid = (e + s) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = create(s, mid - 1, arr);
        node.right = create(mid + 1, e, arr);
        return node;
    }

    public TreeNode sortedArrayToBST(final int[] arr) {
        TreeNode n = create(0, arr.length - 1, arr);
        return n;
    }

    public static void main(String[] args) {
        SortedArrayToBalancedBST s = new SortedArrayToBalancedBST();
        int arr[] = {1, 2, 3, 5, 6, 7};
        s.sortedArrayToBST(arr);
    }

}
