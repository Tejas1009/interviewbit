package Others.Udemy.LinkedList;

public class KthLastElement {

    public static int kthLastElement(Node<Integer> head, int k) {
        Node<Integer> curr = head, slow = head;
        int cnt = 0;
        while (curr != null) {
            if (cnt > k) {
                slow = slow.next;
            }
            cnt++;
            curr = curr.next;
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
        System.out.println(kthLastElement(ll.head, 2));
    }
}
