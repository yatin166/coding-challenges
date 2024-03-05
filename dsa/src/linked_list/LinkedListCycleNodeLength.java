package linked_list;

public class LinkedListCycleNodeLength {

    // fast and slow pointer method
    private static int getHowManyNodesAreInCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int nodesInCycle = 0;
                ListNode tempNode = slow;
                do {
                    tempNode = tempNode.next;
                    nodesInCycle++;
                } while (tempNode != slow);
                return nodesInCycle;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSampleLinkedListHeadWithCycle();
        System.out.println(getHowManyNodesAreInCycle(head));
    }
}
