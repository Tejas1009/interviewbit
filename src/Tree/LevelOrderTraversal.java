package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    Queue<TreeNode> que = new LinkedList<>();

    public void levelOrderTraversal(TreeNode node) {
        if (node == null) return;
        que.add(node);
        while (!que.isEmpty()) {
            int size = que.size(), i = 0;
            while (i++ < size) {
                node = que.poll();
                if (i == size) System.out.println(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }
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
        LevelOrderTraversal l = new LevelOrderTraversal();
        l.levelOrderTraversal(tree.root);
    }
}
