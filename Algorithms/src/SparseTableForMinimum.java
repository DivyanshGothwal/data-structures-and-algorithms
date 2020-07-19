package src;
//import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class SparseTableForMinimum {
	public static void main(String ar[]) {
		int arr[] = { 7, 2, 3, 5, 10, 4, 12, 18, 2 };
		int[][] table1 = createNewTable(arr);

		System.out.println(query1(3, 4, table1, arr));
		System.out.println(query1(2, 7, table1, arr));
	}

	private static int query1(int i, int j, int[][] table1, int[] arr) {
		int size = j - i + 1;
		int count = 0;
		List<Integer> a = new ArrayList<>();
		while (size > 0) {
			count++;
			int mod = size % 2;
			a.add(mod);
			size = size / 2;
		}
		int currMin = Integer.MAX_VALUE;
		int nextIndex = i;
		for (int p = count - 1; p >= 0; p--) {
			if (a.get(p) == 1) {
				int o = 1 << p;
				currMin = Math.min(currMin, arr[table1[nextIndex][log2(o)]]);
				nextIndex = nextIndex + o;
			}
		}
		return currMin;
	}

	private static int[][] createNewTable(int[] arr) {
		int n = arr.length;
		int[][] table = new int[n + 1][log2(n) + 1];
		for (int i = 0; i < n; i++) {
			table[i][0] = i;
		}
		System.out.println(log2(n) + " " + (1 << 3));
		for (int j = 1; j <= log2(n); j++) {
			int size = 1 << j;
			for (int i = 0; i < n; i++) {
				int indexToTake = i + (size / 2);
				if (indexToTake < n && i + size <= n) {
					table[i][j] = arr[table[i][j - 1]] > arr[table[indexToTake][j - 1]] ? table[indexToTake][j - 1]
							: table[i][j - 1];
				}
			}
		}
		return table;
	}

	public static int log2(int x) {
		return (int) (Math.log(x) / Math.log(2));
	}
}
