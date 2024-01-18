// For later think of a way where you can implement BFS without using built-in java data structures
// The queue would need to be able to hold tree nodes and not ints
package Graph_Search_Algorithms;

import java.util.LinkedList;
import java.util.Queue;
import Data_Structures.BinaryTree;
import Data_Structures.BinaryTree.TreeNode;

public class breadthFirstSearch {

    public void bfs(BinaryTree tree, int key) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.data);

            if (temp.data == key) {
                System.out.println("Found key!");
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(50);
        tree.insert(1);
        tree.insert(12);
        tree.insert(5);

        breadthFirstSearch search = new breadthFirstSearch();
        int key = 5;

        search.bfs(tree, key);

    }
}
