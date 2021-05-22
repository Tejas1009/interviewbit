package LinkedList;

public class KthReverseList {
    /*    Given a singly linked list and an integer K, reverses the nodes of the

        list K at a time and returns modified linked list.

        NOTE : The length of the list is divisible by K
        Example :

        Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

        You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

        Try to solve the problem using constant extra space.*/
    public ListNode reverseList(ListNode head, int m) {
        ListNode curr = head, next = null, prev = null;
        int cnt = 0;
        while (cnt < m && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        if (next != null) {
            head.next = reverseList(curr, m);
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        ListNode F = new ListNode(6);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = null;
        KthReverseList k = new KthReverseList();
        ListNode n = k.reverseList(A, 4);
    }
}
