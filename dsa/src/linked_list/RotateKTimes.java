package linked_list;

public class RotateKTimes {

    private static ListNode rotate(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode lastNode = head;
        int length = 1;
        while (lastNode.next != null) {
            length++;
            lastNode = lastNode.next;
        }

        lastNode.next = head;
        k = k % length;

        // Skip nodes until len - k - 1 times
        ListNode newLast = head;
        for (int i = 0; i < (length - k) - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = rotate(head, 2);
        newHead.display(newHead);
    }
}
