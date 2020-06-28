package src;

public class ReplaceNodeWithInorderSuccessorAndPredecessor {

	public static void main(String[] args) {
		TreeCustom root = new TreeCustom(9);
		root.left = new TreeCustom(18);
		root.left.left = new TreeCustom(19);
		root.left.left.left = new TreeCustom(81);
		root.left.left.right = new TreeCustom(10);
		root.left.right = new TreeCustom(7);
		root.left.right.left = new TreeCustom(6);
		root.left.right.right = new TreeCustom(8);
		root.right = new TreeCustom(68);
		root.right.left = new TreeCustom(76);
		root.right.right = new TreeCustom(97);
		root.right.right.left = new TreeCustom(150);
		populateInOrderSuccessorAndPredessor(root);
	}

	static void populateInOrderSuccessorAndPredessor(TreeCustom root) {
		TreeCustom[] inOrderSucc = new TreeCustom[100];
		TreeCustom[] inOrderPred = new TreeCustom[100];
		calculateInOrderSucc(root, inOrderSucc);
		calculateInOrderPred(root, inOrderPred);
		dfs(root);
		System.out.println(" line ");
		dfsCustom(root);
		System.out.println(" line ");
		dfs(root);
	}
	static void dfsCustom(TreeCustom root) {
		if(root==null)
			return;
		dfsCustom(root.left);
		root = new TreeCustom((root.next==null ? 0:root.next.data)+(root.prev == null ?0:root.prev.data), root.left, root.right);
		System.out.println(root.data+" next :"+(root.next==null ? 0:root.next.data)+" prev: "+(root.prev == null ?0:root.prev.data));
//		System.out.print(root.data+" ");
		dfsCustom(root.right);
	}
	
	static void dfs(TreeCustom root) {
		if(root==null)
			return;
		dfs(root.left);
		System.out.println(root.data+" next :"+(root.next==null ? 0:root.next.data)+" prev: "+(root.prev == null ?0:root.prev.data));
//		root.data = (root.next==null ? 0:root.next.data)+(root.prev == null ?0:root.prev.data);
		dfs(root.right);
	}
	static TreeCustom succ = null;

	static TreeCustom pred = null;

	private static void calculateInOrderSucc(TreeCustom root, TreeCustom[] inOrderSucc) {
		if (root == null)
			return;
		calculateInOrderSucc(root.right, inOrderSucc);
		root.next = succ;
		succ = root;
		calculateInOrderSucc(root.left, inOrderSucc);
	}

	private static void calculateInOrderPred(TreeCustom root, TreeCustom[] inOrderPred) {
		if (root == null)
			return;
		calculateInOrderPred(root.left, inOrderPred);
		root.prev = pred;
		pred = root;
		calculateInOrderPred(root.right, inOrderPred);
	}
}
