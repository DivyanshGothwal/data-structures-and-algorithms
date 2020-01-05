package src;

import java.util.*;
import java.util.Stack;
public class CartesianTree {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		buildTree(a);
		sc.close();
	}
	public static void buildTree(int [] a) {
		Stack<tree> st = new Stack<>();
		st.push(new tree(0,a[0],null,null));
		tree root = new tree(0,a[0],null,null);
		for(int i=1;i<a.length;i++) {
			tree temp = new tree(i,a[i], null, null);
			tree top = st.peek();
			if(a[top.index]>=a[i]) {
				tree prevTop = st.peek();
				while(a[top.index]>a[i] && !st.isEmpty()) {
					top = st.peek();
					st.pop();
					prevTop = top;
				}
				temp.left = prevTop;
			}
			else {
				top.right = temp;
			}
			st.push(temp);
		}
		tree prevEle = null;
		while(!st.isEmpty()) {
			prevEle = st.peek();
			st.pop();
		}
		if(prevEle!=null) {
			root = prevEle;
		}
		printInorder(root);
	}
	public static void printInorder(tree root) {
		if(root==null) {
			return;
		}
		printInorder(root.left);
		System.out.println(root.index+" "+root.data);
		printInorder(root.right);
	}
}

class tree{
	int index;
	int data;
	tree left;
	tree right;
	tree(int index, int data, tree left, tree right){
		this.index = index;
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
