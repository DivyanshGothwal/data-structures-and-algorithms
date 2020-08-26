package src;

public class ThreadedBinaryTree {

	private static ThreadedBinaryCustomTree successor = null;

	public static void main(String ar[]) {
		ThreadedBinaryCustomTree root = new ThreadedBinaryCustomTree(50);
		root.left = new ThreadedBinaryCustomTree(10);
		root.right = new ThreadedBinaryCustomTree(60);
		root.left.left = new ThreadedBinaryCustomTree(5);
		root.left.right = new ThreadedBinaryCustomTree(20);
		root.right.left = new ThreadedBinaryCustomTree(55);
		root.right.left.left = new ThreadedBinaryCustomTree(45);
		root.right.right = new ThreadedBinaryCustomTree(70);
		root.right.right.right = new ThreadedBinaryCustomTree(80);
		convertToThreadedBinaryTree(root);
		traverse(root);
	}

	private static void traverse(ThreadedBinaryCustomTree root) {
		ThreadedBinaryCustomTree temp = root;
		while (temp.left != null) {
			temp = temp.left;
		}
		while (temp != null) {
			System.out.println(temp.data);
			ThreadedBinaryCustomTree temp1 = temp.right;
			if (!temp.isThreaded) {
				while (temp1.left != null) {
					temp1 = temp1.left;
				}
			}
			temp = temp1;
		}
	}

	private static void convertToThreadedBinaryTree(ThreadedBinaryCustomTree root) {
		if (root == null) {
			return;
		}
		convertToThreadedBinaryTree(root.right);
		if (root.right == null) {
			root.right = successor;
			root.isThreaded = true;
		}
		successor = root;
		convertToThreadedBinaryTree(root.left);
	}
}

class ThreadedBinaryCustomTree {
	ThreadedBinaryCustomTree left, right;
	boolean isThreaded;
	int data;

	ThreadedBinaryCustomTree(int data) {
		this.data = data;
	}
}