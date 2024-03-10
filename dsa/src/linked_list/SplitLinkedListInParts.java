package linked_list;

public class SplitLinkedListInParts {

    private static int getSize(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    private static ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        int remainder = size % k;
        int partSize = size / k;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode emptyNode = new ListNode();
            ListNode part = emptyNode;
            int j = 0;
            while (j < partSize) {
                part.next = head;
                head = head.next;
                part = part.next;
                j++;
            }

            if (remainder > 0) {
                part.next = head;
                head = head.next;
                part = part.next;
                remainder--;
            }

            part.next = null;

            result[i] = emptyNode.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSimpleList(3);
        ListNode[] parts = splitListToParts(head, 5);
        for (ListNode part: parts) {
            if (part != null) {
                part.display(part);
                System.out.println();
            } else {
                System.out.println("null");
            }
        }
    }
}
