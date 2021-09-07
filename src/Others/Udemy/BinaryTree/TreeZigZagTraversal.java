package Others.Udemy.BinaryTree;

import java.util.Stack;

public class TreeZigZagTraversal {
    /*
    We cannot use queue as order is not maintained.
    So, we need to use 2 stack
        1. for current level - while iterating over current level we need to build next level stack
        2. for next level
     */

    public static void printZigZag(BinaryTreeNode node) {
        boolean leftToRight = true;
        Stack<BinaryTreeNode> currLevel = new Stack<>();
        currLevel.push(node);
        Stack<BinaryTreeNode> nextLevel = new Stack<>();
        while (!currLevel.isEmpty()) {
            BinaryTreeNode currNode = currLevel.pop();
            System.out.println(currNode.data);
            if (!leftToRight) {
                if (currNode.right != null) nextLevel.push(currNode.right);
                if (currNode.left != null) nextLevel.push(currNode.left);
            } else {
                if (currNode.left != null) nextLevel.push(currNode.left);
                if (currNode.right != null) nextLevel.push(currNode.right);
            }
            if (currLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<BinaryTreeNode> temp = currLevel;
                currLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(6);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(4);
        printZigZag(root);
    }
}
