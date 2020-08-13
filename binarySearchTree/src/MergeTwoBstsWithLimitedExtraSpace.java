package src;

import java.util.Stack;

public class MergeTwoBstsWithLimitedExtraSpace {

	public static void main(String[] args) {
		Tree bst = new Tree(5);
//		bst.left = new Tree(2);
//		bst.left.left = new Tree(1);
//		bst.left.right = new Tree(7);
//
//		bst.right = new Tree(29);
//		bst.right.left = new Tree(15);
//		bst.right.right = new Tree(40);
//		bst.right.right.left = new Tree(35);

		bst.left = new Tree(3);
		bst.left.left = new Tree(2);
		bst.left.right = new Tree(4);

		bst.right = new Tree(6);

		Tree bst1 = new Tree(2);
//		bst1.left = new Tree(6);
//		bst1.left.left = new Tree(3);
//		bst1.left.left.left = new Tree(-2);
//		bst1.left.left.left.right = new Tree(-1);
//		bst1.left.left.left.left = new Tree(-3);
//		bst1.left.right = new Tree(9);
//		bst1.left.right.left = new Tree(8);
//		bst1.left.right.right = new Tree(10);
//
//		bst1.right = new Tree(25);
//		bst1.right.left = new Tree(20);
//		bst1.right.left.left = new Tree(18);
//		bst1.right.right = new Tree(50);
//		bst1.right.right.left = new Tree(45);
//		bst1.right.right.right = new Tree(55);

		bst1.left = new Tree(1);
		bst1.right = new Tree(3);
		bst1.right.right = new Tree(7);
		bst1.right.right.left = new Tree(6);
//		bst1.left.left.left.left = new Tree(-3);
//		bst1.left.right = new Tree(9);
//		bst1.left.right.left = new Tree(8);
//		bst1.left.right.right = new Tree(10);
//
//		bst1.right = new Tree(25);
//		bst1.right.left = new Tree(20);
//		bst1.right.left.left = new Tree(18);
//		bst1.right.right = new Tree(50);
//		bst1.right.right.left = new Tree(45);
//		bst1.right.right.right = new Tree(55);

//		iterativeInorderTraversal(bst1);
//		System.out.println();
//		iterativePostorderTraversal(bst1);

		System.out.println();
		mergeBst(bst, bst1);
	}

	private static void iterativePostorderTraversal(Tree root) {
		Stack<Tree> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			Tree temp = st.peek();
			if (temp == null) {
				st.pop();
				if (st.empty())
					break;
				Tree temp1 = st.peek();
				System.out.println(temp1.data);
				st.pop();
				if (st.empty())
					break;
				temp = st.peek();
				while (temp.right == temp1) {
					st.pop();
					if (st.empty())
						break;
					temp1 = temp;
					System.out.println(temp.data);
					temp = st.peek();
				}
			} else {
				while (temp.left != null) {
					st.push(temp.left);
					temp = temp.left;
				}
			}
			if (st.empty()) {
				System.out.println(temp.data);
				break;
			}
			st.push(temp.right);
		}
	}

	private static void iterativeInorderTraversal(Tree root) {
		Stack<Tree> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			Tree temp = st.peek();
			if (temp == null) { // this null indicates that left child is done dont got to left child again
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
			System.out.println(temp.data);
			st.pop();
			st.push(temp.right);
		}
	}

	private static void mergeBst(Tree bst, Tree bst1) {
		Stack<Tree> st = new Stack<>();
		Stack<Tree> st1 = new Stack<>();
		st.push(bst);
		st1.push(bst1);
		Boolean treeUpdated = true;
		Boolean tree1Updated = true;
		while (!st.isEmpty() || !st1.isEmpty()) {
			Tree temp = null;
			Tree temp1 = null;
			if (!st.isEmpty()) {
				temp = st.peek();
			} else {
				temp = new Tree(Integer.MAX_VALUE);
			}
			if (!st1.isEmpty()) {
				temp1 = st1.peek();
			} else {
				temp1 = new Tree(Integer.MAX_VALUE);
			}
			if (temp == null && !st.isEmpty())
				st.pop();
			if (temp1 == null && !st1.isEmpty())
				st1.pop();
			if (!(temp == null && temp1 == null)) {
				while ((treeUpdated  && temp!=null && temp.left != null) || (tree1Updated && temp1!=null && temp1.left != null)) {
					if (treeUpdated  && temp!=null && temp.left != null) {
						st.push(temp.left);
						temp = temp.left;
					}
					if (tree1Updated  && temp1!=null && temp1.left != null) {
						st1.push(temp1.left);
						temp1 = temp1.left;
					}
				}
			}
			if (st1.isEmpty() && st.isEmpty())
				break;
			if (!st.isEmpty()) {
				temp = st.peek();
			} else {
				temp = new Tree(Integer.MAX_VALUE);
			}
			if (!st1.isEmpty()) {
				temp1 = st1.peek();
			} else {
				temp1 = new Tree(Integer.MAX_VALUE);
			}
			if (temp.data < temp1.data) {
				System.out.println(temp.data);
				if (!st.isEmpty()) {
					st.pop();
					st.push(temp.right);
				}
				treeUpdated = true;
				tree1Updated = false;
			} else if (temp.data > temp1.data) {
				System.out.println(temp1.data);
				if (!st1.isEmpty()) {
					st1.pop();
					st1.push(temp1.right);
				}
				treeUpdated = false;
				tree1Updated = true;
			} else {
				System.out.println(temp1.data);
				if (!st1.isEmpty()) {
					st1.pop();
					st1.push(temp1.right);
				}

				System.out.println(temp.data);
				if (!st.isEmpty()) {
					st.pop();
					st.push(temp.right);
				}
				treeUpdated = true;
				tree1Updated = true;
			}
		}
	}

}
