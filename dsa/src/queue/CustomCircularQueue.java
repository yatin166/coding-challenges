package queue;

public class CustomCircularQueue {

    protected int[] data;
    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    protected static final int DEFAULT_SIZE = 10;

    public CustomCircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomCircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }

        data[end] = item;
        end++;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }

        int remove = data[front];
        front++;
        front = front % data.length;
        size--;
        return remove;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
        }
        int index = front;
        do {
            System.out.print(data[index] + ", ");
            index++;
            index = index % data.length;
        } while (index != end);
        System.out.println();
    }

}
