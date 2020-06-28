package src;

public class InorderSuccessor {

	public static void main(String ar[]) {
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
	}
}
