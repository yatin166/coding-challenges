package linked_list;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void display(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.val + " -> ");
            tempNode = tempNode.next;
        }
    }

    public static ListNode getSampleLinkedListHeadWithCycle() {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node8 = new ListNode(8, node4);
        node7.next = node8;

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, node4)));
        return head;
    }
}
