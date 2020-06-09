public class Heaps {
    public int[] heap;
    private int size;

    public Heaps(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();
        heap[size++] = value;
        bubbleUP();

    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        var value = heap[0];
        heap[0] = heap[--size];
        heap[size] = 0;
        bubbleDown();

        return value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int largerChildIndex(int index) {
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        return heap[index] >= leftChild(index) && heap[index] >= rightChild(index);
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void bubbleUP() {
        var index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index, int parentIndex) {
        var temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }

}