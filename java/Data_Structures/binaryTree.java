package Data_Structures;

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public TreeNode insertRec(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
        } else if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void removeNode() {

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
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(10);
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
    }

}
