package linked_list;

public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            this.insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insertAtIndex(int index, int val) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("Please provide correct index");
        }

        Node tempNode = head;

        for (int i = 1; i < index; i++) {
            tempNode = tempNode.next;
        }

        Node newNode = new Node(val, tempNode.next);
        tempNode.next = newNode;
    }

    // Insert using recursion
    public void insertAtIndexUsingRecursion(int index, int val) {
        head = recursiveInsertion(index, val, head);
    }

    private Node recursiveInsertion(int index, int val, Node currentNode) {
        if (index == 0) {
            Node newNode = new Node(val, currentNode);
            size += 1;
            return newNode;
        }

        currentNode.next = recursiveInsertion(index - 1, val, currentNode.next);
        return currentNode;
    }

    public int deleteFirst() {
        int currentSize = size;
        if (head == null) {
            return -1;
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size -= 1;
        System.out.println("Previous size: " + currentSize + " Current size: " + size);
        return size;
    }

    public void deleteLast() {
        if (size <= 1) {
            deleteFirst();
            return;
        }

        Node secondLastNode = getNodeByIndex(size - 2);
        secondLastNode.next = null;
        size -= 1;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == size - 1) {
            deleteLast();
            return;
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("Please provide correct index");
        }

        Node beforeGivenIndexNode = getNodeByIndex(index - 1);
        beforeGivenIndexNode.next = beforeGivenIndexNode.next.next;
        size -= 1;
    }

    public Node find(int val) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.val == val) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    public Node getNodeByIndex(int index) {
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

    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
