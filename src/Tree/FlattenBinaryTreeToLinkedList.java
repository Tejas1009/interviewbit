package Tree;

/*Flatten Binary Tree to Linked List
        Asked in:
        Adobe
        Amazon
        Microsoft
        Given a binary tree, flatten it to a linked list in-place.

        Example :
        Given


        1
        / \
        2   5
        / \   \
        3   4   6
        The flattened tree should look like:

        1
        \
        2
        \
        3
        \
        4
        \
        5
        \
        6
        Note that the left child of all nodes should be NULL.*/
public class FlattenBinaryTreeToLinkedList {

    private void create(TreeNode node) {
        if (node == null) return;
        if (node.right == null && node.left == null) return;
        if (node.left != null) {
            flatten(node.left);
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            TreeNode curr = node;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = temp;
            node = curr;
        }
        flatten(node.right);
    }

    public TreeNode flatten(TreeNode node) {
        create(node);
        return node;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
        f.flatten(tree.root);
    }
}