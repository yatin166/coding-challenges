package linked_list;

public class RemoveNthNodeFromEnd {

    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) {
            return head;
        }

        ListNode last = head;
        int len = 0;
        while (last != null) {
            len++;
            last = last.next;
        }

        int newLastIndex = len - n;
        if (newLastIndex == 0) {
            return head.next;
        }

        ListNode tempNode = head;
        for (int i = 0; i < newLastIndex - 1; i++) {
            tempNode = tempNode.next;
        }

        tempNode.next = tempNode.next != null ? tempNode.next.next : null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = removeNthNodeFromEnd(head, 1);
        newHead.display(newHead);
    }
}
