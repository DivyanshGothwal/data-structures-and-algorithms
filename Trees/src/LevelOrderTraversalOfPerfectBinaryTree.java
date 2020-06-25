package src;

import java.util.*;

public class LevelOrderTraversalOfPerfectBinaryTree {
	public static void main(String ar[]) {
		Tree root = new Tree(9);
		root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);

		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);

		root.left.left.left = new Tree(8);
		root.left.left.right = new Tree(9);
		root.left.right.left = new Tree(10);
		root.left.right.right = new Tree(11);
		root.right.left.left = new Tree(12);
		root.right.left.right = new Tree(13);
		root.right.right.left = new Tree(14);
		root.right.right.right = new Tree(15);

		root.left.left.left.left = new Tree(16);
		root.left.left.left.right = new Tree(17);
		root.left.left.right.left = new Tree(18);
		root.left.left.right.right = new Tree(19);
		root.left.right.left.left = new Tree(20);
		root.left.right.left.right = new Tree(21);
		root.left.right.right.left = new Tree(22);
		root.left.right.right.right = new Tree(23);
		root.right.left.left.left = new Tree(24);
		root.right.left.left.right = new Tree(25);
		root.right.left.right.left = new Tree(26);
		root.right.left.right.right = new Tree(27);
		root.right.right.left.left = new Tree(28);
		root.right.right.left.right = new Tree(29);
		root.right.right.right.left = new Tree(30);
		root.right.right.right.right = new Tree(31);
		levelOrderOfPerfectBinaryTree(root);
	}

	private static void levelOrderOfPerfectBinaryTree(Tree root) {
		Queue<Tree> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int size = 0;
		System.out.println(root.data);
		List<Integer> ar = new ArrayList<>();
		while (!q.isEmpty()) {
			Tree qTop = q.remove();
			if (qTop != null) {
				if (qTop.left != null) {
					q.add(qTop.left);
					ar.add(qTop.left.data);
				}
				if (qTop.right != null) {
					q.add(qTop.right);
					ar.add(qTop.right.data);
				}

			} else if (!q.isEmpty()) {
				printEle(ar, size);
				size = ar.size();
				System.out.println();
				q.add(null);
			}
		}
	}

	private static void printEle(List<Integer> ar, int i) {
		int j = ar.size() - 1;
		while (i < j) {
			System.out.print(ar.get(i) + " ");
			System.out.print(ar.get(j) + " ");
			i++;
			j--;
		}
		if (i == j) {
			System.out.print(ar.get(i) + " ");
		}
	}
}

//16 31 17 30 18 29 19 28 20 27 21 26  22 25 23 24
