package src;

import java.util.Stack;

public class PrintTreeInSpiralForm {

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
		printSpiralTree(root);
	}

	static void printSpiralTree(Tree root) {
		Stack<Tree> s1 = new Stack<>();
		Stack<Tree> s2 = new Stack<>();
		s1.push(root);
		int i = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (i % 2 == 0) {
				while (!s1.isEmpty()) {
					Tree ele = s1.peek();
					System.out.println(ele.data);
					s1.pop();
					if(ele.left !=null)
						s2.push(ele.left);
					if(ele.right !=null)
						s2.push(ele.right);
				}
			} else {
				while (!s2.isEmpty()) {
					Tree ele = s2.peek();
					System.out.println(ele.data);
					s2.pop();
					if(ele.left !=null)
						s1.push(ele.right);
					if(ele.right !=null)
						s1.push(ele.left);
				}
			}
			i++;
		}
	}
}
