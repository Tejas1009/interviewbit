package Others.Udemy.LinkedList;

public class DetectCycleInLinkedList {
    public static boolean containsCycle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow.data == fast.data) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        System.out.println(containsCycle(ll.head));
        ll.createCycle();
        System.out.println(containsCycle(ll.head));
    }
}
