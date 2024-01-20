package Data_Structures;
// Need to make flash cards

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
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            tail = head;
            return true;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;

        return true;
    }

    public boolean prepend(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            node.next = head;
            head = node;
            tail = node;
            return true;
        }
        node.next = head;
        head = node;

        return true;
    }

    public boolean insertAt(int data, int index) {
        ListNode node = new ListNode(data);
        ListNode temp = head;

        if (index == 0 && temp != null) {
            node.next = head;
            head.prev = node;
            head = node;
            return true;
        }

        int counter = 0;

        while (temp != null) {
            if (counter == index) {
                temp.prev.next = node;
                node.next = temp;
                node.prev = temp.prev;
                temp.prev = node;
                return true;
            } else {
                temp = temp.next;
                counter++;
            }

        }

        if (temp == null) {
            System.out.println("Index not found");
        }

        return false;
    }

    public boolean removeKey(int key) {
        ListNode temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null)
            return false;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        if (temp == head) {
            if (head == null) {
                return false;
            }
            if (head == tail) {
                head = tail = null;
                return true;
            }
            head = head.next;
            head.prev = null;
            temp.next = null;
            return true;
        }
        if (temp == tail) {
            if (tail == null)
                return false;
            if (head == tail) {
                head = tail = null;
                return true;
            }
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            return true;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = temp.next = null;
        return true;
    }

    public boolean removeIndex(int index) {
        ListNode temp = head;
        if (head == null)
            return false;
        if (index == 0) {
            if (head == tail) {
                head = tail = null;
                return true;
            }
            head = head.next;
            head.prev = null;
            temp.next = null;
            return true;
        }
        int counter = 0;

        while (temp != null && counter != index) {
            temp = temp.next;
            counter++;
        }
        if (temp == null) {
            System.out.println("Index not found");
            return false;
        }
        if (temp == tail) {
            if (tail == null)
                return false;
            if (head == tail) {
                head = tail = null;
                return true;
            }

            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            return true;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;

        return true;
    }

    public boolean removeHead() {
        if (head == null) {
            return false;
        }
        if (head == tail) {
            head = tail = null;
            return true;
        }
        ListNode temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return true;
    }

    public boolean removeTail() {
        if (tail == null)
            return false;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        ListNode temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        return true;
    }

    public int getLength() {
        int counter = 0;
        ListNode temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public void printList() {
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(32);
        list.append(64);
        list.append(128);

        list.printList();
        System.out.println("length: " + list.getLength());

        list.removeKey(12);
        list.printList();
        System.out.println("length: " + list.getLength());
    }
}
