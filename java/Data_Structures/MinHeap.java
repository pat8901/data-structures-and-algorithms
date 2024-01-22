package Data_Structures;

public class MinHeap {
    private int[] data;
    public int length;
    private int capacity;

    MinHeap(int size) {
        capacity = size;
        length = 0;
        data = new int[capacity];
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

    }

    public boolean insert() {
        return false;
    }

    public boolean delete() {
        return false;
    }

    public void peek() {

    }
}
