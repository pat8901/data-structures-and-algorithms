package Heap;

public class MinHeap {
    private int[] heap;
    public int length;
    private int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    public void insert(int value) {
        if (this.length == this.capacity) {
            return;
        }
        heap[length] = value;
        heapifyUp(length);
        length++;
    }

    public int delete() {
        if (length == 0) {
            return -1;
        }

        int value = heap[0];
        heap[0] = heap[length - 1];
        length--;

        if (length == 0) {
            heap = new int[capacity];
            return value;
        }

        heapifyDown(0);
        return value;
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }

        int parent = parent(index);
        int parent_value = heap[parent];
        int value = heap[index];

        if (parent_value > value) {
            heap[index] = parent_value;
            heap[parent] = value;
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        if (index >= length || leftIndex >= length) {
            return;
        }
        int left_value = heap[leftIndex];
        int right_value = heap[rightIndex];
        int our_value = heap[index];

        if (left_value > right_value && our_value > right_value) {
            heap[index] = right_value;
            heap[rightIndex] = our_value;
            heapifyDown(rightIndex);
        }

        if (right_value > left_value && our_value > left_value) {
            heap[index] = left_value;
            heap[leftIndex] = our_value;
            heapifyDown(leftIndex);
        }
    }

    public void peek() {
        System.out.println("Minimum: " + heap[0]);
    }

    public void printHeap() {
        for (int i = 0; i < heap.length - 1; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println(heap[heap.length - 1]);
        System.out.println("Pointer:" + length);
    }

    public static void main(String args[]) {
        MinHeap min_heap = new MinHeap(10);

        min_heap.insert(1);
        min_heap.insert(3);
        min_heap.insert(4);
        min_heap.insert(7);
        min_heap.insert(8);
        min_heap.insert(14);
        min_heap.printHeap();

        min_heap.delete();
        min_heap.printHeap();

        min_heap.insert(99);
        min_heap.printHeap();
        min_heap.peek();
        min_heap.delete();
        min_heap.printHeap();
        min_heap.peek();
    }
}
