import java.util.HashMap;

public class MaxHeaps {
    public int[] heap;
    private int size;

    public MaxHeaps() {
    }

    public MaxHeaps(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();
        heap[size++] = value;
        bubbleUP();

    }

    private void bubbleUP() {
        var index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        var root = heap[0];
        heap[0] = heap[--size];
        heap[size] = 0;
        bubbleDown();

        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return heap[index] >= leftChild(index);
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

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index, int parentIndex) {
        var temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }

    public int[] heapify(int[] array) {
        var lastParentIndex = ((array.length / 2) - 1);
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
        return array;
    }

    private void heapify(int[] array, int index) {
        var largerIndex = index;
        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex]) {
            largerIndex = leftIndex;
        }
        var rightIndex = index * 2 + 2;

        if (rightIndex < array.length && array[rightIndex] > array[largerIndex]) {
            largerIndex = rightIndex;
        }
        if (index == largerIndex) {
            return;
        }
        swap2(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();
        return heap[0];
    }

    public int kthLargestValue(int k) {
        if (isKAValidInput(k))
            throw new IllegalStateException();
        if (k == 1)
            return max();

        remove();
        return kthLargestValue(--k);

    }

    private boolean isKAValidInput(int k) {
        return k < 1 || k > heap.length;
    }

    private void swap2(int[] array, int index, int largerIndex) {
        var temp = array[index];
        array[index] = array[largerIndex];
        array[largerIndex] = temp;
    }

    public boolean isMaxHeap() {
        if (isEmpty())
            return true;
        if (remove() < remove())
            return false;
        return remove() > remove() || isMaxHeap();

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }
            prevMap.put(nums[i], i);
        }
        return new int[0]; // Guranteed solution, no need for return

    }

    public boolean isPalindrome(int x) {
        double r = 0;
        int X = x;
        if (x < 0)
            return false;

        while (x != 0) {
            r *= 10;
            r += x % 10;
            x /= 10;
        }

        if (r >= Integer.MAX_VALUE || r <= Integer.MIN_VALUE)
            return false;

        return ((int) r == X) ? true : false;
    }

}