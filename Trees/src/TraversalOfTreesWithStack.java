package src;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class TraversalOfTreesWithStack {

	public static void main(String[] args) {
		Tree root = new Tree(9);
		root.left = new Tree(18);
		root.left.left = new Tree(19);
		root.left.left.left = new Tree(81);
		root.left.left.right = new Tree(10);
		root.left.right = new Tree(7);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(8);
		root.right = new Tree(68);
		root.right.left = new Tree(76);
		root.right.right = new Tree(97);
		root.right.right.left = new Tree(150);
		preOrderTraversal(root);
	}

	public static void postOrderTraversal(Tree root) {
		Stack<Tree> s = new Stack<>();
		s.push(root);
		Map<Tree, Integer> m = new TreeMap<>();

		while (!s.isEmpty()) {
			Tree peek = s.peek();
			if (peek.left != null && m.get(peek.left) == null) {
				s.push(peek.left);
			} 
			else if (peek.right != null && m.get(peek.right) == null) {
				s.push(peek.right);
				
			} 
			else {
				m.put(peek, 0);
				System.out.println(peek.data);
				s.pop();
			}
		}
	}
	public static void preOrderTraversal(Tree root) {
		Stack<Tree> s = new Stack<>();
		s.push(root);
		Map<Tree, Integer> m = new TreeMap<>();
//		System.out.println(root.data);
		while (!s.isEmpty()) {
			Tree peek = s.peek();
			if (peek.left != null && m.get(peek.left) == null) {
				s.push(peek.left);
//				System.out.println(peek.data);
				continue;
			} 

			System.out.println(peek.data);
			if (peek.right != null && m.get(peek.right) == null) {
				s.push(peek.right);
//				System.out.println(peek.data);
				continue;
			} 
			m.put(peek, 0);
			s.pop();
		}
	}
}
