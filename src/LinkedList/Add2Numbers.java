package LinkedList;

/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8

        342 + 465 = 807
        Make sure there are no trailing zeros in the output list
        So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.*/
public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1), curr = dummy;
        int carry = 0;
        while (A != null || B != null || carry > 0) {
            int temp = carry + ((A == null ? 0 : A.val) + (B == null ? 0 : B.val));
            carry = temp > 9 ? 1 : 0;
            curr.next = new ListNode(temp % 10);
            curr = curr.next;
            A = A == null ? A : A.next;
            B = B == null ? B : B.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        ListNode B = new ListNode(4);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(5);
        ListNode E = new ListNode(6);
        ListNode F = new ListNode(4);
        A.next = B;
        B.next = C;
        C.next = null;
        D.next = E;
        E.next = null;
        F.next = null;
        Add2Numbers a = new Add2Numbers();
        a.addTwoNumbers(A, D);
    }
}
