class CircularQueue {
    private int front, rear;
    private int array[];
    private int capacity;

    CircularQueue(int size) {
        capacity = size;
        array = new int[capacity];
        front = -1;
        rear = -1;
    }

    public static void main(String args[]) {
        CircularQueue queue = new CircularQueue(5);

        queue.printQueue();
        queue.enqueue(5);

    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
        }

        if (front == -1) {
            front++;
            rear++;
            array[front] = value;
        }
    }

    public int dequeue() {
        int value = array[front];
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            System.exit(-1);
        }

        return value;
    }

    public void peek() {

    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front - rear >= capacity;
    }

    public void printQueue() {
        if (isEmpty()) {

        } else {

        }
    }

}
