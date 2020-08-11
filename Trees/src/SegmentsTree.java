package src;

import java.util.*;

public class SegmentsTree {
	static int[] segmentTree;

	public static void main(String ar[]) {
		int arr[] =
//			{ 2, 5, 3, 8, 7, 6, 9 };
				{ 1, 3, 5, 7, 9, 11, 0, 7, 9 };
		int n = arr.length;
		segmentTree = new int[2 * n - 1];
		buildTree(arr);
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.print(e + " ");
		});
		update(arr, 6, 12);
		System.out.println();
		System.out.println();
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();
		System.out.println(query(arr, 1, 4));
		System.out.println(query(arr, 3, 4));
		System.out.println(query(arr, 3, 6));
	}

	private static void buildTree(int[] arr) {
		buildTree(0, arr, 0, arr.length - 1);
	}

	private static void update(int[] arr, int index, int ele) {
		int diff = ele - arr[index];
		update(0, arr, index, diff, 0, arr.length - 1);
	}

	private static int query(int[] arr, int i, int j) {
		return queryUtil(0, arr, i, j, 0, arr.length - 1);
	}

	private static int buildTree(int i, int[] arr, int l, int r) {
		if (l > r) {
			return 0;
		}
		// leaf condition
		if (l == r) {
			segmentTree[i] = arr[l];
			return segmentTree[i];
		}

		int mid = l + ((r - l) / 2);
		int left = buildTree(2 * i + 1, arr, l, mid);
		int right = buildTree(2 * i + 2, arr, mid + 1, r);
		segmentTree[i] = left + right;
		return segmentTree[i];
	}

	private static int update(int i, int[] arr, int index, int diff, int l, int r) {
		// leaf node
		if (l == r) {
			// if leaf node is of index passed update leaf nod
			if (index == l) {
				segmentTree[i] = arr[l] + diff;
			}
			return segmentTree[i];
		}
		// partial merge then go left and right
		if (index >= l && index <= r) {
			int mid = l + ((r - l) / 2);
			int left = update(2 * i + 1, arr, index, diff, l, mid);
			int right = update(2 * i + 2, arr, index, diff, mid + 1, r);
			segmentTree[i] = left + right;
			return segmentTree[i];
		}
		return segmentTree[i];
	}

	private static int queryUtil(int i, int[] arr, int startI, int endJ, int l, int r) {
		// full merge return that segment
		if (l >= startI && r <= endJ) {
			return segmentTree[i];
		}
		// partial merge then go left and right
		if (l <= endJ && r >= startI) {
			int mid = l + (r - l) / 2;
			int left = queryUtil(2 * i + 1, arr, startI, endJ, l, mid);
			int right = queryUtil(2 * i + 2, arr, startI, endJ, mid + 1, r);
			return left + right;
		}
		return 0;
	}

}
