package Demo;

public class BinaryTreeHeight {
	
	static class Node {
		int data;
		Node left;
		Node right;

        Node(int data) {
            this.data = data;
        }
    }
	static int height(Node root) {
		// Empty tree
		if (root == null) {
			return -1;
		}
		
		// Find height of left subtree
		int leftHeight = height(root.left);
		
		// Find height of right subtree
		int rightHeight = height(root.right);
		
		// Return longest path
		return 1 + Math.max(leftHeight, rightHeight);
	}
	public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.left.right.left = new Node(35);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("Height of Binary Tree: "
        		+ height(root));
    }
}