package linked_list;

// 2. https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode emptyNode = new ListNode();
        ListNode tempNode = emptyNode;
        int currentAns = 0;
        while (head1 != null || head2 != null) {
            currentAns += ( head1 != null ? head1.val : 0 ) + ( head2 != null ? head2.val : 0 );

            tempNode.next = new ListNode(currentAns % 10);
            tempNode = tempNode.next;

            currentAns = currentAns / 10;

            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        if (currentAns > 0) {
            tempNode.next = new ListNode(currentAns);
        }
        return emptyNode.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode head2 = new ListNode(9, new ListNode(9, new ListNode(9)));

        ListNode sumHead = addTwoNumbers(head1, head2);
        sumHead.display(sumHead);
    }
}
