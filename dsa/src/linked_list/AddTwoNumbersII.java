package linked_list;

public class AddTwoNumbersII {

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

    private static ListNode addTwoNumbersII(ListNode head1, ListNode head2) {
        ListNode numOneHead = reverse(head1);
        ListNode numTwoHead = reverse(head2);
        int currentAns = 0;
        ListNode emptyNode = new ListNode();
        ListNode tempNode = emptyNode;
        while (numOneHead != null || numTwoHead != null) {
            currentAns += ( numOneHead != null ? numOneHead.val : 0 ) + ( numTwoHead != null ? numTwoHead.val : 0 );
            ListNode newNode = new ListNode(currentAns % 10);
            currentAns = currentAns / 10;

            tempNode.next = newNode;
            tempNode = tempNode.next;

            numOneHead = numOneHead != null ? numOneHead.next : null;
            numTwoHead = numTwoHead != null ? numTwoHead.next : null;
        }

        if (currentAns > 0) {
            tempNode.next = new ListNode(currentAns);
        }

        return emptyNode.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(5);
        ListNode sum = reverse(addTwoNumbersII(head1, head2));
        sum.display(sum);
    }
}
