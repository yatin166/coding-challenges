package linked_list;

public class LinkedListCycle {

    private static boolean cycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node8 = new ListNode(8, node4);
        node7.next = node8;

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, node4)));
        System.out.println(cycle(head));
    }
}
