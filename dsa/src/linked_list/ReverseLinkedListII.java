package linked_list;

public class ReverseLinkedListII {

    private static ListNode reversePart(ListNode head, int left, int right) {
        // Move prev and present until left
        ListNode prev = null;
        ListNode present = head;
        for (int i = 0; present != null && i < left - 1; i++) {
            prev = present;
            present = present.next;
        }

        // Initialise last (to change at the end), newEnd (to track at the end), next
        ListNode last = prev;
        ListNode newEnd = present;
        ListNode next = present != null ? present.next : null;

        // Reverse list until right - left + 1 times
        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        // Check if last is not null then last.next = prev, else prev is head now
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        // Make the newEnd.next = present
        newEnd.next = present;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = reversePart(head, 2, 4);
        newHead.display(newHead);
    }
}
