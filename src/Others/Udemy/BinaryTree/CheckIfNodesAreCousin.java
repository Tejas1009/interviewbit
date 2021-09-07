package Others.Udemy.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
Check if two nodes are cousins in a Binary Tree
Given a binary tree and the two nodes say ‘a’ and ‘b’, determine whether two given nodes are cousins of each other or not.
Two nodes are cousins of each other if they are at same level and have different parents.
Example:

     6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.
 */
public class CheckIfNodesAreCousin {

    static class Pair {
        BinaryTreeNode curr;
        BinaryTreeNode parent;

        public Pair(BinaryTreeNode curr, BinaryTreeNode parent) {
            this.curr = curr;
            this.parent = parent;
        }
    }

    public static boolean isCousin(BinaryTreeNode node, BinaryTreeNode a, BinaryTreeNode b) {
        Queue<Pair> queue = new LinkedList<>();
        BinaryTreeNode temp = new BinaryTreeNode(-1);
        queue.add(new Pair(node, temp));
        BinaryTreeNode parentA = null, parentB = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair currNode = queue.poll();
                if (currNode.curr == a) {
                    parentA = currNode.parent;
                }
                if (currNode.curr == b) {
                    parentB = currNode.parent;
                }
                if (currNode.curr.left != null) {
                    queue.add(new Pair(currNode.curr.left, currNode.curr));
                }
                if (currNode.curr.right != null) {
                    queue.add(new Pair(currNode.curr.right, currNode.curr));
                }
                if (parentA != null && parentB != null) {
                    break;
                }
            }
            if (parentA != null && parentB != null) {
                return parentA != parentB;
            }
            if ((parentA != null && parentB == null) || (parentA == null && parentB != null)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
