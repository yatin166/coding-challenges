package linked_list;

public class ReorderList {

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next = head == null ? null : head.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    private static ListNode reorderList(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null) {
            tempNode.next = reverseList(tempNode.next);
            tempNode = tempNode.next;
        }
        return head;
    }


    // Optmized solution
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reorderListOptimized(ListNode head) {
        ListNode mid = findMid(head);

        ListNode firstHead = head;
        ListNode secondHead = reverseList(mid);

        while (firstHead != null && secondHead != null) {
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        if (firstHead != null) {
           firstHead.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode newHead = reorderListOptimized(head);
        newHead.display(newHead);
    }
}
