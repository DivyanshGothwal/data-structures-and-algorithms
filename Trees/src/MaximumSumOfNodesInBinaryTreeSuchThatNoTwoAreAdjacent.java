package src;

public class MaximumSumOfNodesInBinaryTreeSuchThatNoTwoAreAdjacent {

	public static void main(String[] args) {
		Tree root = new Tree(9);
		root = new Tree(-15);
		root.left = new Tree(5);
		root.right = new Tree(6);
		root.left.left = new Tree(-8);
		root.left.right = new Tree(1);
		root.left.left.left = new Tree(2);
		root.left.left.right = new Tree(6);
		root.right.left = new Tree(3);
		root.right.right = new Tree(9);
		root.right.right.right = new Tree(0);
		root.right.right.right.left = new Tree(4);
		root.right.right.right.right = new Tree(-1);
		root.right.right.right.right.left = new Tree(10);
		System.out.println(findMaxSum(root));
	}

	private static Integer findMaxSum(Tree root) {
		if (root == null)
			return 0;
		int left = findMaxSum(root.left);
		int right = findMaxSum(root.right);
		return Math.max(left + right, root.data);
	}

}
