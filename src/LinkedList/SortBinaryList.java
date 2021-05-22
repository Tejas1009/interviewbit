package LinkedList;

public class SortBinaryList {
    public ListNode solve(ListNode A) {
        ListNode zero = new ListNode(0), one = new ListNode(1);
        ListNode head1 = zero, head2 = one;
        while (A != null) {
            if (A.val == 0) {
                zero.next = A;
                zero = zero.next;
                //zero.next = null;
            } else {
                one.next = A;
                one = one.next;
                //one.next = null;
            }
            A = A.next;
        }
        zero.next = head2.next;
        return head1.next;
    }

    public static void main(String[] args) {
        SortBinaryList s = new SortBinaryList();
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(0);
        ListNode C = new ListNode(0);
        ListNode D = new ListNode(1);
        A.next = B;
        B.next = C;
        C.next = D;
        s.solve(A);
    }
}
