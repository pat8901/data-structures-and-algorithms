// refactor this to be similar to adj List
// Need to make weighted and directed
// need to implement true bfs and dfs not bfprint dfprint

package Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix {
    private int vertex;
    private int[][] matrix;

    public AdjacencyMatrix(int size) {
        vertex = size;
        matrix = new int[size][size];
    }

    public void addEdge(int from, int to) {
        if (from >= vertex | to >= vertex) {
            System.out.println("Location does exist!");
            return;
        } else {
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }
    }

    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
        matrix[to][from] = 0;
    }

    // I dont know if this is implmented right. I want to return a true path array
    // to the key
    public List<Integer> bfs(int start, int key) {
        boolean[] seen = new boolean[vertex];
        List<Integer> path = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            seen[i] = false;
        }

        seen[start] = true;
        List<Integer> queue = new ArrayList<>();
        queue.add(start);

        int visit;
        while (!queue.isEmpty()) {
            visit = queue.get(0);
            path.add(visit);
            if (visit == key) {
                System.out.println("found key!");
                System.out.println("path to key: " + path.toString());
                return path;
            }
            queue.remove(queue.get(0));

            // Adding neighbors to queue
            for (int i = 0; i < vertex; i++) {
                if (matrix[visit][i] == 1 && (!seen[i])) {
                    queue.add(i);
                    seen[i] = true;
                }
            }
        }
        System.out.println("Key not found!");
        return path;
    }

    public void dfs() {

    }

    public void printMatrix() {
        System.out.print("  ");
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < vertex; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < vertex; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printMatrix();
        System.out.println("------------------");

        System.out.println(graph.bfs(0, 2));
    }
}
