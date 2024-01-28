package Graph_Search_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import Data_Structures.DirectedWeightedAdjacencyList;
import Data_Structures.DirectedWeightedAdjacencyList.Edge;

//  Data Structures used:
//  Double linked list
//  ArrayList
//  Directed weighted Adjacency List (Graph)
//  Node (Edge)
// 

public class dijkstra {

    public ArrayList<Integer> dijkstraList(int source, int destination, DirectedWeightedAdjacencyList graph) {
        boolean[] seen = new boolean[graph.vertices];
        int[] prev = new int[graph.vertices];
        int[] dists = new int[graph.vertices];

        for (int i = 0; i < seen.length; i++) {
            seen[i] = false;
        }
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        dists[source] = 0;

        while (hasUnvisited(seen, dists)) {
            int current = getLowestUnvisited(seen, dists);
            seen[current] = true;

            LinkedList<Edge> edges = graph.adjacencylist[current];

            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if (seen[edge.destination]) {
                    continue;
                }

                int dist = dists[current] + edge.weight;
                if (dist < dists[edge.destination]) {
                    dists[edge.destination] = dist;
                    prev[edge.destination] = current;
                }
            }

        }
        ArrayList<Integer> out = new ArrayList<Integer>();
        int current = destination;
        while (prev[current] != -1) {
            out.add(current);
            current = prev[current];
        }

        out.add(source);
        System.out.println("Before reverse: " + out.toString());
        Collections.reverse(out);

        return out;
    }

    public boolean hasUnvisited(boolean[] seen, int[] dists) {
        boolean has = false;
        for (int i = 0; i < seen.length; i++) {
            if (seen[i] == false && dists[i] < Integer.MAX_VALUE) {
                return true;
            }
        }
        return has;
    }

    // Will return the index of the edge with the smallest weight
    public int getLowestUnvisited(boolean[] seen, int[] dists) {
        int index = -1;
        int lowestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < seen.length; ++i) {
            if (seen[i]) {
                continue;
            }
            if (lowestDistance > dists[i]) {
                lowestDistance = dists[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String args[]) {
        DirectedWeightedAdjacencyList graph = new DirectedWeightedAdjacencyList(5);
        dijkstra d = new dijkstra();
        graph.printAdjList();
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 2, 99);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 0, 0);
        graph.addEdge(0, 4, 0);
        graph.printAdjList();
        System.out.println(d.dijkstraList(2, 4, graph));
    }
}
