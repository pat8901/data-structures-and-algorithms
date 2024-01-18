package Data_Structures;

public class BinaryTree {
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

    public TreeNode insertRec(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
        } else if (data <= root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public boolean delete(TreeNode root, int key) {
        // Case no children
        // delete
        if (root == null) {
            return false;
        }

        // Case one child
        // set parent to child

        // Case two children
        // get to the two previous cases
        return true;
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

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(5);
        tree.insert(10);
        tree.insert(2);

        BinaryTree b = new BinaryTree();
        b.insert(5);
        b.insert(5);
        b.insert(10);
        b.insert(2);

        System.out.println("Compare result: " + tree.compare(tree.root, b.root));
        System.out.println("Find result: " + b.search(b.root, 5));

    }

}
