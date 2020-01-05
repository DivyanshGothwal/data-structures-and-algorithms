package src;

public class Tree {
	int data;
	Tree left;
	Tree right;

	Tree(int data, Tree left, Tree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
