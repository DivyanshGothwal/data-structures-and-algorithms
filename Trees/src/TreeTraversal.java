package src;

public class TreeTraversal {
	public static void main(String ar[]) {
		Tree root = new Tree(9);
		root.left = new Tree(8);
		root.left.left = new Tree(86);
		root.left.left.left = new Tree(58);
		root.left.left.right = new Tree(43);
		root.left.right = new Tree(83);
		root.left.right.left = new Tree(1);
		root.left.right.right = new Tree(5);
		root.right = new Tree(7);
		root.right.left = new Tree(7);
		root.right.right = new Tree(2);
		root.right.right.left = new Tree(7);
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		preOrder(root);
	}
	static void inOrder(Tree root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	static void postOrder(Tree root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	static void preOrder(Tree root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}
//class Tree {
//	int data;
//	Tree left;
//	Tree right;
//
//	Tree(int data, Tree left, Tree right) {
//		this.data = data;
//		this.left = left;
//		this.right = right;
//	}
//
//	Tree(int data) {
//		this.data = data;
//		this.left = null;
//		this.right = null;
//	}
//}