// Also called ring buffers, circular buffer, array buffer
// This implmentation needs to be redone, better way to do it
package Queue;

class CircularQueue {
    private int front, rear;
    private int queue[];
    private int capacity;

    CircularQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = rear = -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        } else if (isEmpty()) {
            front++;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int value = queue[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return value;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front Valuse:" + this.queue[front]);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i != rear; i = (i + 1) % capacity) {
                System.out.print(queue[i] + " ");
            }
            System.out.println(queue[rear]);
        }
    }

    public static void main(String args[]) {
        CircularQueue circular_queue = new CircularQueue(5);

        circular_queue.enqueue(5);
        circular_queue.enqueue(9);
        circular_queue.enqueue(3);
        circular_queue.enqueue(543);
        circular_queue.enqueue(90);
        circular_queue.enqueue(100);
        circular_queue.printQueue();
        circular_queue.dequeue();
        circular_queue.printQueue();

        circular_queue.enqueue(100);
        circular_queue.printQueue();
        circular_queue.dequeue();
        circular_queue.peek();
        circular_queue.printQueue();

    }

}
