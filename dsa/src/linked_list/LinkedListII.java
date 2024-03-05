package linked_list;

import java.util.List;

public class LinkedListII {

    private static int getCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode tempNode = slow;
                int len = 0;
                do {
                    tempNode = tempNode.next;
                    len++;
                } while (tempNode != slow);
                return len;
            }
        }
        return 0;
    }

    // Fast and slow pointer method
    private static ListNode detectCycleNode(ListNode head) {
        int lengthOfCycle = getCycleLength(head);

        if (lengthOfCycle == 0) return null;
        ListNode first = head;
        ListNode second = head;

        while (lengthOfCycle > 0) {
            second = second.next;
            lengthOfCycle--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    // Optimal solution
    private static ListNode optimalSolution(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head, entry = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode cycleListHead = ListNode.getSampleLinkedListHeadWithCycle();
        ListNode output = detectCycleNode(cycleListHead);
        System.out.println(output.val);
    }
}
