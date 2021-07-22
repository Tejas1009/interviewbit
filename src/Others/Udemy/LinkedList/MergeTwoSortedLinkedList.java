package Others.Udemy.LinkedList;

public class MergeTwoSortedLinkedList {

    public static Node merge(Node<Integer> a, Node<Integer> b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(4);
        ll1.insertAtHead(3);
        ll1.insertAtHead(1);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(5);
        ll2.insertAtHead(2);

        Node r = merge(ll1.head, ll2.head);
        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }
    }
}
