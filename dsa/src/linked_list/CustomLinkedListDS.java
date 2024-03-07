package linked_list;

public class CustomLinkedListDS {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        /*linkedList.insertLast(16);
        linkedList.insertFirst(12);
        linkedList.insertAtIndex(2, 100);
        linkedList.deleteFirst();
        linkedList.insertFirst(14);
        linkedList.insertFirst(24);
        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.deleteAtIndex(0);*/
        linkedList.insertFirst(1);
        linkedList.insertAtIndex(1, 2);
        linkedList.insertAtIndex(2, 3);
        linkedList.insertAtIndex(3, 4);
        linkedList.insertAtIndexUsingRecursion(2, 100);

        linkedList.display();
    }
}
