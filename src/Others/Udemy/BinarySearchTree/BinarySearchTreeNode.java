package Others.Udemy.BinarySearchTree;

public class BinarySearchTreeNode {
    int data;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    public BinarySearchTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static BinarySearchTreeNode insert(BinarySearchTreeNode root, int key) {
        if (root == null) {
            return new BinarySearchTreeNode(key);
        }
        if (key <= root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void inOrderTraversal(BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + ", ");
        inOrderTraversal(node.right);
    }

    public static boolean search(BinarySearchTreeNode node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return search(node.left, key) || search(node.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        int arr[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : arr) {
            root = insert(root, i);
        }
        inOrderTraversal(root);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println(search(root, 14));
        System.out.println("-------------------------------");
        System.out.println(search(root, 99));
    }
}