package src;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBstFromLevelOrderTraversal {
	public static void main(String[] args) {
		int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };

		CustomTree11 root = constructTree(arr);
		printTree(root);

	}

	private static void printTree(CustomTree11 root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.data);
		printTree(root.right);
	}

	private static CustomTree11 constructTree(int[] a) {
		Queue<CustomTree11> q = new LinkedList<>();
		CustomTree11 root = new CustomTree11(a[0]);
		q.add(root);
		int i = 1;
		int n = a.length;
		while (!q.isEmpty() && i < n) {
			CustomTree11 temp = q.poll();
			if (a[i] > temp.min && a[i] < temp.data) {
				temp.left = new CustomTree11(a[i]);
				temp.left.min = temp.min;
				temp.left.max = temp.data;
				q.add(temp.left);
				i++;
			}
			if (i < n && a[i] > temp.data && a[i] < temp.max) {
				temp.right = new CustomTree11(a[i]);
				temp.right.min = temp.data;
				temp.right.max = temp.max;
				q.add(temp.right);
				i++;
			}
		}
		return root;
	}
}

class CustomTree11 {
	int min = Integer.MIN_VALUE;
	int max = Integer.MAX_VALUE;
	CustomTree11 left = null;
	CustomTree11 right = null;
	int data;

	CustomTree11(int data) {
		this.data = data;
	}
}