// Trying my best not to use collections and use my own implmentations
package Data_Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedWeightedAdjacencyList {
    LinkedList<Edge>[] adjacencylist;
    int vertices;

    public class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // In the future replace array with array List
    public DirectedWeightedAdjacencyList(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        for (int i = 0; i < adjacencylist.length; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addLast(edge);
    }

    public void removeEdge(int source, int destination) {
        Edge temp = adjacencylist[source].peekFirst();
        int count = 1;
        while (temp.destination != destination) {
            temp = adjacencylist[source].get(count);
            count++;
        }
        adjacencylist[source].remove(temp);
    }

    public ArrayList<Integer> bfs(int source, int key) {
        int[] prev = solve(source);

        return reconstructPath(source, key, prev);
    }

    public int[] solve(int source) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visted = new boolean[this.vertices];
        int[] prev = new int[this.vertices];

        for (int i = 0; i < adjacencylist.length; i++) {
            visted[i] = false;
        }
        for (int i = 0; i < adjacencylist.length; i++) {
            prev[i] = -1;
        }

        queue.add(source);

        visted[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            LinkedList<Edge> neighbors = adjacencylist[node];

            for (int i = 0; i < neighbors.size(); i++) {
                if (!visted[neighbors.get(i).destination]) {
                    queue.add(neighbors.get(i).destination);
                    visted[neighbors.get(i).destination] = true;
                    prev[neighbors.get(i).destination] = node;
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
        boolean[] seen = new boolean[vertices];
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

        LinkedList<Edge> my_list = adjacencylist[current];
        for (int i = 0; i < my_list.size(); ++i) {
            int edge = my_list.get(i).destination;
            if (dfsWalk(edge, key, seen, path)) {
                return true;
            }

        }

        path.removeLast();

        return false;
    }

    public void printAdjList() {
        System.out.println("-------------------------------");
        for (int i = 0; i < adjacencylist.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjacencylist[i].size(); j++) {
                System.out.print(
                        adjacencylist[i].get(j).destination + "[weight:" + adjacencylist[i].get(j).weight + "] ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        DirectedWeightedAdjacencyList graph = new DirectedWeightedAdjacencyList(5);
        graph.printAdjList();
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 2, 99);
        graph.addEdge(2, 4, 1000);
        graph.addEdge(2, 1, 22);

        graph.printAdjList();
        System.out.println(graph.bfs(2, 4));

        System.out.println("-------------------");
        System.out.println(graph.dfs(1, 4));

    }
}
