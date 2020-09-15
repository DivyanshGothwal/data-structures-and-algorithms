package src;

public class SegmentsTree {
	static int[] segmentTree;

	public static void main(String ar[]) {
		int arr[] = 
//			{ 2, 5, 3, 8, 7, 6, 9 };
				{ 1, 3, 5, 7, 9, 11 };
		int n = arr.length;

		segmentTree = new int[calculateSizeOfTree(2 * n - 1)];
		buildTree(arr, n);
		System.out.println(arr);
		System.out.println(query(arr, n, 1, 4));
		update(arr, 3, 4, n);
		System.out.println(query(arr, n, 1, 4));
		update(arr, 3, 10, n);
		System.out.println(query(arr, n, 1, 4));
	}

	public static Integer calculateSizeOfTree(int n) {
		int i = 0;
		while (n != 0) {
			i++;
			n = n >> 1;
		}
		return 1 << i;
	}

	public static void buildTree(int[] arr, int n) {
		build(0, arr, 0, n - 1);
	}

	public static Integer build(int i, int ar[], int l, int r) {
		if (l > r) {
			return Integer.MIN_VALUE;
		}
		if (l == r) {
			segmentTree[i] = ar[l];
			return ar[l];
		}
		int mid = l + (r - l) / 2;
		int left = build(2 * i + 1, ar, l, mid);
		int right = build(2 * i + 2, ar, mid + 1, r);
		segmentTree[i] = Math.max(left, right);
		return segmentTree[i];
	}

	public static Integer query(int[] ar, int n, int s, int e) {
		return queryUtil(ar, 0, s, e, 0, n - 1);
	}

	public static Integer queryUtil(int ar[], int i, int s, int e, int l, int r) {
		// no overlap
		if (r < s || l > e) {
			return Integer.MIN_VALUE;
		}
		// full overlap
		if (s <= l && r <= e) {
			return segmentTree[i];
		}

		int mid = l + (r - l) / 2;
		// partial overlap
		Integer left = queryUtil(ar, 2 * i + 1, s, e, l, mid);
		Integer right = queryUtil(ar, 2 * i + 2, s, e, mid + 1, r);
		return Math.max(left, right);
	}

	public static void update(int[] ar, int i, int value, int n) {
		ar[i] = value;
		updateUtil(ar, i, 0, 0, n - 1);
	}

	public static Integer updateUtil(int[] ar, int idx, int i, int l, int r) {
		// full overlap
		if (l == idx && l == r) {
			segmentTree[i] = ar[idx];
			return ar[idx];
		}
		// no overlap
		if (idx < l || idx > r) {
			return segmentTree[i];
		}
		// partial overlap
		int mid = l + (r - l) / 2;
		int left = updateUtil(ar, idx, 2 * i + 1, l, mid);
		int right = updateUtil(ar, idx, 2 * i + 2, mid + 1, r);
		int max = Math.max(left, right);
		segmentTree[i] = max;
		return max;
	}
}
