package src;

public class AVLTreeInsertion {

	public static void main(String ar[]) {
		AvlTree root = new AvlTree(50);
		insertAvlTree(root, 40);
	}

	public static void insertAvlTree(AvlTree root, Integer data) {
		if (root == null) {
			return;
		}
		if (root.data > data) {
			insertAvlTree(root.left, data);
		}
		if (root.data < data) {
			insertAvlTree(root.left, data);
		}
	}
}

class AvlTree {
	Integer height;
	AvlTree left;
	AvlTree right;
	Integer data;

	AvlTree(Integer data) {
		this.data = data;
	}
}
