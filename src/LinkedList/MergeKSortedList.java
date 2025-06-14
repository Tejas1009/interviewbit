package LinkedList;

/**
 * 23. Merge k Sorted Lists
 * Hard
 * Topics
 * Companies
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedList {
    public static void main(String[] args) {

    }

    public static MergeTwoList.ListNode mergeKLists(MergeTwoList.ListNode[] lists) {
        if (lists.length <= 1) {
            return lists[0];
        }
        MergeTwoList.ListNode list1 = lists[0];
        MergeTwoList.ListNode list2 = lists[1];
        MergeTwoList.ListNode mergedList = mergeTwoLists(list1, list2);
        for (int i = 2; i < lists.length; i++) {
            mergedList = mergeTwoLists(lists[i], mergedList);
        }
        return mergedList;
    }

    private static MergeTwoList.ListNode mergeTwoLists(MergeTwoList.ListNode list1, MergeTwoList.ListNode list2) {
        MergeTwoList.ListNode dummy = new MergeTwoList.ListNode();
        MergeTwoList.ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        return dummy.next;
    }
}
