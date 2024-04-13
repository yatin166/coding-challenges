package heap.implementation;

public class CustomHeapImplementation {

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(3);
        heap.insert(4);
        heap.insert(6);
        heap.insert(7);
        heap.insert(2);
        heap.insert(17);
        heap.insert(1);
        heap.remove();
        System.out.println(heap.heapSort());
    }
}
