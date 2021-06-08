package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    Queue<TreeNode> queue;
    ArrayList<Integer> res;

    public void getDiagonals(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        if (node.left != null) queue.add(node.left);
        getDiagonals(node.right, res);
        if (!queue.isEmpty()) getDiagonals(queue.poll(), res);
    }

    public ArrayList<Integer> solve(TreeNode a) {
        res = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            while (temp != null) {
                res.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                temp = temp.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalTraversal d = new DiagonalTraversal();
        BST tree = new BST();
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(10);
        tree.root.right.right = new TreeNode(5);
        tree.root.right.right.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(6);
        tree.root.left.right.left = new TreeNode(4);
        tree.root.left.right.right = new TreeNode(7);
        d.solve(tree.root);
    }
}
