package src;

import java.util.ArrayList;
import java.util.List;

public class PopulateInorderSuccessor {
	public static TreeCustom succ=null;
	public static void main(String[] args) {
		TreeCustom root = new TreeCustom(9);
		root.left = new TreeCustom(18);
		root.left.left = new TreeCustom(19);
		root.left.left.left = new TreeCustom(81);
		root.left.left.right = new TreeCustom(10);
		root.left.right = new TreeCustom(7);
		root.left.right.left = new TreeCustom(6);
		root.left.right.right = new TreeCustom(8);
		root.right = new TreeCustom(68);
		root.right.left = new TreeCustom(76);
		root.right.right = new TreeCustom(97);
		root.right.right.left = new TreeCustom(150);
		populateWithOutExtraSpace(root);
	}
	public static void populateWithOutExtraSpace(TreeCustom root) {
		if(root==null)
			return;
		populateWithOutExtraSpace(root.right);
		root.next = succ;
		succ = root;
		populateWithOutExtraSpace(root.left);
	}
    public static void populateNextExtraSpace(TreeCustom root) {
        List<TreeCustom> a= new ArrayList<TreeCustom>();
        inOrder(root,a);
        for(int i=1;i<a.size();i++){
            TreeCustom before = a.get(i-1);
            TreeCustom curr = a.get(i);
            before.next = curr;
        }
    }
    public static void inOrder(TreeCustom root, List<TreeCustom> a){
        if(root==null)
            return;
        inOrder(root.left,a);
        a.add(root);
        inOrder(root.right,a);
    }
}
class TreeCustom {
	int data;
	TreeCustom left;
	TreeCustom right;
	TreeCustom next;
	TreeCustom prev;

	TreeCustom(int data, TreeCustom left, TreeCustom right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	TreeCustom(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.next = null;
		this.prev = null;
	}
}
