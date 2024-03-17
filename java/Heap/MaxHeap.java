package Heap;
//https://www.geeksforgeeks.org/max-heap-in-java/

// what is a complete binary tree
// what is a full binary tree
// what is a balanced binary tree
// how to represent a tree via an array, linked-list?

// what is he heap used for?
// Answer: 
// Heap is used while implementing a priority queue.
// Dijkstra's Algorithm
// Heap Sort

// dont use built in classes. do it from scratch

// Max-Heap data structure in Java
class MaxHeap {
    private int size;
    private int maxSize;
    private int heap[];

    // Default object constructor
    MaxHeap(int capacity) {
        size = 0;
        maxSize = capacity;
        heap = new int[maxSize];
    }

    // Return index of parent
    public int parent(int index) {
        return (index - 1) / 2;
    }

    // Return index of parent
    public int left(int index) {
        return (index * 2) + 1;
    }

    // Return index of parent
    public int right(int index) {
        return (index * 2) + 2;
    }

    public boolean isLeaf(int index) {
        if (index > (size / 2) && index <= size) {
            return true;
        }
        return false;
    }

    public void swap(int index, int swapIndex) {
        int temp = heap[index];
        heap[index] = heap[swapIndex];
        heap[swapIndex] = temp;

    }

    private void heapifyDown(int index) {
        if (isLeaf(index))
            return;
        if (heap[index] < heap[left(index)] || heap[index] < heap[right(index)]) {
            if (heap[left(index)] > heap[right(index)]) {
                swap(index, left(index));
                heapifyDown(left(index));
            } else {
                swap(index, right(index));
                heapifyDown(right(index));
            }
        }

    }

    // uses heapifyUp concept
    public void insertNode(int element) {
        heap[size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return popped;
    }

    // this is a bad print function
    public void printHeap() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + heap[i] + " ");
            if (left(i) < size) {
                System.out.print("left: " + heap[left(i)] + " ");
            }
            if (right(i) < size) {
                System.out.print("Right: " + heap[right(i)] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        MaxHeap heap = new MaxHeap(15);
        heap.printHeap();
        heap.insertNode(5);
        heap.insertNode(3);
        heap.insertNode(17);
        heap.insertNode(10);
        heap.insertNode(84);
        heap.insertNode(19);
        heap.insertNode(6);
        heap.insertNode(22);
        heap.insertNode(9);
        heap.printHeap();

        System.out.println("Max value: " + heap.extractMax());
        System.out.println("==========================");
        heap.printHeap();
    }

}
