package src;

import java.util.*;

//Also Known as Binary Indexed Tree
public class FenwickTree {

	public static void main(String ar[]) {
		int a[] = { 1, 3, 5, 7, 9, 11, 0, 7, 9, 4, 6, 8 };
		int[] bit = constructFenwickTree(a, a.length);
		query(7, bit);
		update(bit, 9, 5);
		Arrays.stream(bit).forEach(e -> System.out.println(e));
	}

	private static int query(int i, int[] bit) {
		i++;
		int parent = i;
		int sum = 0;
		while (parent != 0) {
			sum += bit[parent];
			parent = parent & (parent - 1);
		}
		System.out.println(sum);
		return sum;
	}

	private static int[] constructFenwickTree(int[] a, int length) {
		int tree[] = new int[length + 1];
		for (int i = 0; i < length; i++) {
			update(tree, i, a[i]);
		}
		return tree;
	}

	private static void update(int[] tree, int i, int value) {
		i++;
		while (i < tree.length) {
			tree[i] += value;
			i = getNextForUpdate(i);
		}
	}

	private static int getNextForUpdate(int i) {
		int towsComplement = (~i) + 1;
		towsComplement = towsComplement & i;
		return towsComplement + i;
	}
}