package linked_list;

// 206. https://leetcode.com/problems/reverse-linked-list/description/
public class ReverseLinkedList {

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present != null ? present.next : null;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        head.display(head);
        System.out.println();
        ListNode reversedHead = reverse(head);
        reversedHead.display(reversedHead);
    }
}
