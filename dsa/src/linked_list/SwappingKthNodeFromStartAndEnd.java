package linked_list;

public class SwappingKthNodeFromStartAndEnd {

    private static int getSize(ListNode head) {
        ListNode tempHead = head;
        int len = 0;
        while (tempHead != null) {
            len++;
            tempHead = tempHead.next;
        }
        return len;
    }

    private static ListNode swapKthNodeFromStartAndEnd(ListNode head, int k) {
        int size = getSize(head);
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; first != null && i < k - 1; i++) {
            first = first.next;
        }
        for (int i = 0; i < size - k; i++) {
            second = second.next;
        }
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        return head;
    }

    // Two pointer approach
    private static ListNode swapKthNodeFromStartAndEndTwoPointer(ListNode head, int k) {
        ListNode current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
        ListNode left = current;
        ListNode right = head;
        while (current.next != null) {
            current = current.next;
            right = right.next;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = swapKthNodeFromStartAndEndTwoPointer(head, 1);
        newHead.display(newHead);
    }
}
