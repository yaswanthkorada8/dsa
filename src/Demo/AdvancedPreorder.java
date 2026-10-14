package Demo;
import java.util.Stack;
public class AdvancedPreorder {
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	static void PreOrder(Node root) {
		if (root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.data + " ");
			
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
						
		}
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
		System.out.println("PreOrder traversal:");
		
		PreOrder(root);
	}

}