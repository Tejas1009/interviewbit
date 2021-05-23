package Tree;

import java.util.ArrayList;

public class RightViewOfBinaryTree {

    private int print(TreeNode node, int curr_level, int last_level, ArrayList<Integer> res) {
        if (node == null) return last_level;
        if (curr_level > last_level) {
            res.add(node.val);
            last_level = curr_level;
        }
        last_level = print(node.right, curr_level + 1, last_level, res);
        last_level = print(node.left, curr_level + 1, last_level, res);
        return last_level;
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        print(A, 1, 0, res);
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
        RightViewOfBinaryTree r = new RightViewOfBinaryTree();
        r.solve(tree.root);
    }
}
