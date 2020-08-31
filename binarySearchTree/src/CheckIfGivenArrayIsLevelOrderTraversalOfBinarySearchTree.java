package src;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfGivenArrayIsLevelOrderTraversalOfBinarySearchTree {

	public static void main(String ar[]) {
		int[] a = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		check(a);
	}

	private static void check(int[] a) {
		int n = a.length;
		int value = checkUtil(a, n);
		if (value == -1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

	private static int checkUtil(int[] a, int n) {
		Queue<TreeCustom12> q = new LinkedList<>();
		q.add(new TreeCustom12(a[0]));
		int i = 1;
		int p = 0;
		while (!q.isEmpty()) {
			TreeCustom12 peek = q.poll();
			int lower = peek.lower;
			int upper = peek.upper;
			if (i < n) {
				if (p >= i) {
					return -1;
				}
				if (lower < a[i] && a[i] < peek.data) {
					TreeCustom12 left = new TreeCustom12(a[i]);
					left.upper = peek.data;
					left.lower = lower;
					q.add(left);

					i++;
				}
				if (i < n && peek.data < a[i] && a[i] < upper) {
					TreeCustom12 right = new TreeCustom12(a[i]);
					right.lower = peek.data;
					right.upper = upper;
					q.add(right);
					i++;
				}
			}
			p++;
		}
		if (i < n) {
			return -1;
		}
		return 1;
	}
}

class TreeCustom12 {
	TreeCustom12 left;
	TreeCustom12 right;
	int data;
	int lower = Integer.MIN_VALUE;
	int upper = Integer.MAX_VALUE;

	public TreeCustom12(int data) {
		this.data = data;
	}
}