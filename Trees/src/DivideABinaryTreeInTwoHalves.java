package src;

public class DivideABinaryTreeInTwoHalves {

	public static void main(String ar[]) {
		TreeModified root = new TreeModified(5);
		root.left = new TreeModified(1);
		root.left.left = new TreeModified(3);
		root.left.right = new TreeModified(10);
		root.left.right.left = new TreeModified(11);
		root.left.right.left.left = new TreeModified(12);
		root.left.right.right = new TreeModified(13);

		root.right = new TreeModified(6);
		root.right.left = new TreeModified(7);
		root.right.right = new TreeModified(4);
		root.right.right.left = new TreeModified(4);
		getSize(root);
		System.out.println(isPossible(root, 0));
	}

	private static Boolean isPossible(TreeModified root, int upper) {
		if (root == null) {
			return false;
		}
		Boolean isPossible = false;
		int leftSize = root.leftSize;
		int rightSize = root.rightSize;
		if ((root.left != null && root.right != null) && leftSize + rightSize + 1 == upper) {
			return true;
		}
		if (root.right == null && (leftSize + 1 == upper || leftSize == upper + 1)) {
			return true;
		}
		if (root.left == null && (rightSize + 1 == upper || rightSize == upper + 1)) {
			return true;
		}
		Boolean left = isPossible(root.left, rightSize + 1 + upper);
		if (left)
			return true;
		Boolean right = isPossible(root.right, leftSize + 1 + upper);
		return left || right || isPossible;
	}

	private static int getSize(TreeModified root) {
		if (root == null) {
			return 0;
		}
		int left = getSize(root.left);
		int right = getSize(root.right);
		root.leftSize = left;
		root.rightSize = right;
		return left + right + 1;
	}

}

class TreeModified extends Tree {
	int leftSize;
	int rightSize;
	int upper;
	TreeModified left;
	TreeModified right;

	TreeModified(int data) {
		super(data);
	}

}