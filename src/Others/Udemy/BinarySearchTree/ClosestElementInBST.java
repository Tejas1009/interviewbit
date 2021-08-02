package Others.Udemy.BinarySearchTree;

public class ClosestElementInBST {

    public static int findClosest(BinarySearchTreeNode node, int key) {
        int res = Integer.MIN_VALUE;
        BinarySearchTreeNode temp = node;
        while (temp != null) {
            if (temp.data == key) {
                return temp.data;
            }
            if (temp.data < key) {
                res = Math.max(res, temp.data);
                temp = temp.right;
            } else {
                res = Math.max(res, temp.data);
                temp = temp.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        int arr[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : arr) {
            root = BinarySearchTreeNode.insert(root, i);
        }
        System.out.println(findClosest(root, 10));
        System.out.println("--------------------------");
        System.out.println(findClosest(root, 99));
    }
}
