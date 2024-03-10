package linked_list;

public class OddEvenLinkedList {

    private static ListNode oddEvenLinkedList(ListNode head) {
        ListNode first = head;
        ListNode second = head != null ? head.next : null;

        ListNode emptyNode1 = new ListNode();
        ListNode list1 = emptyNode1;
        ListNode emptyNode2 = new ListNode();
        ListNode list2 = emptyNode2;

        while (first != null && second != null) {
            list1.next = first;
            list2.next = second;
            if (first.next != null) {
                first = first.next.next;
            }
            if (second.next != null) {
                second = second.next.next;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        if (second == null) {
            list1.next = first;
            list1 = list1.next;
        }

        list1.next = null;
        list2.next = null;
        list1.next = emptyNode2.next;

        return emptyNode1.next;
    }

    // Optimal
    private static ListNode oddEvenJoin(ListNode head) {
       if (head == null) {
           return head;
       }

       ListNode odd = head;
       ListNode even = head.next;
       ListNode evenHead = even;

       while (even != null && even.next != null) {
           odd.next = odd.next.next;
           even.next = even.next.next;

           odd = odd.next;
           even = even.next;
       }
       odd.next = evenHead;

       return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSimpleList(15);
        ListNode oddEvenHead = oddEvenJoin(head);
        oddEvenHead.display(oddEvenHead);
    }
}
