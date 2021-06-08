package Tree;

import java.util.ArrayList;
import java.util.Collections;

/*
Recover Binary Search Tree
        Asked in:
        Microsoft
        Amazon
        Two elements of a binary search tree (BST) are swapped by mistake.
        Tell us the 2 values swapping which the tree will be restored.

        Note:
        A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
        Example :


        Input :
        1
        / \
        2   3

        Output :
        [1, 2]

        Explanation : Swapping 1 and 2 will change the BST to be
        2
        / \
        1   3
        which is a valid BST
*/

public class RecoverBinarySearchTree {
    TreeNode first, second, third;
    TreeNode prev;

    private void get(TreeNode node) {
        if (node == null) {
            return;
        }
        get(node.left);
        if (prev != null) {
            if (prev.val > node.val) {
                if (first == null) {
                    first = prev;
                }
                second = node;
            }
        }
        prev = node;
        get(node.right);
    }

    public ArrayList<Integer> recoverTree(TreeNode a) {
        ArrayList<Integer> res = new ArrayList<>();
        get(a);
        res.add(first.val);
        if (third == null) {
            res.add(second.val);
        } else {
            res.add(third.val);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        BST tree = new BST();
        /*tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);*/
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(7);
        tree.root.right.left = new TreeNode(14);
        tree.root.right.right = new TreeNode(17);
        r.recoverTree(tree.root);
    }
}