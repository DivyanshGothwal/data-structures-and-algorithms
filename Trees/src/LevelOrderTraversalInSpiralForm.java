package src;

import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {
	public static void main(String ar[]) {
		Tree root = new Tree(9);
		root.left = new Tree(8);
		root.left.left = new Tree(9);
		root.left.left.left = new Tree(12);
		root.left.left.left.left = new Tree(122);
		root.left.left.right = new Tree(10);
		root.left.left.right.right = new Tree(210);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.left.left = new Tree(20);
		root.left.right.right = new Tree(14);
		root.left.right.right.left = new Tree(16);
		root.left.right.right.right = new Tree(17);
		root.right = new Tree(11);
		root.right.left = new Tree(5);
		root.right.left.left = new Tree(51);
		root.right.left.left.left = new Tree(55);
		root.right.left.left.right = new Tree(56);
		root.right.left.right = new Tree(52);
		root.right.left.right.left = new Tree(53);
		root.right.left.right.right = new Tree(54);
		root.right.right = new Tree(15);
		root.right.right.left = new Tree(100);
		root.right.right.left.left = new Tree(101);
		root.right.right.left.right = new Tree(102);
		levelOrderInSpiralForm(root);
	}

	private static void levelOrderInSpiralForm(Tree root) {
		Stack<Tree> st = new Stack<>();
		Stack<Tree> newSt = new Stack<>();
		st.push(root);
		while (!st.isEmpty() || !newSt.isEmpty()) {
			while (!st.isEmpty()) {
				Tree top = st.pop();
				System.out.println(top.data);
				if (top.right != null) {
					newSt.push(top.right);
				}
				if (top.left != null) {
					newSt.push(top.left);
				}
			}
			while (!newSt.isEmpty()) {
				Tree top = newSt.pop();
				System.out.println(top.data);
				if (top.left != null) {
					st.push(top.left);
				}
				if (top.right != null) {
					st.push(top.right);
				}
			}
		}
	}
}
