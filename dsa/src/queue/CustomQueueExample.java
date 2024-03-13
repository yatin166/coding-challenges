package queue;

public class CustomQueueExample {

    public static void main(String[] args) {
        /*CustomQueue customQueue = new CustomQueue();
        customQueue.insertAtBack(3);
        customQueue.insertAtBack(5);
        customQueue.insertAtBack(8);
        customQueue.display();
        customQueue.deleteAtFront();
        customQueue.display();*/

        CustomCircularQueue customCircularQueue = new CustomCircularQueue();
        customCircularQueue.insert(3);
        customCircularQueue.insert(2);
        customCircularQueue.insert(9);
        customCircularQueue.display();
        customCircularQueue.remove();
        customCircularQueue.display();
    }
}
