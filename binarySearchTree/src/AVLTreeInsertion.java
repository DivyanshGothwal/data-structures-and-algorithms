package src;

public class AVLTreeInsertion {

	static Boolean isHeightDisturbed = false;

	public static void main(String ar[]) {
		AvlTree root = new AvlTree(50);
		root = insertAvlTree(root, null, 40);
		root = insertAvlTree(root, null, 30);
		root = insertAvlTree(root, null, 60);
		root = insertAvlTree(root, null, 70);
		root = insertAvlTree(root, null, 55);
		root = insertAvlTree(root, null, 35);
		System.out.println();
	}

	public static AvlTree insertAvlTree(AvlTree root, AvlTree parent, Integer data) {
		if (root == null) {
			return new AvlTree(data);
		}
		Integer leftHeight = 0;
		
		if (root.data > data) {
			root.height += 1;
			root.left = insertAvlTree(root.left, root, data);
		}
		if (root.data < data) {
			root.height += 1;
			root.right = insertAvlTree(root.right, root, data);
		}
		if (root.left != null) {
			leftHeight = root.left.height;
		}
		Integer rightHeight = 0;
		if (root.right != null) {
			rightHeight = root.right.height;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return performRotation(root, data);
		}
		return root;
	}

	private static AvlTree performRotation(AvlTree root, Integer data) {
		if (root.data > data) {
			if (root.left.data > data) {
				return rightRotation(root);
			} else {
				return leftRightRotation(root);
			}
		} else {
			if (root.right.data < data) {
				return leftRotation(root);
			} else {
				return rightLeftRotation(root);
			}
		}
	}

	private static AvlTree rightLeftRotation(AvlTree root) {
		root.right = rightRotation(root.right);
		return leftRotation(root);
	}

	private static AvlTree leftRotation(AvlTree root) {
		AvlTree right = root.right;
		AvlTree rightLeft = root.right.left;
		right.left = root;
		root.right = rightLeft;
		root.height = getHeight(root);
		right.height = getHeight(right);
		return right;
	}

	private static AvlTree leftRightRotation(AvlTree root) {
		root.left = leftRotation(root.left);
		return rightRotation(root);
	}

	private static AvlTree rightRotation(AvlTree root) {
		AvlTree left = root.left;
		AvlTree leftRight = left.right;
		left.right = root;
		root.left = leftRight;
		root.height = getHeight(root);
		left.height = getHeight(left);
		return left;
	}

	private static Integer getHeight(AvlTree root) {
		Integer leftHeight = 0;
		if (root.left != null) {
			leftHeight = root.left.height;
		}
		Integer rightHeight = 0;
		if (root.right != null) {
			rightHeight = root.right.height;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

class AvlTree {
	Integer height = 1;
	AvlTree left;
	AvlTree right;
	Integer data;

	AvlTree(Integer data) {
		this.data = data;
	}
}
