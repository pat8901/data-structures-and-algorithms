// Is a queue a FIFO or LIFO?

class Queue {
    private int arr[];
    private int front;
    private int rear;
    private int capacity;

    Queue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    public static void main(String args[]) {
        Queue queue = new Queue(5);
        queue.enqueue(50);
        queue.enqueue(232);
        queue.enqueue(512);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        queue.enqueue(100);
        queue.printQueue();
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            System.exit(-1);
        } else {
            if (front == -1)
                front = 0;
            rear++;
            arr[rear] = value;
            System.out.println("Enqueued " + arr[rear]);
        }
    }

    public int dequeue() {
        int value;
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            value = arr[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Dequeued: " + value);
            return value;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        }
        System.err.println("Front: " + front);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            for (int i = front; i <= rear - 1; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println(arr[rear]);
        }
    }

}