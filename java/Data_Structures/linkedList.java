class LinkNode {
    public int data;
    LinkNode next;

    LinkNode(int item) {
        data = item;
    }
}

class List {
    LinkNode head;

    List() {
        head = new LinkNode(0);
    }
}
