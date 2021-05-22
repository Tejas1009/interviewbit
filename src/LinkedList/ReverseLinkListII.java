package LinkedList;

/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

        For example:
        Given 1->2->3->4->5->NULL, m = 2 and n = 4,

        return 1->4->3->2->5->NULL.

        Note:
        Given m, n satisfy the following condition:
        1 ≤ m ≤ n ≤ length of list. Note 2:
        Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.*/
public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode A, int m, int n) {
        if (n <= 1) {
            return A;
        }
        ListNode head = null, tail = null, rev_tail = null, prev = null, curr = A, next = null;
        for (int i = 1; i <= n; i++) {
            if (i == m) {
                rev_tail = curr;
            }
            if (i == m - 1) {
                head = curr;
            }
            if (i == n) {
                tail = curr.next;
            }
            curr = curr.next;
        }
        curr = rev_tail;
        int reverse = n - m;
        while (reverse >= 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            reverse--;
        }
        if (head != null) head.next = prev;
        rev_tail.next = tail;
        //return A;
        ListNode n1 = head == null ? prev : A;
        return n1;
    }

    public static void main(String[] args) {
        ReverseLinkListII r = new ReverseLinkListII();
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        /*ListNode E = new ListNode(5);*/
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = null;
/*        C.next = D;
        D.next = E;*/
        r.reverseBetween(A, 2, 3);
    }
}
