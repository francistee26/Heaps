public class MinHeap {
    private class Node {
        private int key;
        private String str;

        public Node(int key, String str) {
            this.key = key;
            this.str = str;
        }

        @Override
        public String toString() {
            return "key: " + key + "Str: " + str;
        }

    }

    private Node[] array;
    private int size;

    public MinHeap(int capacity) {
        this.array = new Node[capacity];
    }

    public void insert(int key, String str) {
        if (isFull())
            throw new IllegalStateException();
        array[size++] = new Node(key, str);
        bubbleUp();
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && array[index].key < array[parent(index)].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public String remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = array[0].str;
        array[0] = array[--size];

        bubbleDown();

        return root;
    }

    private void bubbleDown() {
        var index = size - 1;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = smallerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private void swap(int index, int largerChildIndex) {
        var temp = array[largerChildIndex];
        array[largerChildIndex] = array[index];
        array[index] = temp;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = array[index].key <= leftChild(index).key;

        if (hasRightChild(index))
            isValid &= array[index].key <= rightChild(index).key;

        return isValid;
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index).key > rightChild(index).key ? leftChildIndex(index) : rightChildIndex(index);
    }

    private Node leftChild(int index) {
        return array[leftChildIndex(index)];
    }

    private Node rightChild(int index) {
        return array[rightChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}