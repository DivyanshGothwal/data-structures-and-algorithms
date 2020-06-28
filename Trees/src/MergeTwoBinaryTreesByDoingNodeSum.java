package src;

public class MergeTwoBinaryTreesByDoingNodeSum {
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

		Tree root1 = new Tree(9);
		root1.left = new Tree(2);
		root1.right = new Tree(3);
		root1.left.left = new Tree(4);
		root1.left.right = new Tree(5);
		root1.right.right = new Tree(6);
		root1.right.right.right = new Tree(60);
		root1.right.right.left = new Tree(16);
		root1.right.right.left.right = new Tree(160);
		mergedTree(root, root1);
		inorder(root);
	}

	private static void inorder(Tree root1) {
		if (root1 == null) {
			return;
		}
		inorder(root1.left);
		System.out.println(root1.data);
		inorder(root1.right);
	}

	private static void mergedTree(Tree root1, Tree root2) {
		boolean isLeftChoosen = true;
		if (root1.left == null && root2.left != null) {
			root1.left = root2.left;
			isLeftChoosen = false;
		}
		if (root1.left == null && root2.left == null || root1.left != null && root2.left == null) {
			isLeftChoosen = false;
		}
		if (isLeftChoosen)
			mergedTree(root1.left, root2.left);

		boolean isRightChoosen = true;

		if (root1.right == null && root2.right != null) {
			root1.right = root2.right;
			isRightChoosen = false;
		}
		if (root1.right != null && root2.right == null || root1.right == null && root2.right == null) {
			isRightChoosen = false;
		}
		if (isRightChoosen)
			mergedTree(root1.right, root2.right);

		root1.data = root1.data + root2.data;
	}
}
