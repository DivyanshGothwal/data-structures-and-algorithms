package src;

public class RedBlackTreeInsertion {
	static RedBlackTree insertedNode = null;

	public static void main(String[] ar) {
		int a[] = { 10, 20, 14, 30, 6, 40, 50, 60, 45, 42,32,34,26,12 };
		RedBlackTree root = null;
		root = new RedBlackTree(null, a[0], true);
		for (int i = 1; i < a.length; i++) {
			insertInRedBlackTree(root, null, a[i]);
			root = checkAndRotate(root, insertedNode, a[i]);
		}
		traverseRedBlackTree(root);
	}

	private static void traverseRedBlackTree(RedBlackTree root) {
		if (root == null) {
			return;
		}
		traverseRedBlackTree(root.left);
		System.out.println(root.data);
		traverseRedBlackTree(root.right);
	}

	public static RedBlackTree insertInRedBlackTree(RedBlackTree currentEle, RedBlackTree parent, Integer data) {
		if (currentEle == null) {
			insertedNode = new RedBlackTree(parent, data, false);
			return insertedNode;
		}
		if (currentEle.data < data) {
			currentEle.right = insertInRedBlackTree(currentEle.right, currentEle, data);
		}
		if (currentEle.data > data) {
			currentEle.left = insertInRedBlackTree(currentEle.left, currentEle, data);
		}
		return currentEle;
	}

	private static RedBlackTree checkAndRotate(RedBlackTree root, RedBlackTree insertedNode, Integer data) {
		RedBlackTree parent = insertedNode.parent;
		RedBlackTree currentEle = insertedNode;
		while (parent != null) {
			if (!parent.colour && !currentEle.colour) {
				parent = checkAndRotateUtil(root, parent, data);
			}
			currentEle = parent;
			parent = parent.parent;
		}
		return currentEle;
	}

	private static RedBlackTree checkAndRotateUtil(RedBlackTree root, RedBlackTree currentEle, Integer data) {
		if (root == currentEle) {
			return root;
		}
		Boolean isRightChild = true;
		if (currentEle == currentEle.parent.left) {
			isRightChild = false;
		}
		if (isRightChild) {
			if (currentEle.parent.left == null || currentEle.parent.left.colour) {
				currentEle = rotate(root, isRightChild, currentEle, data);
				if (currentEle.parent != null) {
					if (currentEle.parent.data > data) {
						currentEle.parent.left = currentEle;
					} else {
						currentEle.parent.right = currentEle;
					}
				}
			} else {
				currentEle.parent.left.colour = true;
				currentEle.colour = true;
				if (currentEle.parent != root)
					currentEle.parent.colour = false;
			}
		} else {
			if (currentEle.parent.right == null || currentEle.parent.right.colour) {
				currentEle = rotate(root, isRightChild, currentEle, data);
				if (currentEle.parent != null) {
					if (currentEle.parent.data > data) {
						currentEle.parent.left = currentEle;
					} else {
						currentEle.parent.right = currentEle;
					}
				}
			} else {
				currentEle.parent.right.colour = true;
				currentEle.colour = true;
				if (currentEle.parent != root)
					currentEle.parent.colour = false;
			}
		}
		return currentEle;
	}

	private static RedBlackTree rotate(RedBlackTree root, Boolean isRightChild, RedBlackTree currentEle, int data) {
		if (currentEle.data > data && !isRightChild) {
			return rightRotation(currentEle.parent);
		}
		if (currentEle.data > data && isRightChild) {
			currentEle = rightRotation(currentEle);
			currentEle.parent.right = currentEle;
			return leftRotation(currentEle.parent);
		}
		if (currentEle.data < data && !isRightChild) {
			currentEle = leftRotation(currentEle);
			currentEle.parent.left = currentEle;
			return rightRotation(currentEle.parent);
		}
		if (currentEle.data < data && isRightChild) {
			return leftRotation(currentEle.parent);
		}
		return currentEle;
	}

	private static RedBlackTree leftRotation(RedBlackTree currentEle) {
		RedBlackTree right = currentEle.right;
		RedBlackTree rightLeft = right.left;
		// change parent
		RedBlackTree currentParent = currentEle.parent;
		currentEle.parent = right;
		right.parent = currentParent;
		if (rightLeft != null) {
			rightLeft.parent = currentEle;
		}
		// change pointers;
		right.left = currentEle;
		currentEle.right = rightLeft;
		// switch colours
		Boolean rightColour = right.colour;
		right.colour = currentEle.colour;
		currentEle.colour = rightColour;
		return right;
	}

	private static RedBlackTree rightRotation(RedBlackTree currentEle) {
		RedBlackTree left = currentEle.left;
		RedBlackTree leftRight = left.right;
		// change parent
		RedBlackTree currentParent = currentEle.parent;
		currentEle.parent = left;
		left.parent = currentParent;
		if (leftRight != null) {
			leftRight.parent = currentEle;
		}
		// switch pointers
		left.right = currentEle;
		currentEle.left = leftRight;
		// switch colours
		Boolean leftColour = left.colour;
		left.colour = currentEle.colour;
		currentEle.colour = leftColour;
		return left;
	}
}

class RedBlackTree {
	// true means black colour
	// false means red colour
	Boolean colour = false;
	Integer data;
	RedBlackTree left, right, parent;

	RedBlackTree(RedBlackTree parent, Integer data, Boolean colour) {
		this.parent = parent;
		this.data = data;
		this.colour = colour;
	}

	RedBlackTree(Integer data, Boolean colour) {
		this.data = data;
		this.colour = colour;
	}

	RedBlackTree(Integer data) {
		this.data = data;
	}

}