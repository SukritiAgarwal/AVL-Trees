package EC4;

public class AVLTree {
	Node root;
	
	public int getHeight(Node n) {
		if(n!= null)
			return n.height;
		return 0;
	}
	
	public int BalanceFactor(Node n) {
		if(n != null)
			return (getHeight(n.left) - getHeight(n.right));
		return 0;
	}
	
	public void traverse(Node root) {
		if(root!= null) {
			traverse(root.left);
			System.out.print(" " + root.value);
			traverse(root.right);
		}
	}
	
	public int max(int a, int b) {
		if(a > b)
			return a;
		else
			return b;
	}
	
	public Node rightRotation(Node n) {
		Node a = n.left;
		Node b = a.right;
		
		a.right = n; //Rotation
		n.left = b;
		
		a.height = max(getHeight(a.left), getHeight(a.right)) + 1;
		b.height = max(getHeight(b.left), getHeight(b.right)) + 1;
		
		return a;
	}
	
	public Node leftRotation(Node n) {
		Node a = n.right;
		Node b = a.left;
		
		a.left = n; //Rotation
		n.right = b;
		
		a.height = max(getHeight(a.left), getHeight(a.right)) + 1;
		b.height = max(getHeight(b.left), getHeight(b.right)) + 1;
		
		return a;
	}
}

//  https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
// https://algorithms.tutorialhorizon.com/avl-tree-insertion/
// http://interactivepython.org/lpomz/courselib/static/pythonds/Trees/AVLTreeImplementation.html