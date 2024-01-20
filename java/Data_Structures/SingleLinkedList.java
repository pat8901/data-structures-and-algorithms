package Data_Structures;

public class SingleLinkedList {
    ListNode head;

    class ListNode {
        public int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public int getLength() {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void append(int data) {
        ListNode node = new ListNode(data);
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

    }

    public void prepend(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            node.next = null;
        } else {
            node.next = head;
            head = node;
        }
    }

    public boolean insertAt(int index, int data) {
        ListNode node = new ListNode(data);
        ListNode temp = head;
        ListNode prev = null;

        if (index == 0 && temp != null) {
            node.next = head;
            head = node;
            System.out.println("Inserted " + data + " at index " + index);
            return true;
        }

        int counter = 0;
        while (temp != null) {
            if (counter == index) {
                prev.next = node;
                node.next = temp;
                System.out.println("Inserted " + data + " at index " + index);
                return true;
            } else {
                prev = temp;
                temp = temp.next;
                counter++;
            }
        }

        if (temp == null) {

            System.out.println(index + " index was not found");
        }
        return false;
    }

    public boolean removeAt(int index) {
        ListNode temp = head;
        ListNode prev = null;

        if (index == 0 && temp != null) {
            head = temp.next;
            System.out.println("Deleted: " + index);
            return true;
        }

        int counter = 0;

        while (temp != null) {
            if (counter == index) {
                prev.next = temp.next;
                System.out.println("Deleted: " + index);
                return true;
            } else {
                prev = temp;
                temp = temp.next;
                counter++;
            }
        }
        if (temp == null) {
            System.out.println(index + " position was not found");
        }
        return false;
    }

    // I dont know if I am setting the head right
    public boolean removeKey(int key) {
        ListNode temp = head;
        ListNode prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            System.out.println("Deleted: " + key);
            return true;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            prev.next = temp.next;
            System.out.println("Deleted: " + key);
            return true;
        }

        if (temp == null) {
            System.out.println(key + " was not found");
        }
        return false;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void removeTail() {
        if (head == null) {
            System.out.println("No nodes to remove!");
        } else if (head.next == null) {
            head = null;
        } else {
            ListNode prev = null;
            ListNode temp = head;

            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
    }

    public void removeHead() {
        if (head == null) {
            System.out.println("No nodes to remove!");
        } else {
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("No nodes to print!");
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println(temp.data + " -> null");
        }

    }

    public static void main(String args[]) {
        SingleLinkedList list = new SingleLinkedList();

        list.append(1);
        list.append(90);
        list.append(64);
        list.append(256);
        list.append(32);
        list.printList();
        System.out.println("Length: " + list.getLength());
        list.removeAt(2);
        list.printList();
        System.out.println("Length: " + list.getLength());
        list.insertAt(3, 512);
        list.printList();
        System.out.println("Length: " + list.getLength());
        list.getHead();
        list.removeKey(1);
        list.printList();
        list.getHead();
    }
}