package LinkedList;

/*
Sort List
Asked in:
Google
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
 */
public class SortList {
    public static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val <= b.val) {
            a.next = mergeList(a.next, b);
            return a;
        } else {
            b.next = mergeList(a, b.next);
            return b;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode a = head;
        ListNode b = mid.next;
        mid.next = null;
        a = sortList(a);
        b = sortList(b);
        return mergeList(a, b);
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode A = new ListNode(2);
        ListNode B = new ListNode(4);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(5);
        ListNode E = new ListNode(6);
        ListNode F = new ListNode(4);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        ListNode r = sl.sortList(A);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
