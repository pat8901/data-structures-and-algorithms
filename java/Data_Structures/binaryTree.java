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

    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
    }

}
