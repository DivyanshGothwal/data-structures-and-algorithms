package src;

public class ConstructBSTFromPreorderTraversal {
	static int i = 0;

	public static void main(String[] ar) {
		int a[] = { 20, 10, 5, 2, 15, 13, 50, 40, 30, 35, 80, 59, 81 };

		Tree root = constructBinarySearchTree(a);
		printTree(root);
	}

	private static void printTree(Tree root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.data);
		printTree(root.right);
	}

	private static Tree constructBinarySearchTree(int[] a) {
		return binarySearchTreeUtil(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static Tree binarySearchTreeUtil(int[] a, int minValue, int maxValue) {
		int n = a.length;
		if (i >= n || a[i] >= maxValue || a[i] <= minValue) {
			i--;
			return null;
		}
		int currVal = a[i];
		Tree root = new Tree(currVal);
		i++;
		root.left = binarySearchTreeUtil(a, minValue, currVal);
		i++;
		root.right = binarySearchTreeUtil(a, currVal, maxValue);
		return root;
	}
}
