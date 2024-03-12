package stack;

import java.util.Stack;

public class ImplementQueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        for (int i = 0; i < first.size(); i++) {
            second.push(first.pop());
        }

        int element = second.pop();

        for (int i = 0; i < second.size(); i++) {
            first.push(second.pop());
        }

        return element;
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.empty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack obj = new ImplementQueueUsingStack();
        obj.push(1);
        System.out.println(obj.peek());
        obj.push(2);
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.empty());
    }
}
