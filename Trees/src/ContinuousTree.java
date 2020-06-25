package src;

public class ContinuousTree {
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
		System.out.println(inOrderTraversal(root));
	}
	public static boolean inOrderTraversal(Tree root){
		if(root==null)
			return true;
		boolean left = inOrderTraversal(root.left);
		boolean right = inOrderTraversal(root.right);
		boolean leftEle = false;
		boolean rightEle = false;
		if(root.left==null || Math.abs(root.data-root.left.data)==1) {
			leftEle = true;
		}
		if(root.right==null || Math.abs(root.data-root.right.data)==1) {
			rightEle = true;
		}
		return rightEle && leftEle && right && left;
	}
	
}
