package LinkedList;

public class DeleteMiddleNodeLinkedList {
    public static void main(String[] args) {
        MergeTwoList.ListNode first = new MergeTwoList.ListNode(1);
        first.next = new MergeTwoList.ListNode(3);
        first.next.next = new MergeTwoList.ListNode(4);
        first.next.next.next = new MergeTwoList.ListNode(7);
        first.next.next.next.next = new MergeTwoList.ListNode(1);
        first.next.next.next.next.next = new MergeTwoList.ListNode(2);
        first.next.next.next.next.next.next = new MergeTwoList.ListNode(6);
        System.out.println(deleteMiddle(first));
    }

    public static MergeTwoList.ListNode deleteMiddle(MergeTwoList.ListNode head) {
        if (head.next == null) {
            return head;
        }
        MergeTwoList.ListNode slow = head;
        MergeTwoList.ListNode fast = head;
        MergeTwoList.ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
