package src;

import java.util.Arrays;

public class SegmentTreeWithLazyPopulation {
	static int[] segmentTree = null;
	static int[] lazy = null;

	public static void main(String[] ar) {

		int arr[] =
//			{ 2, 5, 3, 8, 7, 6, 9 };
				{ 1, 3, 5, 7, 9, 11, 0, 7, 9 };
		segmentTree = buildTree(arr);
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.println(e);
		});

		System.out.println();
		update(arr, 0, 4, 10);
		System.out.println();
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();
		Arrays.stream(lazy).forEach(e -> {
			System.out.print(e + " ");
		});

		System.out.println();
		query(arr, 1, 3);
		System.out.println();
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();
		Arrays.stream(lazy).forEach(e -> {
			System.out.print(e + " ");
		});
		
		
		System.out.println();
		update(arr, 3, 6, 6);
		System.out.println();
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();
		Arrays.stream(lazy).forEach(e -> {
			System.out.print(e + " ");
		});
//
		System.out.println();
		query(arr, 1, 3);
		System.out.println();
		update(arr, 6, 8, 4);
		System.out.println();
		Arrays.stream(segmentTree).forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();
		Arrays.stream(lazy).forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println();
		query(arr, 1, 3);
	}

	private static void query(int[] ar, int i, int j) {
		System.out.println(queryUtil(0, ar, i, j, 0, ar.length - 1));
	}

	private static Integer queryUtil(int i, int[] ar, int startI, int startJ, int l, int r) {
		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		if (lazy[i] != Integer.MAX_VALUE) {
			if (l != r) {
				lazy[2 * i + 1] = (lazy[2 * i + 1] == Integer.MAX_VALUE ? 0 : lazy[2 * i + 1]) + lazy[i];
				lazy[2 * i + 2] = (lazy[2 * i + 2] == Integer.MAX_VALUE ? 0 : lazy[2 * i + 2]) + lazy[i];
			}
			segmentTree[i] += lazy[i];
			lazy[i] = Integer.MAX_VALUE;
		}
		// out of range segment
		if (startJ < l || r < startI) {
			return Integer.MAX_VALUE;
		}
		// inside full range segment
		if (startI <= l && startJ >= r) {
			return segmentTree[i];
		}

		int mid = l + (r - l) / 2;
		left = queryUtil(2 * i + 1, ar, startI, startJ, l, mid);
		right = queryUtil(2 * i + 2, ar, startI, startJ, mid + 1, r);
		return Math.min(left, right);
	}

	private static void update(int[] ar, int i, int j, int k) {
		updateUtil(0, ar, i, j, k, 0, ar.length - 1);
	}

	private static int updateUtil(int i, int[] ar, int startI, int startJ, int k, int l, int r) {
		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

		// check if any update in past not applied to this node
		if (lazy[i] != Integer.MAX_VALUE) {
			// if not applied then apply and set children as lazy
			if ((2 * i + 1) < lazy.length)
				lazy[2 * i + 1] = (lazy[2 * i + 1] == Integer.MAX_VALUE ? 0 : lazy[2 * i + 1]) + lazy[i];
			if ((2 * i + 2) < lazy.length)
				lazy[2 * i + 2] = (lazy[2 * i + 2] == Integer.MAX_VALUE ? 0 : lazy[2 * i + 2]) + lazy[i];
			segmentTree[i] += lazy[i];
			lazy[i] = Integer.MAX_VALUE; // resent lazy for current element
		}

		// out of range condition
		if (r < startI || startJ < l) {
			return segmentTree[i];
		}
		// full in range condition
		if (startI <= l && startJ >= r) {
			// as now it is in full range so add children as lazy
			if ((2 * i + 1) < lazy.length)
				lazy[2 * i + 1] = (lazy[2 * i + 1] == Integer.MAX_VALUE ? 0 : lazy[2 * i + 1]) + k;
			if ((2 * i + 2) < lazy.length)
				lazy[2 * i + 2] = (lazy[2 * i + 2] == Integer.MAX_VALUE ? 0 : lazy[2 * i + 2]) + k;

			// add current values to k and return it children will be updated lazily
			segmentTree[i] += k;
			return segmentTree[i];
		}
		int mid = l + (r - l) / 2;
		left = updateUtil(2 * i + 1, ar, startI, startJ, k, l, mid);
		right = updateUtil(2 * i + 2, ar, startI, startJ, k, mid + 1, r);
		segmentTree[i] = Math.min(left, right);
		return segmentTree[i];
	}

	private static int[] buildTree(int[] ar) {
		int[] segmentTree = new int[2 * ar.length - 1];
		lazy = new int[2 * ar.length - 1];
		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
			lazy[i] = Integer.MAX_VALUE;
		}
		buildTreeUtil(0, ar, segmentTree, 0, ar.length - 1);
		return segmentTree;
	}

	private static int buildTreeUtil(int i, int[] ar, int[] segmentTree, int l, int r) {
		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		if (l > r) {
			return Integer.MAX_VALUE;
		}
		if (l == r) {
			segmentTree[i] = ar[l];
			return ar[l];
		}
		int mid = l + (r - l) / 2;
		left = buildTreeUtil(2 * i + 1, ar, segmentTree, l, mid);
		right = buildTreeUtil(2 * i + 2, ar, segmentTree, mid + 1, r);
		segmentTree[i] = Math.min(left, right);
		return segmentTree[i];
	}
}
