package Data_Structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Data_Structures.BinaryTree.TreeNode;

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

    public void bfs(int start) {
        boolean[] seen = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            seen[i] = false;
        }

        seen[start] = true;
        List<Integer> queue = new ArrayList<>(); //
        queue.add(start);

        int visit;
        while (!queue.isEmpty()) {
            visit = queue.get(0);
            System.out.print(visit + " ");
            queue.remove(queue.get(0));

            for (int i = 0; i < vertex; i++) {
                if (matrix[visit][i] == 1 && (!seen[i])) {
                    queue.add(i);
                    seen[i] = true;
                }
            }
        }
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
        AdjacencyMatrix graph = new AdjacencyMatrix(4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 1);

        graph.printMatrix();
        System.out.println("------------------");
        graph.bfs(3);
    }
}
