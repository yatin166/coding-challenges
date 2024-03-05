package linked_list;

// 82 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromLinkedListII {

    private static ListNode removeDuplicates(ListNode head) {
        ListNode emptyNode = new ListNode();
        ListNode node = emptyNode;

        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                node.next = head;
                head = head.next;
                node = node.next;
                node.next = null;
            } else {
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }
                head = head.next;
            }
        }

        return emptyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode newHead = removeDuplicates(head);
        newHead.display(newHead);
    }
}
