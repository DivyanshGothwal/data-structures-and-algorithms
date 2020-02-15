package src;

import java.util.*;
import java.io.*;


class GandhiMarch {
    
    public static void main(String args[]) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int t = Integer.parseInt(s);
        while(t-->0){
            s = br.readLine();
            String [] s1 = s.split(" ");
            int c = Integer.parseInt(s1[0]);
            
            String tree = s1[1];
            Stack<Character> st = new Stack<>();
            st.push(tree.charAt(0));
            Tree233 root = new Tree233(tree.charAt(0), null, null, 0);
            Tree233 parent  = root;
            Tree233 prev = null;
//            createTree(root, tree, 0);
//            traverse(root);
            StringBuilder sb = new StringBuilder("");
            if(sb.toString().equals("")){
            	System.out.println("Yes");
            }
            char a[] = sb.toString().toCharArray();
            Arrays.sort(a);
            String r = new String(a);
        }
    }
    public static void traverse(Tree233 root){
        if(root==null)
            return;
        traverse(root.left);
        System.out.println(root.data);
        traverse(root.right);
    }
    public static TreeNode createTree(Tree233 root, String tree, int i){
    	
        if(tree.charAt(i)=='.'){
            int nextRight  = 0;
            i++;
            Character ch = tree.charAt(i);
            while(ch==')' || ch=='(' ){
                i++;
                if(i < tree.length()) {
                	ch = tree.charAt(i);
                	
                }
                else {
                	break;
                }
            }
            nextRight = i;
            return new TreeNode(null, nextRight);
        }
        TreeNode nodeLeft = createTree(new Tree233(tree.charAt(i+2), null, null, 0), tree, i+2 );
        root.left = nodeLeft.ele;
//        System.out.println("node left: "+ )
        TreeNode nodeRight = createTree(new Tree233(tree.charAt(nodeLeft.nextEle), null, null, 0), tree, nodeLeft.nextEle );
        root.right = nodeRight.ele;
        return new TreeNode(root, nodeRight.nextEle);
    }
}

class Tree233{
    Character data;
    Tree233 left;
    Tree233 right;
    int column;
    Tree233(Character data, Tree233 left, Tree233 right, int column){
        this.data = data;
        this.left = left;
        this.right = right;
        this.column = column;
    }
}
class TreeNode{
    int nextEle;
    Tree233 ele;
    TreeNode(Tree233 ele, int nextEle){
        this.nextEle = nextEle;
        this.ele = ele;
    }
}