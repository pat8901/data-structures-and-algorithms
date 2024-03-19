package Queue;

public class Queue {
    private int queue[];
    private int front;
    private int rear;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        if (front == -1) {
            front++;
        }

        rear++;
        queue[rear] = value;
        System.out.println("Enqueued " + queue[rear]);
    }

    public int deque() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        System.out.println("Dequeued: " + value);
        return value;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Front: " + queue[front]);
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        } else {
            for (int i = front; i <= rear - 1; i++) {
                System.out.print(queue[i] + ", ");
            }
            System.out.println(queue[rear]);
        }
    }

    public static void main(String args[]) {
        Queue queue = new Queue(5);
        queue.enqueue(50);
        queue.enqueue(65);
        queue.enqueue(56);
        queue.enqueue(32);
        queue.enqueue(8);
        queue.enqueue(100);
        queue.deque();
        queue.enqueue(100);
        queue.printQueue();
        queue.peek();
    }

}