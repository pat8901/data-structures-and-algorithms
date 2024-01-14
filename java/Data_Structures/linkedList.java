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

    public void addTailNode(int data) {
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

    public void addHeadNode(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            node.next = null;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addNodeAtIndex(int index, int data) {

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
        list.addTailNode(255);
        list.addTailNode(8);
        list.addTailNode(16);
        list.addTailNode(64);
        list.addTailNode(512);
        list.addHeadNode(200);
        list.addHeadNode(76);
        list.addTailNode(90);
        list.removeHeadNode();
        list.removeHeadNode();
        list.removeHeadNode();
        list.addHeadNode(1024);
        list.removeHeadNode();
        list.addTailNode(2000);
        list.removeTailNode();
        list.removeTailNode();
        list.removeTailNode();
        list.removeTailNode();
        list.removeTailNode();

        list.printList();
    }
}
