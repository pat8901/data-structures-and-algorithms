// Is a queue a FIFO or LIFO?

// What are queues used for.
//Answer: 
// CPU scheduling, Disk Scheduling
// When data is transferred asynchronously between two processes.The queue is used for synchronization. For example: IO Buffers, pipes, file IO, etc
// Handling of interrupts in real-time systems.
// Call Center phone systems use Queues to hold people calling them in order.

// What is the time complexity?
// Answer: 
// The complexity of enqueue and dequeue operations in a queue using an array is O(1). 
//If you use pop(N) in python code, then the complexity might be O(n) depending on the position of the item to be popped.

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
        System.out.println("Front: " + front);
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