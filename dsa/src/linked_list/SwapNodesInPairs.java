package linked_list;

public class SwapNodesInPairs {

    private static int getLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    private static ListNode swapNodesInPair(ListNode head) {
        int size = getLength(head);
        int counter = size / 2;
        ListNode prev = null;
        ListNode present = head;
        while (counter > 0) {
            ListNode last = prev;
            ListNode newEnd = present;
            ListNode next = present != null ? present.next : null;
            for (int i = 0; present != null && i < 2; i++) {
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
            counter--;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSimpleList(8);
        ListNode swappedNode = swapNodesInPair(head);
        swappedNode.display(swappedNode);
    }
}
