package src;

import java.util.*;

public class SegmentsTree {
	public static void main(String ar[]) {
		int arr[] = 
//			{ 2, 5, 3, 8, 7, 6, 9 };
				{ 1, 3, 5, 7, 9, 11, 0, 7, 9 };
		int[] segmentTree = buildTree(arr);
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.println(e);
		});
		update(arr, segmentTree, 6, 12);
		System.out.println();
		System.out.println();
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.println(e);
		});
		System.out.println();
		System.out.println(query(arr, segmentTree, 1, 4));
		System.out.println(query(arr, segmentTree, 3, 4));
		System.out.println(query(arr, segmentTree, 3, 6));
	}

	private static Integer query(int[] arr, int[] segmentTree, int i, int j) {
		return queryUtil(0, arr, segmentTree, 0, arr.length - 1, i, j);
	}

	private static int queryUtil(int index, int[] ar, int[] segmentTree, int l, int r, int i, int j) {

		if (l == r) {
			return ar[l];
		}
		if (l == i && r == j) {
			return segmentTree[index];
		}
		int left = 0, right = 0;
		int mid = l + ((r - l) / 2);
		if ((i >= l && i <= mid) || (j >= l && j <= mid)) {
			int newi = i, newj = j;
			if (i < l) {
				newi = l;
			}
			if (j > mid) {
				newj = mid;
			}
			left = queryUtil(2 * index + 1, ar, segmentTree, l, mid, newi, newj);
		}
		if ((i >= mid + 1 && i <= r) || (j >= mid + 1 && j <= r)) {
			int newi = i, newj = j;
			if (i < mid + 1) {
				newi = mid + 1;
			}
			if (j > r) {
				newj = r;
			}
			right = queryUtil(2 * index + 2, ar, segmentTree, mid + 1, r, newi, newj);
		}
		return left + right;
	}

	private static int[] buildTree(int[] arr) {
		int n = arr.length;
		int[] segmentTree = new int[2 * n - 1];
		buildTreeUtil(0, arr, segmentTree, 0, n - 1);
		return segmentTree;
	}

	private static void update(int[] ar, int[] segmentTree, int index, int update) {
		int diff = update - ar[index];
		updateUtil(0, ar, segmentTree, diff, index, 0, ar.length - 1);

	}

	private static int buildTreeUtil(int i, int[] a, int[] segmentTree, int l, int r) {
		if (l == r) {
			segmentTree[i] = a[l];
			return a[l];
		}
		int mid = l + ((r - l) / 2);
		int left = buildTreeUtil(2 * i + 1, a, segmentTree, l, mid);
		int right = buildTreeUtil(2 * i + 2, a, segmentTree, mid + 1, r);
		segmentTree[i] = left + right;
		return left + right;
	}

	private static void updateUtil(int i, int[] ar, int[] segmentTree, int diff, int index, int l, int r) {
		if (i == 0) {
			segmentTree[0] += diff;
		}
		if (l == r) {
			ar[index] = diff;
			return;
		}
		int mid = l + ((r - l) / 2);
		if (index >= l && index <= mid) {
			segmentTree[2 * i + 1] = segmentTree[2 * i + 1] + diff;
			updateUtil(2 * i + 1, ar, segmentTree, diff, index, l, mid);
		} else if (index >= (mid + 1) && index <= r) {
			segmentTree[2 * i + 2] = segmentTree[2 * i + 2] + diff;
			updateUtil(2 * i + 2, ar, segmentTree, diff, index, mid + 1, r);
		}
	}

	private static int getNextPowerOf2(int length) {
		int count = 0;
		while (length > 0) {
			count++;
			length = length / 2;
		}
		return 1 << count;
	}

}
