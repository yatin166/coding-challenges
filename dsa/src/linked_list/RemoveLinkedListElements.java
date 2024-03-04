package linked_list;

import java.util.ArrayList;
import java.util.List;

public class RemoveLinkedListElements {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() { }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private void printNodes(ListNode node) {
        ListNode tempNode = node;
        while (tempNode != null) {
            System.out.print(tempNode.val + " -> ");
            tempNode = tempNode.next;
        }
    }

    private ListNode insertNodes(int[] arr) {
        List<ListNode> list = new ArrayList<>();
        for (int num: arr) {
            ListNode node = new ListNode(num);
            if (list.size() > 0) {
                list.get(list.size() - 1).next = node;
            }
            list.add(node);
        }
        return list.get(0);
    }

    private ListNode deleteNodeWithValue(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head.val == val ? head.next : head;
    }

    private ListNode removeElementsWithRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsWithRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,6,3,4,5,6 };
        RemoveLinkedListElements obj = new RemoveLinkedListElements();
        ListNode head = obj.insertNodes(arr);
        System.out.println("BEFORE:");
        obj.printNodes(head);

        //head = obj.deleteNodeWithValue(head, 1);
        head = obj.removeElementsWithRecursion(head, 6);
        System.out.println("AFTER:");
        obj.printNodes(head);
    }

}
