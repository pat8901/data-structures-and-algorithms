package Data_Structures;

public class MinHeap {
    private int[] data;
    public int length;
    private int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.data = new int[capacity];
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

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }

        int parent = parent(index);
        int parent_value = data[parent];
        int value = data[index];

        if (parent_value > value) {
            data[index] = parent_value;
            data[parent] = value;
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        if (index >= length || leftIndex >= length) {
            return;
        }
        int left_value = data[leftIndex];
        int right_value = data[rightIndex];
        int our_value = data[index];

        if (left_value > right_value && our_value > right_value) {
            data[index] = right_value;
            data[rightIndex] = our_value;
            heapifyDown(rightIndex);
        }

        if (right_value > left_value && our_value > left_value) {
            data[index] = left_value;
            data[leftIndex] = our_value;
            heapifyDown(leftIndex);
        }
    }

    public void insert(int value) {
        data[length] = value;
        heapifyUp(length);
        length++;
    }

    public int delete() {
        if (length == 0) {
            return -1;
        }

        int value = data[0];
        length--;

        if (length == 0) {
            data = new int[capacity];
            return value;
        }

        data[0] = data[length];
        heapifyDown(0);
        return value;
    }

    public void peek() {

    }

    public void printHeap() {

    }

    public static void main(String args[]) {
        MinHeap heap = new MinHeap(10);

        heap.insert(20);
        heap.insert(7);
        heap.insert(3);
        heap.insert(90);
        heap.insert(1);
        heap.insert(256);
        System.out.println("Value: " + heap.delete());
    }
}
