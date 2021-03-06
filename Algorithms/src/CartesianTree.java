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
		buildCustomTree(a);
		sc.close();
	}
	public static void buildCustomTree(int [] a) {
		Stack<CustomTree> st = new Stack<>();
		st.push(new CustomTree(0,a[0],null,null));
		CustomTree root = new CustomTree(0,a[0],null,null);
		for(int i=1;i<a.length;i++) {
			CustomTree temp = new CustomTree(i,a[i], null, null);
			CustomTree top = st.peek();
			if(a[top.index]>=a[i]) {
				CustomTree prevTop = st.peek();
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
		CustomTree prevEle = null;
		while(!st.isEmpty()) {
			prevEle = st.peek();
			st.pop();
		}
		if(prevEle!=null) {
			root = prevEle;
		}
		printInorder(root);
	}
	public static void printInorder(CustomTree root) {
		if(root==null) {
			return;
		}
		printInorder(root.left);
		System.out.println(root.index+" "+root.data);
		printInorder(root.right);
	}
}

class CustomTree{
	int index;
	int data;
	CustomTree left;
	CustomTree right;
	CustomTree(int index, int data, CustomTree left, CustomTree right){
		this.index = index;
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
