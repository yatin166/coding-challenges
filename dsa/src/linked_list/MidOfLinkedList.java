package linked_list;

// 876. https://leetcode.com/problems/middle-of-the-linked-list/description/
// Fast and slow pointer
public class MidOfLinkedList {

    private static ListNode midOfLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode mid = midOfLinkedList(head);
        System.out.println(mid.val);
    }
}
