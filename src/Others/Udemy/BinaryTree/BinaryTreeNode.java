package Others.Udemy.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Input: 1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1
    public static BinaryTreeNode buildTree() {
        int d;
        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        if (d == -1) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(d);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }

    public static void levelOrderTraversal(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size(), i = 0;
            while (i++ < size) {
                BinaryTreeNode curr_node = queue.poll();
                System.out.print(curr_node.data + " ");
                if (curr_node.left != null) queue.add(curr_node.left);
                if (curr_node.right != null) queue.add(curr_node.right);
            }
            System.out.println();
        }
    }

    public static int height(BinaryTreeNode node) {
        if (node == null) return 0;
        int l_height = 0, r_height = 0;
        if (node.left != null) l_height = height(node.left);
        if (node.right != null) r_height = height(node.right);
        return 1 + Math.max(l_height, r_height);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        levelOrderTraversal(root);
        System.out.println("-----------Height of Tree: ");
        System.out.print(height(root));
        System.out.println();
    }
}
