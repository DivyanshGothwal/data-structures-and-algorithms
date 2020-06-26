package src;

public class DepthOfAFullBinaryTreeFromPreorder {
	static int i = 1;

	static public void main(String[] args) {
		String tree = "nnnllnnllnlnllnnllnlnll";
		int n = tree.length();
		System.out.println(findDepth(tree));
		System.out.println(findDepthWithTreeCreation(tree, n));
	}

	private static Integer findDepthWithTreeCreation(String tree, int n) {
		Tree root = new Tree(1);
		i = 0;
		buildTree(root, tree);
		return parse(root);
	}

	private static Integer parse(Tree root) {
		if (root == null) {
			return -1;
		}
		int left = parse(root.left);
		int right = parse(root.right);
		return Math.max(left, right) + 1;
	}

	private static Tree buildTree(Tree root, String tree) {
		if (i >= tree.length()) {
			return null;
		}
		if (tree.charAt(i) == 'n') {
			i++;
			root.left = new Tree(i);
			buildTree(root.left, tree);
		}
		if (i < tree.length() && tree.charAt(i) == 'n') {
			i++;
			root.right = new Tree(i);
			buildTree(root.right, tree);
		} else if (i < tree.length() && tree.charAt(i) == 'l') {
			i++;
			if (i < tree.length() && tree.charAt(i) == 'n') {
				i++;
				root.right = new Tree(i);
				buildTree(root.right, tree);
			} else {
				i++;
			}
		}
		return root;
	}

	private static Integer findDepth(String tree) {
		if (i >= tree.length()) {
			return 0;
		}
		int left = 0;
		int right = 0;
		if (tree.charAt(i) == 'n') {
			i++;
			left = findDepth(tree);
		}
		if (i < tree.length() && tree.charAt(i) == 'n') {
			i++;
			right = findDepth(tree);
		} else if (i < tree.length() && tree.charAt(i) == 'l') {
			i++;
			if (i < tree.length() && tree.charAt(i) == 'n') {
				i++;
				right = findDepth(tree);
			} else {
				i++;
			}
		}
		return Math.max(left, right) + 1;
	}
}
