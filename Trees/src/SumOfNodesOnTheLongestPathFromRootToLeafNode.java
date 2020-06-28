package src;

public class SumOfNodesOnTheLongestPathFromRootToLeafNode {

	static Integer maxLength = 0;
	static Integer maxSum = Integer.MIN_VALUE;

	public static void main(String[] a) {
		TreeCustom root = new TreeCustom(9);
		root.left = new TreeCustom(18);
		root.left.left = new TreeCustom(19);
		root.left.left.left = new TreeCustom(81);
		root.left.left.right = new TreeCustom(10);
		root.left.right = new TreeCustom(7);
		root.left.right.left = new TreeCustom(6);
		root.left.right.right = new TreeCustom(8);
		root.right = new TreeCustom(68);
		root.right.left = new TreeCustom(76);
		root.right.right = new TreeCustom(97);
		root.right.right.left = new TreeCustom(150);
		calculateSum(root, 0, 0);
		System.out.println(maxSum);
	}

	private static void calculateSum(TreeCustom root, int length, int i) {
		if (maxLength <= length) {
			if (maxSum <= i) {
				maxSum = i;
			}
		}
		if (root == null) {
			return;
		}
		calculateSum(root.left, length + 1, i + root.data);
		calculateSum(root.right, length + 1, i + root.data);
	}
}
