package Data_Structures;

public class DoubleLinkedList {
    ListNode head;
    ListNode tail;

    class ListNode {
        ListNode prev;
        ListNode next;
        int data;

        ListNode(int data) {
            this.data = data;
        }
    }

    public boolean append(int data) {
        return true;
    }

    public boolean prepend(int data) {
        return true;
    }

    public boolean insertAt(int data) {
        return false;
    }

    public boolean removeKey(int key) {
        return false;
    }

    public boolean removeIndex(int index) {
        return false;
    }

    public boolean removeHead() {
        return false;
    }

    public boolean removeTail() {
        return false;
    }

    public int getLength() {
        int counter = 0;
        return -1;
    }

    public void printList() {

    }

    public static void main(String args[]) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.printList();
    }
}
