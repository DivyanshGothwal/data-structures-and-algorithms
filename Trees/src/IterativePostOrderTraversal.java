package src;

import java.util.Stack;

public class IterativePostOrderTraversal {

	public static void main(String ar[]) {
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
		iterativePostTraversal(root);
	}

	private static void iterativePostTraversal(Tree root) {
		Stack<Tree> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			Tree topEle = st.peek();
			if(topEle==null) {
				st.pop();
				if(st.isEmpty()) {
					break;
				}
				Tree ele = st.pop();
				System.out.println(ele.data);
				if(st.isEmpty()) {
					break;
				}
				topEle = st.peek();
				while(topEle.right==ele) {
					ele = st.pop();
					System.out.println(ele.data);
					if(st.isEmpty()) {
						break;
					}
					topEle = st.peek();
				}
			} else {
				while(topEle.left!=null) {
					topEle  = topEle.left;
					st.push(topEle);
				}
			}
			if(st.isEmpty()) {
				break;
			}
			topEle = st.peek();
			st.push(topEle.right);
		}
	}
}
