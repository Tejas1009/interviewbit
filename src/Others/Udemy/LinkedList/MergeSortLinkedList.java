package Others.Udemy.LinkedList;

public class MergeSortLinkedList {
    public static Node merge2LinkedList(Node<Integer> a, Node<Integer> b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            a.next = merge2LinkedList(a.next, b);
            return a;
        } else {
            b.next = merge2LinkedList(a, b.next);
            return b;
        }
    }

    public static Node<Integer> getMid(Node<Integer> head) {
        Node<Integer> slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node a = head;
        Node b = mid.next;
        mid.next = null;
        a = mergeSort(a);
        b = mergeSort(b);
        return merge2LinkedList(a, b);
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(4);
        ll1.insertAtHead(3);
        ll1.insertAtHead(1);
        ll1.insertAtHead(5);
        ll1.insertAtHead(2);
        Node r = mergeSort(ll1.head);
        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }
    }
}
