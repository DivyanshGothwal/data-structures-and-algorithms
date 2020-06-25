package src;

import java.util.*;

public class DiagonalTraversalOfBinaryTree {
	public static void main(String ar[]) {
		Tree root = new Tree(9);
		root.left = new Tree(8);
		root.left.left = new Tree(9);
		root.left.left.left = new Tree(8);
		root.left.left.right = new Tree(10);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(8);
		root.right = new Tree(8);
		root.right.left = new Tree(7);
		root.right.right = new Tree(9);
		root.right.right.left = new Tree(10);
		Map<Integer, List<Integer>> map = new TreeMap<>();
		diagonalTraversal(root, map, 0);
		map.entrySet().stream().forEach(eachValue -> {
			eachValue.getValue().stream().forEach(e -> System.out.print(e+" "));
			System.out.println("for i: "+eachValue.getKey());
		});
	}

	private static void diagonalTraversal(Tree root, Map<Integer, List<Integer>> map, int i) {
		if (root == null) {
			return;
		}
		List<Integer> l = map.get(i);
		if (l == null) {
			l = new ArrayList<>();
		}
		l.add(root.data);
		map.put(i,l);
		i--;
		diagonalTraversal(root.left, map, i);
		i++;
		diagonalTraversal(root.right, map, i);
	}
}
