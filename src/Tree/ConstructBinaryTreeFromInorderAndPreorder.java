package Tree;

public class ConstructBinaryTreeFromInorderAndPreorder {
    int preIdx = 0;

    private TreeNode create(int preOrder[], int inOrder[], int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preIdx++]);
        /*if (start == end) {
            return node;
        }*/
        int i = getIndexOfEle(node.val, inOrder);
        node.left = create(preOrder, inOrder, start, i - 1);
        node.right = create(preOrder, inOrder, i + 1, end);
        return node;
    }

    private int getIndexOfEle(int e, int list[]) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == e) return i;
        }
        return -1;
    }

    public TreeNode buildTree(int pre[], int inorder[]) {
        preIdx = 0;
        TreeNode n = create(pre, inorder, 0, pre.length - 1);
        return n;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPreorder c = new ConstructBinaryTreeFromInorderAndPreorder();
        int pre[] = {2, 4, 7, 3, 8};
        int in[] = {7, 4, 3, 2, 8};
        c.buildTree(pre, in);
    }
}
