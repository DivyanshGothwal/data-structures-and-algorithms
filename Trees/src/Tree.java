package src;

public class Tree implements Comparable<Tree> {
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

	@Override
	public int compareTo(Tree o1) {
		return o1.data - this.data;
	}
	
	@Override
	public int hashCode() {
		return this.data;
	}
}
