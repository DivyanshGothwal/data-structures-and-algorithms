package src;

public class MaximumDifferenceBetweenNodeAndItsAncestor {
	static Integer maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Tree root = new Tree(9);
		root.left = new Tree(8);
		root.left.left = new Tree(9);
		root.left.left.left = new Tree(8);
		root.left.left.right = new Tree(10);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(8);
		root.right = new Tree(8);
		root.right.left = new Tree(7);
		root.right.right = new Tree(9);
		root.right.right.left = new Tree(10);
		findMaxDiff(root, 0);
		System.out.println(maxValue);
	}

	private static void findMaxDiff(Tree root, int max) {
		if (root == null)
			return;
		if (max != Integer.MIN_VALUE && max - root.data > maxValue) {
			maxValue = max - root.data;
		}
		if (root.data > max) {
			max = root.data;
		}
		findMaxDiff(root.left, max);
		findMaxDiff(root.right, max);
	}

}
