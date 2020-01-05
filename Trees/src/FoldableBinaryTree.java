package src;

public class FoldableBinaryTree {

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
		isFoldable(root);
	}

	public static boolean isFoldable(Tree root) {
		if (root == null) {
			return true;
		}
		return isFoldableUtil(root.left, root.right);
	}

	public static boolean isFoldableUtil(Tree leftTree, Tree rightTree) {
		if (leftTree == null && rightTree == null) {
			return true;
		}
		if ((leftTree == null && rightTree != null) || (leftTree == null && rightTree != null)) {
			return false;
		}
		return isFoldableUtil(leftTree.left, rightTree.right) && isFoldableUtil(leftTree.right, rightTree.left);
	}
}
