// Trying my best not to use collections and use my own implmentations
package Data_Structures;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedWeightedAdjacencyList {
    SingleLinkedList[] list;
    int size;

    // In the future replace array with array List
    public DirectedWeightedAdjacencyList(int size) {
        this.size = size;
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

    public ArrayList<Integer> bfs(int source, int key) {
        int[] prev = solve(source);

        return reconstructPath(source, key, prev);
    }

    public int[] solve(int source) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visted = new boolean[this.size];
        int[] prev = new int[this.size];

        for (int i = 0; i < list.length; i++) {
            visted[i] = false;
        }
        for (int i = 0; i < list.length; i++) {
            prev[i] = -1;
        }

        queue.add(source);

        visted[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            SingleLinkedList neighbors = list[node];

            for (int i = 0; i < neighbors.getLength(); i++) {
                if (!visted[neighbors.getAt(i)]) {
                    queue.add(neighbors.getAt(i));
                    visted[neighbors.getAt(i)] = true;
                    prev[neighbors.getAt(i)] = node;
                }
            }
        }
        return prev;
    }

    public ArrayList<Integer> reconstructPath(int source, int key, int[] prev) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        for (int i = key; i != -1; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        if (path.get(0) == source) {
            return path;
        }
        System.out.println("Path not found!");
        return path;

    }

    public ArrayList<Integer> dfs(int source, int key) {

        ArrayList<Integer> path = new ArrayList<>();
        boolean[] seen = new boolean[size];
        for (int i = 0; i < seen.length; i++) {
            seen[i] = false;
        }

        dfsWalk(source, key, seen, path);

        return path;
    }

    public boolean dfsWalk(int current, int key, boolean[] seen, ArrayList<Integer> path) {
        if (seen[current]) {
            return false;
        }

        seen[current] = true;
        path.add(current);

        if (current == key) {
            return true;
        }

        SingleLinkedList my_list = list[current];
        for (int i = 0; i < my_list.getLength(); ++i) {
            int edge = my_list.getAt(i);
            if (dfsWalk(edge, key, seen, path)) {
                return true;
            }

        }

        path.removeLast();

        return false;
    }

    public void printAdjList() {
        System.out.println("-------------------------------");
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + ": ");
            list[i].printList();
        }
    }

    public static void main(String args[]) {
        DirectedAdjacencyList graph = new DirectedAdjacencyList(5);
        graph.printAdjList();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        graph.printAdjList();
        System.out.println(graph.bfs(1, 4));

        System.out.println("-------------------");
        System.out.println(graph.dfs(1, 4));

    }
}
