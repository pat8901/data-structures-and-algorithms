class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;

    public void insert(int data){
        root = insertRec(root, data);
    }

    public Node insertRec(Node root,int data){
    
        if (root == null){
            root = new Node(data);
        }
        else if (data < root.data){
            root.left = insertRec(root.left, data);
        }
        else if (data > root.data){ 
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void removeNode(){

    }

    public void inOrder(){

    }
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
    }

}   
