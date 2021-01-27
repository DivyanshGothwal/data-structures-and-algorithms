package src;

public class LCA {
	public static void main(String[] ar) {
		Tree root = new Tree(9);
		root.left = new Tree(8);
		root.left.left = new Tree(19);
		root.left.left.left = new Tree(18);
		root.left.left.right = new Tree(10);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(81);
		root.right = new Tree(28);
		root.right.left = new Tree(27);
		root.right.right = new Tree(29);
		root.right.right.left = new Tree(100);
		System.out.println(findLCA(root, 81, 100).data);
	}

	public static Tree findLCA(Tree root, int i, int j) {
		if (root == null) {
			return null;
		}
		if (root.data == i || root.data == j) {
			return root;
		}
		Tree left = findLCA(root.left, i, j);
		Tree right = findLCA(root.right, i, j);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		return right;
	}
}
