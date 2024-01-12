class Node {
    public int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class List {
    Node head;

    public void addNode(int data){
        Node node = new Node(data);
        node.next = null;

        if(head == null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }

    }
    public void removeNode(){

    }
    public void printList(){
        if (head == null){
            System.out.println("No nodes to print!");
        }

        Node temp = head;
        while (temp.next != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String args[]){
        List list = new List();

        list.addNode(255);
        list.printList();
    }
}
