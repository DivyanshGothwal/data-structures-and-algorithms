package src;

import java.util.Stack;

public class PrintBSTKeysInGivenRange {

	public static void main(String[] args) {
		Tree bst = new Tree(10);
		bst.left = new Tree(6);
		bst.left.left = new Tree(1);
		bst.left.right = new Tree(7);

		bst.right = new Tree(29);
		bst.right.left = new Tree(15);
		bst.right.right = new Tree(40);
		bst.right.right.left = new Tree(35);

		int start = 6;
		int end = 36;

		printRange(bst, start, end);
	}

	private static void printRange(Tree bst, int start, int end) {
		Stack<Tree> st = new Stack<>();
		st.push(bst);
		while (!st.isEmpty()) {
			Tree temp = st.peek();
			if (temp == null) {
				st.pop();
			} else {
				while (temp.left != null) {
					st.push(temp.left);
					temp = temp.left;
				}
			}
			if (st.isEmpty()) {
				break;
			}
			temp = st.peek();
			if (temp.data > start && temp.data < end) {
				System.out.println(temp.data);
			}
			st.pop();
			st.push(temp.right);
		}
	}

}
