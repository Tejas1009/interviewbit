package Tree;

import java.util.ArrayList;

public class InOrderTraversal {
    private void traverse(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        traverse(node.left, res);
        res.add(node.val);
        traverse(node.right, res);
    }

    private void traversePre(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        traversePre(node.left, res);
        traversePre(node.right, res);
    }

    private void traversePost(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        traversePost(node.left, res);
        traversePost(node.right, res);
        res.add(node.val);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(A, res);
        return res;
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
        InOrderTraversal i = new InOrderTraversal();
        i.inorderTraversal(tree.root);
    }
}
