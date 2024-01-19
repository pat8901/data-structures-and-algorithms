package Data_Structures;

class ListNode {
    public int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

class List {
    ListNode head;

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

    public void insertAt(int index, int data) {

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

    public boolean remove(int key) {
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

    public void get() {

    }

    public void removeTailNode() {
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

    public void removeHeadNode() {
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
        List list = new List();

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
    }
}
