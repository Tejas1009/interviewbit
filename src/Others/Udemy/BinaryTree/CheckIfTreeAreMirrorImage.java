package Others.Udemy.BinaryTree;

public class CheckIfTreeAreMirrorImage {

    public static boolean isMirror(BinaryTreeNode a, BinaryTreeNode b) {
        if (a == null && b == null) return true;
        if ((a == null && b != null) || b == null && a != null) return false;
        if (a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
