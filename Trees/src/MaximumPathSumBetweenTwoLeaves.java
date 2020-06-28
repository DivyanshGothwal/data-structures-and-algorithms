package src;

public class MaximumPathSumBetweenTwoLeaves {

	static Integer maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Tree root = new Tree(9);
//		root.left = new Tree(18);
//		root.left.left = new Tree(19);
//		root.left.left.left = new Tree(81);
//		root.left.left.right = new Tree(10);
//		root.left.right = new Tree(7);
//		root.left.right.left = new Tree(6);
//		root.left.right.right = new Tree(8);
//		root.right = new Tree(68);
//		root.right.left = new Tree(76);
//		root.right.right = new Tree(97);
//		root.right.right.left = new Tree(150);
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
		int sum = calculateSumPath(root, 0, 0);
		if (maxSum < sum) {
			maxSum = sum;
		}
		System.out.println(maxSum);
	}

	private static Integer calculateSumPath(Tree root, int i, int j) {
		if (root == null) {
			return 0;
		}
		int leftSum = calculateSumPath(root.left, 0, 0);
		int rightSum = calculateSumPath(root.right, 0, 0);
		if (leftSum + rightSum + root.data > maxSum) {
			maxSum = leftSum + rightSum + root.data;
		}
		return Math.max(leftSum + root.data, rightSum + root.data);
	}

}
