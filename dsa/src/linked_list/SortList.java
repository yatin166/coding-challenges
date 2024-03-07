package linked_list;

public class SortList {

    private static ListNode getMid(ListNode head) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        return slow;
    }

    private static ListNode sortList(ListNode unsortedHead) {
        if (unsortedHead == null || unsortedHead.next == null) {
            return unsortedHead;
        }

        ListNode mid = getMid(unsortedHead);
        ListNode leftListHead = sortList(unsortedHead);
        ListNode rightListHead = sortList(mid);
        return mergedListHead(leftListHead, rightListHead);
    }

    private static ListNode mergedListHead(ListNode leftListHead, ListNode rightListHead) {
        ListNode emptyHead = new ListNode();
        ListNode node = emptyHead;

        while (leftListHead != null && rightListHead != null) {
            if (leftListHead.val < rightListHead.val) {
                node.next = leftListHead;
                leftListHead = leftListHead.next;
                node = node.next;
            } else {
                node.next = rightListHead;
                rightListHead = rightListHead.next;
                node = node.next;
            }
        }

        if (leftListHead != null) {
            node.next = leftListHead;
        }

        if (rightListHead != null) {
            node.next = rightListHead;
        }

        return emptyHead.next;
    }

    public static void main(String[] args) {
        ListNode unsortedHead = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode sortedHead = sortList(unsortedHead);
        sortedHead.display(sortedHead);
    }
}
