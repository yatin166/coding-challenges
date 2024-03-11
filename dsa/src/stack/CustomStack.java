package stack;

public class CustomStack<T> {

    protected T[] data;
    private static final int DEFAULT_SIZE = 10;
    private int pointer = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = (T[]) new Object[size];
    }

    public boolean push(T item) throws Exception {
        if (isFull()) {
            throw new Exception("Stack is full!");
        }

        pointer++;
        data[pointer] = item;
        return true;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }

        T item = data[pointer];
        pointer--;
        return item;
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }

        return data[pointer];
    }

    protected boolean isEmpty() {
        return pointer == -1;
    }

    protected boolean isFull() {
         return pointer == data.length - 1;
    }
}
