// Also called ring buffers, circular buffer, array buffer
// This implmentation needs to be redone, better way to do it
package Queue;

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

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            array[rear] = value;
        }

    }

    public int dequeue() {
        int value;
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            value = array[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return value;
        }
    }

    public void peek() {

    }

    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (front == 0 && rear == capacity - 1)
            return true;
        if (front == rear + 1)
            return true;
        return false;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i != rear; i = (i + 1) % capacity) {
                System.out.print(array[i] + " ");
            }
            System.out.println(array[rear]);
        }
    }

    public static void main(String args[]) {
        CircularQueue queue = new CircularQueue(5);

        queue.printQueue();
        queue.enqueue(64);
        queue.printQueue();
        queue.enqueue(32);
        queue.enqueue(16);
        queue.enqueue(128);
        queue.printQueue();
        queue.enqueue(512);
        queue.printQueue();
        queue.enqueue(90);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(1024);
        queue.printQueue();
    }

}
