package Others.Udemy.LinkedList;

public class SearchInLinkedList {

    public static boolean isPresent(Node head, Integer key) {
        Node<Integer> temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>(1);
        node.next = new Node<>(2);
        node.next.next = new Node<>(5);
        node.next.next.next = new Node<>(10);
        System.out.println(isPresent(node, 10));
        System.out.println(isPresent(node, 4));
        System.out.println(isPresent(node, 2));
    }
}
