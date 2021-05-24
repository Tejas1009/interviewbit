package Tree;

import java.util.ArrayList;

/*
Problem Description

        Given a Binary Tree A containing N nodes.

        You need to find the path from Root to a given node B.

        NOTE:

        No two nodes in the tree have same data values.
        You can assume that B is present in the tree A and a path always exists.


        Problem Constraints
        1 <= N <= 105

        1 <= Data Values of Each Node <= N

        1 <= B <= N



        Input Format
        First Argument represents pointer to the root of binary tree A.

        Second Argument is an integer B denoting the node number.



        Output Format
        Return an one-dimensional array denoting the path from Root to the node B in order.



        Example Input
        Input 1:

        A =

        1
        /   \
        2     3
        / \   / \
        4   5 6   7


        B = 5

        Input 2:

        A =
        1
        /   \
        2     3
        / \ .   \
        4   5 .   6


        B = 1




        Example Output
        Output 1:

        [1, 2, 5]
        Output 2:

        [1]


        Example Explanation
        Explanation 1:

        We need to find the path from root node to node with data value 5.
        So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
        Explanation 2:

        We need to find the path from root node to node with data value 1.
        As node with data value 1 is the root so there is only one node in the path.
        So we will return [1]


        Seen this question in a real interview beforeYes*/
public class PathToGivenNode {

    private boolean findPath(TreeNode node, int val, ArrayList<Integer> res) {
        if (node == null) return false;
        if (node.val == val) {
            res.add(node.val);
            return true;
        }
        res.add(node.val);
        boolean hasNode = findPath(node.left, val, res);
        if (!hasNode) hasNode = findPath(node.right, val, res);
        if (!hasNode) {
            res.remove(res.size() - 1);
        }
        return hasNode;
    }

    public ArrayList<Integer> solve(TreeNode node, int val) {
        ArrayList<Integer> res = new ArrayList<>();
        findPath(node, val, res);
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
        PathToGivenNode p = new PathToGivenNode();
        p.solve(tree.root, 40);
    }
}
