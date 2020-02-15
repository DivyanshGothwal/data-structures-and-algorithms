package src;

import java.util.*;

public class ReverseTreePath {
	public static void main(String ar[]) {
		Tree root = new Tree(9);
		root.left = new Tree(18);
		root.left.left = new Tree(19);
		root.left.left.left = new Tree(81);
		root.left.left.right = new Tree(10);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(8);
		root.right = new Tree(68);
		root.right.left = new Tree(76);
		root.right.right = new Tree(97);
		root.right.right.left = new Tree(150);
		List<Tree> ar1 = new ArrayList<>(100);
		inOrder(root);
		reverse(root, 6, ar1);
		System.out.println(" line");
		inOrder(root);
	}

	static Boolean inOrder(Tree root) {
		if (root == null)
			return false;
		boolean left = inOrder(root.left);
		System.out.print(root.data + " ");
		boolean right = inOrder(root.right);
		return left || right;
	}

	static Boolean reverse(Tree root, int data, List<Tree> ar) {
		if (root == null)
			return false;
		ar.add(root);
		if (root.data == data) {
			reverse(ar, data);
		}
		boolean left = reverse(root.left, data, ar);
		boolean right = reverse(root.right, data, ar);
		ar.remove(root);
		return left || right;
	}

	static void reverse(List<Tree> ar, int data) {
		int i = 0, j = ar.size() - 1;
		while (i <= j) {
			Tree left = ar.get(i);
			Tree right = ar.get(j);
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			i++;
			j--;
		}
	}
}
