package queue;

public class CustomQueue {

    protected int[] data;
    protected static final int DEFAULT_SIZE = 10;
    protected int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == this.data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insertAtBack(int item) {
        if (isFull()) {
            return false;
        }

        this.data[end] = item;
        end++;
        return true;
    }

    public int deleteAtFront() {
        if (isEmpty()) {
            return -1;
        }

        int front = this.data[0];

        for (int i = 1; i < end; i++) {
            this.data[i - 1] = this.data[i];
        }
        end--;

        return front;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
            return;
        }

        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }
}
