package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {

    public int solve(TreeNode a) {
        int res = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            int size = queue.size(), i = 0, level_sum = 0;
            while (i < size) {
                TreeNode node = queue.poll();
                level_sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                i++;
            }
            if (res < level_sum) {
                res = level_sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumLevelSum m = new MaximumLevelSum();
        BST tree = new BST();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(2);
        tree.root.right.right = new TreeNode(6);
        System.out.println(m.solve(tree.root));
    }
}
