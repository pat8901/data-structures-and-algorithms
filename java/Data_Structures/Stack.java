package Data_Structures;
// What are the operations of a stack?

// What (for the array-based implementation of a stack), the push and pop operations take? 
// Answer: O(1)

// What are the uses of a stack? 
// Answer: To reverse a word - Put all the letters in a stack and pop them out. Because of the LIFO order of stack, you will get the letters in reverse order.
// In compilers - Compilers use the stack to calculate the value of expressions like 2 + 4 / 5 * (7 - 9) by converting the expression to prefix or postfix form.
// In browsers - The back button in a browser saves all the URLs you have visited previously in a stack. Each time you visit a new page, it is added on top of the stack. When you press the back button, the current URL is removed from the stack, and the previous URL is accessed.

public class Stack {
    private int top;
    private int arr[];
    private int capacity;

    // Creating the object
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public static void main(String args[]) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(7);
        stack.push(100);
        stack.push(4);
        stack.push(-67);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.push(300);
        stack.printStack();
        stack.push(0);
        stack.printStack();
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full!");
            System.exit(-1);
        }

        top++;
        arr[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            System.exit(-1);
        }

        int value = arr[top];
        top--;
        return value;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            System.exit(-1);
        }
        System.out.println(arr[top]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            System.exit(-1);
        }
        for (int i = 0; i <= top - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[top]);
    }

}