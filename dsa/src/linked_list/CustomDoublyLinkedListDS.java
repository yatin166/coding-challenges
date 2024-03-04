package linked_list;

public class CustomDoublyLinkedListDS {

    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertFirst(6);
        list.insertFirst(8);
        list.insertLast(3);
        list.insertLastWithoutTail(23);
        list.insertAt(0, 44);
        list.display();
        System.out.println();
        list.displayReverse();
    }
}
