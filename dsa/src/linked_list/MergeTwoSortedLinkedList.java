package linked_list;

public class MergeTwoSortedLinkedList {

    private static ListNode mergedList(ListNode head1, ListNode head2) {
        ListNode emptyHead = new ListNode(1);
        ListNode node = emptyHead;
        while (head1 != null && head2 != null) {
            if (head2.val < head1.val) {
                node.next = head2;
                head2 = head2.next;
            } else {
                node.next = head1;
                head1 = head1.next;
            }
            node = node.next;
        }

        if (head1 == null) {
            node.next = head2;
        }

        if (head2 == null) {
            node.next = head1;
        }

        return emptyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4))))));
        ListNode mergedNodeHead = mergedList(head1, head2);
        mergedNodeHead.display(mergedNodeHead);
    }
}
