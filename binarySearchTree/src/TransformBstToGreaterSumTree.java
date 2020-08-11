package src;

public class TransformBstToGreaterSumTree {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Tree bst = new Tree(11);
		bst.left = new Tree(2);
		bst.left.left = new Tree(1);
		bst.left.right = new Tree(7);

		bst.right = new Tree(29);
		bst.right.left = new Tree(15);
		bst.right.right = new Tree(40);
		bst.right.right.left = new Tree(35);

		printTree(bst);
		transFormTree(bst);
		System.out.println("");
		printTree(bst);
	}

	private static void printTree(Tree root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.data);
		printTree(root.right);
	}

	private static void transFormTree(Tree bst) {
		if (bst == null)
			return;
		transFormTree(bst.right);
		if (max <= bst.data) {
			max = bst.data;
			bst.data = 0;
		}
		else if (max > bst.data) {
			int temp = bst.data;
			bst.data = max;
			max += temp;
		}
		transFormTree(bst.left);
	}

}
