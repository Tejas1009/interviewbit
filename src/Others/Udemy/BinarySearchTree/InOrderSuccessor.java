package Others.Udemy.BinarySearchTree;

/*
Inorder Successor
Given a BST. Find the inorder successor of a given target node.
i.e find the next node in inorder traversal
 */
public class InOrderSuccessor {
    private static BinarySearchTreeNode successor = null;

    private static BinarySearchTreeNode findKeyNode(BinarySearchTreeNode node, int key) {
        if (node.data == key) {
            return node;
        }
        if (key < node.data) {
            successor = node;
            return findKeyNode(node.left, key);
        } else {
            return findKeyNode(node.right, key);
        }
    }

    public static BinarySearchTreeNode inOrderSuccessor(BinarySearchTreeNode root, int key) {
        BinarySearchTreeNode keyNode = findKeyNode(root, key);
        if (keyNode.right != null) {
            return getNextNode(keyNode.right);
        } else {
            return successor;
        }
    }

    private static BinarySearchTreeNode getNextNode(BinarySearchTreeNode node) {
        if (node.left == null) {
            return node;
        }
        return getNextNode(node.left);
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        int arr[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : arr) {
            root = BinarySearchTreeNode.insert(root, i);
        }
        System.out.println(inOrderSuccessor(root, 7).data);
        System.out.println(inOrderSuccessor(root, 10).data);
        System.out.println(inOrderSuccessor(root, 8).data);
        System.out.println(inOrderSuccessor(root, 3).data);
    }
}