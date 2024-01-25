// Trying my best not to use collections and use my own implmentations
package Data_Structures;

public class AdjacencyList {
    SingleLinkedList[] list;

    // In the future replace array with array List
    public AdjacencyList(int size) {
        list = new SingleLinkedList[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = new SingleLinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        list[source].append(destination);
    }

    public void removeEdge(int source, int destination) {
        list[source].removeKey(destination);
    }

    public void bfs() {

    }

    public void dfs() {

    }

    public void printList() {
        System.out.println("-------------------------------");
        for (int i = 0; i < list.length; i++) {
            list[i].printList();
        }
    }

    public static void main(String args[]) {
        AdjacencyList graph = new AdjacencyList(5);
        graph.printList();
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(4, 1);
        graph.addEdge(2, 78);
        graph.addEdge(2, 90);
        graph.addEdge(2, 32);
        graph.printList();

        System.out.println("-------------------------------");
        graph.removeEdge(4, 1);
        graph.removeEdge(2, 90);
        graph.printList();
    }
}
