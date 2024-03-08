package linked_list;

public class ReverseNodesInKGroup {

    private static ListNode reverseFromAndTo(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode present = head;
        for (int i = 0; present != null && i < left - 1; i++) {
            prev = present;
            present = present.next;
        }

        ListNode last = prev;
        ListNode newEnd = present;
        ListNode next = present != null ? present.next : null;
        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        if (newEnd != null) {
            newEnd.next = present;
        }

        return prev;
    }

    private static ListNode reverseInKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;

        int size = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.next;
        }
        int count = size / k;

        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = present;
            ListNode next = present != null ? present.next : null;

            for (int i = 0; present != null && i < k; i++) {
                present.next = prev;
                prev = present;
                present = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            if (newEnd != null) {
                newEnd.next = present;
            }

            prev = newEnd;

            count--;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = reverseInKGroup(head, 3);
        newHead.display(newHead);
    }
}
