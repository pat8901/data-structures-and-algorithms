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

    public void heapify(int ht[], int i) {

    }

    public void insertNode(int ht[], int newNumber) {

    }

    public void deleteNode(int ht[], int number) {

    }

    public void printHeap() {

    }

    public static void main(String args[]) {

    }

}
