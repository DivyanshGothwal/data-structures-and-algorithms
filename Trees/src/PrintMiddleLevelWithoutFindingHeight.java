package src;

public class PrintMiddleLevelWithoutFindingHeight {

	public static void main(String[] ar) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.left.left = new Tree(4);
		root.left.left.left = new Tree(8);
		root.left.left.left.left = new Tree(16);
		root.left.left.left.left = new Tree(17);
		root.left.left.right = new Tree(9);
		root.left.left.right.left = new Tree(18);
		root.left.left.right.right = new Tree(19);

		root.left.right = new Tree(5);
		root.left.right.left = new Tree(10);
		root.left.right.left.left = new Tree(20);
		root.left.right.left.right = new Tree(21);
		root.left.right.right = new Tree(11);
		root.left.right.right.left = new Tree(22);
		root.left.right.right.right = new Tree(23);

		root.right = new Tree(3);
		root.right.left = new Tree(6);
		root.right.left.left = new Tree(12);
		root.right.left.left.left = new Tree(24);
		root.right.left.left.right = new Tree(25);
		root.right.left.right = new Tree(13);
		root.right.left.right.left = new Tree(26);
		root.right.left.right.right = new Tree(27);

		root.right.right = new Tree(7);
		root.right.right.left = new Tree(14);
		root.right.right.left.left = new Tree(28);
		root.right.right.left.right = new Tree(29);
		root.right.right.right = new Tree(15);
		root.right.right.right.left = new Tree(30);
		root.right.right.right.right = new Tree(31);

		printMiddle(root, root);
	}

	private static void printMiddle(Tree slow, Tree fast) {
		if (fast == null || fast.left == null || fast.right == null) {
			System.out.println(slow.data);
			return;
		}
		printMiddle(slow.left, fast.left.left);
		printMiddle(slow.right, fast.right.right);
	}
}
