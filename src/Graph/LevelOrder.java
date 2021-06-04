package Graph;

import Tree.BST;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Level Order
        Asked in:
        Facebook
        Groupon
        Goldman Sachs
        Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

        Example :
        Given binary tree

        3
        / \
        9  20
        /  \
        15   7
        return its level order traversal as:

        [
        [3],
        [9,20],
        [15,7]
        ]
        Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.*/
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size(), i = 0;
            ArrayList<Integer> l = new ArrayList<>();
            while (i++ < size) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(l);
        }
        return res;
    }

    public static void main(String[] args) {
        LevelOrder l = new LevelOrder();
        BST tree = new BST();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);
        l.levelOrder(tree.root);
    }
}
