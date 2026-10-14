package Demo;

class Node {
    int data;
    Node left, right;
    Node(int data) { 
        this.data = data; 
    }
}

public class SwappedNodesSrecoverBST {

    static Node first, second, prev;

    static void recoverBST(Node root) {
        if (root == null) return;
        
        recoverBST(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;

        recoverBST(root.right);
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                 40
                /  \
              60    20
             / \    / \
            10 30  50 70

            20 and 60 are swapped
        */

        Node root = new Node(40);
        root.left = new Node(60);
        root.right = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(70);

        System.out.println("Before Recovery:");
        inorder(root);
        System.out.println();

        // Find swapped nodes
        first = second = prev = null;
        recoverBST(root);

        // Swap their values to fix BST
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        System.out.println("After Recovery:");
        inorder(root);
    }
}