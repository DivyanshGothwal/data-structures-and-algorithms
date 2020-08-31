package src;

import java.util.Stack;

public class FindPairWithGivenSumInBalancedBST {

	public static void main(String[] ar) {
		Tree bst = new Tree(12);
		bst.left = new Tree(8);
		bst.left.left = new Tree(1);
		bst.left.right = new Tree(7);

		bst.right = new Tree(29);
		bst.right.left = new Tree(15);
		bst.right.right = new Tree(40);
		bst.right.right.left = new Tree(35);

		int sum = 13;
		if (findInBST(bst, sum)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		;
	}

	private static Boolean findInBST(Tree bst, int sum) {
		Stack<Tree> st1 = new Stack<>();
		Stack<Tree> st2 = new Stack<>();
		st1.push(bst);
		st2.push(bst);
		Boolean temp1Update = true;
		Boolean temp2Update = true;
		while (!st1.isEmpty() || !st2.isEmpty()) {
			Tree temp1 = null;
			if (!st1.isEmpty()) {
				temp1 = st1.peek();
			} else {
				temp1 = new Tree(Integer.MAX_VALUE);
			}

			Tree temp2 = null;
			if (!st2.isEmpty()) {
				temp2 = st2.peek();
			} else {
				temp2 = new Tree(Integer.MAX_VALUE);
			}

			if (temp1 == null && !st1.isEmpty()) {
				st1.pop();
			}
			if (temp2 == null && !st2.isEmpty()) {
				st2.pop();
			}
			if (temp2 != null || temp1 != null) {
				while (temp1Update && temp1 != null && temp1.left != null) {
					st1.push(temp1.left);
					temp1 = temp1.left;
				}
				while (temp2Update && temp2 != null && temp2.right != null) {
					st2.push(temp2.right);
					temp2 = temp2.right;
				}
			}
			if (st1.isEmpty() && st2.isEmpty()) {
				break;
			}
			if (!st1.isEmpty()) {
				temp1 = st1.peek();
			} else {
				temp1 = new Tree(Integer.MAX_VALUE);
			}
			if (!st2.isEmpty()) {
				temp2 = st2.peek();
			} else {
				temp2 = new Tree(Integer.MAX_VALUE);
			}
			if (temp1.data + temp2.data == sum) {
				System.out.println("first : " + temp1.data + " second: " + temp2.data);
				return true;
			}
			if (temp1.data + temp2.data > sum) {
				temp1Update = false;
				temp2Update = true;
				if (!st2.isEmpty()) {
					st2.pop();
					st2.push(temp2.left);
				}
			}
			if (temp1.data + temp2.data < sum) {
				temp1Update = true;
				temp2Update = false;
				if (!st1.isEmpty()) {
					st1.pop();
					st1.push(temp1.right);
				}
			}
		}
		return false;
	}

}
