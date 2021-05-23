package Tree;

import java.util.ArrayList;

/*Kth Smallest Element In Tree
        Asked in:
        Amazon
        Given a binary search tree, write a function to find the kth smallest element in the tree.

        Example :

        Input :
        2
        / \
        1   3

        and k = 2

        Return : 2

        As 2 is the second smallest element in the tree.
        NOTE : You may assume 1 <= k <= Total number of nodes in BST*/
public class KthSmallestElementInTree {

    private void inorder(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    public int kthsmallest(TreeNode node, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(node, res);
        return res.get(k - 1);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(35);
        tree.insert(25);
        tree.insert(40);
        tree.insert(75);
        tree.insert(65);
        tree.insert(85);
        KthSmallestElementInTree k = new KthSmallestElementInTree();
        System.out.println(k.kthsmallest(tree.root, 1));
    }
}