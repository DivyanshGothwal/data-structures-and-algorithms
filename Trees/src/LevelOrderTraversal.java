package src;

import java.util.*;

public class LevelOrderTraversal {
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
		levelOrder(root);
	}
	static void levelOrder(Tree Tree) {
        Queue<Tree> q = new LinkedList<Tree>();
        q.add(Tree);
        while(!q.isEmpty()){
            Tree peek = q.peek();
            System.out.print(peek.data+" ");
            q.remove();
            if(peek.left!=null){
                q.add(peek.left);
            }
            if(peek.right!=null){
                q.add(peek.right);
            }
        }
    }
}
