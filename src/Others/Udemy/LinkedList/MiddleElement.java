package Others.Udemy.LinkedList;

public class MiddleElement {

    public static int getMid(Node<Integer> head) {
        Node<Integer> slow = head, fast = head.next.next;
        while (fast != null) {
            if (fast.next == null) {
                fast = null;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        System.out.println(getMid(ll.head));
    }
}
