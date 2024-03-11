package stack;

public class DynamicCustomStack<T> extends CustomStack<T> {

    public DynamicCustomStack() {
        super();
    }

    public DynamicCustomStack(int size) {
        super(size);
    }

    @Override
    public boolean push(T item) throws Exception {
        if (isFull()) {
            T[] newData = (T[]) new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        return super.push(item);
    }
}
