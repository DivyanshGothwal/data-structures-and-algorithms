package src;

public class MorrisInorderTraversal {

	public static void main(String[] args) {
		Tree root = new Tree(9);
		root.left = new Tree(18);
		root.left.left = new Tree(19);
		root.left.left.left = new Tree(81);
		root.left.left.right = new Tree(10);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(8);
		root.right = new Tree(68);
		root.right.left = new Tree(76);
		root.right.right = new Tree(97);
		root.right.right.left = new Tree(150);
		inOrder(root);
		System.out.println(" ");
		morrisInorderTraversal(root);
	}
	static void inOrder(Tree root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	static void morrisInorderTraversal(Tree root) {
		Tree tempRoot = root;
		while (tempRoot!=null) {
			if (tempRoot.left != null) {
				Tree tempRootLeft = tempRoot.left;
				while (tempRootLeft.right != null && tempRootLeft.right!=tempRoot) {
					tempRootLeft = tempRootLeft.right;
				}
				if(tempRootLeft.right == tempRoot) {
					System.out.print(tempRoot.data+" ");
					tempRoot = tempRoot.right;
					tempRootLeft.right = null;
					continue;
				}
				else {
					tempRootLeft.right = tempRoot;
				}
				tempRoot = tempRoot.left;
			} else {
				System.out.print(tempRoot.data+" ");
				tempRoot = tempRoot.right;
			}
		}
	}
}
