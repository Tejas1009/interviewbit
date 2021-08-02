package Others.Udemy.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeFromLevelOrderTraversal {

    public static BinaryTreeNode build(int nodes[]) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode root = new BinaryTreeNode(nodes[0]);
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode curr_node = queue.poll(), left_node = null, right_node = null;
            if ((i + 1) < nodes.length && nodes[i + 1] != -1) {
                left_node = new BinaryTreeNode(nodes[i + 1]);
                queue.add(left_node);
            }
            if ((i + 2) < nodes.length && nodes[i + 2] != -1) {
                right_node = new BinaryTreeNode(nodes[i + 2]);
                queue.add(right_node);
            }
            curr_node.left = left_node;
            curr_node.right = right_node;
            i = i + 2;
        }
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1};
        build(nodes);
    }
}