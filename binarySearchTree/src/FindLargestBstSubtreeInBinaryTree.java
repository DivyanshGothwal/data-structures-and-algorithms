/**
 * 
 */
package src;

public class FindLargestBstSubtreeInBinaryTree {
	static int max = 0;

	public static void main(String[] args) {
		Tree root = new Tree(50);
		root.left = new Tree(10);
		root.right = new Tree(60);
		root.left.left = new Tree(5);
		root.left.right = new Tree(20);
		root.right.left = new Tree(55);
		root.right.left.left = new Tree(45);
		root.right.right = new Tree(70);
		root.right.right.left = new Tree(65);
		root.right.right.right = new Tree(80);
		find(root);
		System.out.println(max);
	}

	private static Triplet find(Tree root) {
		if (root == null) {
			return null;
		}
		Triplet left = find(root.left);
		Triplet right = find(root.right);
		if ((left == null || left.count > 0) && (right == null || right.count > 0)) {
			if (left != null && right != null && left.max < root.data && right.min > root.data) {
				if (left.count + right.count + 1 > max) {
					max = left.count + right.count + 1;
				}
				return new Triplet(left.count + right.count + 1, left.min, right.max);
			}
			if (left != null && right == null && left.max < root.data) {
				if (left.count + 1 > max) {
					max = left.count + 1;
				}
				return new Triplet(left.count + 1, left.min, root.data);
			}
			if (right != null && left == null && right.min > root.data) {
				if (right.count + 1 > max) {
					max = right.count + 1;
				}
				return new Triplet(right.count + 1, root.data, right.max);
			}
			if (left == null && right == null) {
				if (1 > max) {
					max = 1;
				}
				return new Triplet(1, root.data, root.data);
			}
			return new Triplet(0, 0, 0);
		} else {
			return new Triplet(0, 0, 0);
		}
	}

}

class Triplet {
	Integer count;
	Integer min;
	Integer max;

	Triplet(Integer count, Integer min, Integer max) {
		this.count = count;
		this.min = min;
		this.max = max;
	}
}