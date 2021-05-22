package LinkedList;

/*Given a sorted linked list, delete all duplicates such that each element appear only once.

        For example,
        Given 1->1->2, return 1->2.
        Given 1->1->2->3->3, return 1->2->3.*/
public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return null;
        }
        ListNode curr = A.next, prev = A;
        while (curr != null) {
            if (curr.val == prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return A;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedList r = new RemoveDuplicateFromSortedList();
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(1);
        ListNode C = new ListNode(2);
        ListNode D = new ListNode(3);
        ListNode E = new ListNode(3);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = null;
        r.deleteDuplicates(A);
    }
}
