package LinkedList;

/*
Problem Description

        Given a linked list A of length N and an integer B.

        You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.

        If no such element exists, then return -1.

        NOTE:

        Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.


        Problem Constraints
        1 <= N <= 105
        1<= Value in Each Link List Node <= 103
        1 <= B <= 105


        Input Format
        First argument is the head pointer of the linkedlist A.

        Second argument is an integer B.



        Output Format
        Return an integer denoting the value of the Bth from the middle towards the head of the linked list A. If no such element exists, then return -1.



        Example Input
        Input 1:

        A = 3 -> 4 -> 7 -> 5 -> 6 -> 1 6 -> 15 -> 61 -> 16
        B = 3
        Input 2:

        A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
        B = 2
        Input 3:

        A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
        B = 10


        Example Output
        Output 1:

        4
        Output 2:

        14
        Output 3:

        -1*/
public class KthNodeFromMiddle {
    public int solve(ListNode A, int m) {
        int res = -1, cnt = 1, middle = 1, r = 0;
        ListNode fast = A;
        while (fast.next != null) {
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            middle++;
        }
        fast = A;
        r = middle - m;
        while (cnt <= middle && cnt < r) {
            fast = fast.next;
            cnt++;
        }
        if (cnt == r) {
            res = fast.val;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(3);
        ListNode B = new ListNode(4);
        ListNode C = new ListNode(7);
        ListNode D = new ListNode(5);
        ListNode E = new ListNode(6);
        ListNode F = new ListNode(16);

        ListNode G = new ListNode(15);
        ListNode H = new ListNode(61);
        ListNode I = new ListNode(16);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = G;
        G.next = H;
        H.next = I;
        KthNodeFromMiddle k = new KthNodeFromMiddle();
        k.solve(A, 30);
    }
}