package Graph;

import Tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode head;

    public TreeNode construct(int n) {
        if (n <= 0) return null;
        TreeNode left = construct(n / 2);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        TreeNode right = construct(n - n / 2 - 1);
        root.right = right;
        return root;
    }

    public TreeNode sortedListToBST(ListNode a) {
        int n = 0;
        ListNode curr = a;
        head = a;
        while (curr != null) {
            n += 1;
            curr = curr.next;
        }
        TreeNode node = construct(n);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        c.sortedListToBST(first);
    }
}