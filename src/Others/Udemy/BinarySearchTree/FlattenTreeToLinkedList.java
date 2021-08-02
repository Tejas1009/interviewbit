package Others.Udemy.BinarySearchTree;

public class FlattenTreeToLinkedList {

    public static class BSTLinkedList {
        BinarySearchTreeNode head;

        public BSTLinkedList(BinarySearchTreeNode head, BinarySearchTreeNode tail) {
            this.head = head;
            this.tail = tail;
        }

        BinarySearchTreeNode tail;
    }

    public static BSTLinkedList flatten(BinarySearchTreeNode root) {
        if (root == null) {
            return new BSTLinkedList(null, null);
        }
        BSTLinkedList l = null;
        //4 cases
        //case 1: if it is leaf node i.e left is null and right is null
        //in that case we mark head and tail as the same node
        if (root.left == null && root.right == null) {
            l = new BSTLinkedList(root, root);
        }
        //case 2: if there is right node but no left node
        //in that case we mark left->tail->right = root;
        //and as there is no left tree we return new head as root and new tail as right.tail
        else if (root.right != null && root.left == null) {
            BSTLinkedList rightLL = flatten(root.right);
            root.right = rightLL.head;
            l = new BSTLinkedList(root, rightLL.tail);
        }
        //case 3: if there is left node but no right node
        // in that case we mark left.tail.right = root;
        //and as there is no right tree we return new head as left.head and new tail as root
        else if (root.left != null && root.right == null) {
            BSTLinkedList leftLL = flatten(root.left);
            leftLL.tail.right = root;
            l = new BSTLinkedList(leftLL.head, root);
        }
        //case 4: if there is a left tree and there is also right tree
        //in that case we get left and right linked list through recursion
        //and we make left.tail.right = root and root.right = right.head
        //basically we link left and right LL with root node as in between node
        else {
            BSTLinkedList leftLL = flatten(root.left);
            BSTLinkedList rightLL = flatten(root.right);
            leftLL.tail.right = root;
            root.right = rightLL.head;
            l = new BSTLinkedList(leftLL.head, rightLL.tail);
        }
        return l;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        int arr[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : arr) {
            root = BinarySearchTreeNode.insert(root, i);
        }
        BSTLinkedList ll = flatten(root);
        BinarySearchTreeNode temp = ll.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.right;
        }
        System.out.println();
    }
}