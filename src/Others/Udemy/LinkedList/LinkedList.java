package Others.Udemy.LinkedList;

public class LinkedList {
    public Node<Integer> head;

    public void insertAtHead(int key) {
        if (head == null) {
            head = new Node<>(key);
            return;
        }
        Node<Integer> temp = new Node<>(key);
        temp.next = head;
        head = temp;
    }

    public void createCycle() {
        //making last node next as head
        Node<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insert(int data, int pos) {
        if (pos == 1) {
            insertAtHead(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 2; i++) {
            temp = temp.next;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next = n;
    }

    public void reverse() {
        Node curr = head;
        Node next = null;
        Node prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node reverseKthNode(Node head, int k) {
        Node curr = head;
        Node next = null, prev = null;
        int cnt = 1;
        while (curr != null && cnt <= k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        if (next != null) {
            head.next = reverseKthNode(curr, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.insertAtHead(0);
        ll.printLL();
        System.out.println("----------------------");
        ll.insert(100, 5);
        ll.printLL();
        System.out.println("----------------------");
        ll.reverse();
        ll.printLL();
        System.out.println("-------Kth Reverse----------");
        ll.head = ll.reverseKthNode(ll.head, 2);
        ll.printLL();
    }
}
