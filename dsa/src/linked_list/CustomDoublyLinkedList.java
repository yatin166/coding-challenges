package linked_list;

public class CustomDoublyLinkedList {

    Node head;
    Node tail;
    int size;

    public CustomDoublyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        node.prev = tail;
        tail = node;

        size += 1;
    }

    // If tail is not provided
    public void insertLastWithoutTail(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        Node node = new Node(val);
        lastNode.next = node;
        node.prev = lastNode;

        tail = node;
        size += 1;
    }

    public void insertAt(int index, int val) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLastWithoutTail(val);
            return;
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("Please provide correct index");
        }

        Node node = new Node(val);
        Node previousNode = getNodeByIndex(index - 1);
        node.next = previousNode.next;
        previousNode.next = node;
        node.prev = previousNode;
        if (node.next != null) {
            node.next.prev = node;
        }
        size += 1;
    }

    private Node getNodeByIndex(int index) {
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public void display() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.val + " -> ");
            tempNode = tempNode.next;
        }
    }

    public void displayReverse() {
        Node tempNode = tail;
        while (tempNode != null) {
            System.out.print(tempNode.val + " -> ");
            tempNode = tempNode.prev;
        }
    }

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
