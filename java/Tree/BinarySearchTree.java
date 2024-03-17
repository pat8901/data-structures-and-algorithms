package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public TreeNode root;

    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
        } else if (data <= root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        // base case for never finding the node
        if (root == null) {
            return root;
        }
        // traversing to find the node
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        }
        // If the node is neither less than or greater than, then it must be equal
        // i.e. we found the node
        else {
            // Cases when the node only has one child or no children
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case when node has two children
            root.data = inOrderSuccessor(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public int inOrderSuccessor(TreeNode root) {
        int minimum = root.data;
        while (root.left != null) {
            minimum = root.left.data;
            root = root.left;
        }
        return minimum;
    }

    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data < key) {
            return search(root.right, key);
        }
        return search(root.left, key);
    }

    public boolean compare(TreeNode a, TreeNode b) {
        // Are we structurally the same?
        if (a == null && b == null) {
            return true;
        }
        // Are we structurally not the same?
        if (a == null || b == null) {
            return false;
        }
        // Are the node values equal?
        if (a.data != b.data) {
            return false;
        }

        return compare(a.left, b.left) && compare(a.right, b.right);
    }

    public void inOrder() {
        System.out.println("In-Order:");
        inOrderRec(root);
        System.out.println("");
    }

    public void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);

        }
    }

    public void preOrder() {
        System.out.println("Pre-Order:");
        preOrderRec(root);
        System.out.println("");
    }

    public void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);

        }
    }

    public void postOrder() {
        System.out.println("Post-Order:");
        postOrderRec(root);
        System.out.println("");
    }

    public void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void bfs(int key) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");

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
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(10);
        tree.insert(2);
        tree.insert(0);
        tree.insert(3);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(12);

        System.out.println("======================================");
        System.out.println("Depth First Search");
        tree.inOrder();

        System.out.println("======================================");
        System.out.println("Breadth First Search");
        tree.bfs(9);
    }
}
