package linked_list;

public class RemoveMiddleOfLinkedList {

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode deleteMiddleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return null;
        }

        ListNode mid = getMid(head);
        ListNode tempNode = head;
        while (tempNode.next != mid) {
            tempNode = tempNode.next;
        }
        tempNode.next = mid.next;
        return head;
    }

    // optimal solution
    private static ListNode removeMiddleNode(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSimpleList(7);
        ListNode removedMid = removeMiddleNode(head);
        removedMid.display(removedMid);
    }
}
