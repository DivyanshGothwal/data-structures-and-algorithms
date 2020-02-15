package src;

import java.util.*;

public class KSumPaths {
	public static void main(String[] args) {
		Tree root = new Tree(1);
		root.left = new Tree(3);
		
		root.left.left = new Tree(2);
		
//		root.left.left.left = new Tree(12);
//		root.left.left.right = new Tree(12);

		root.left.right = new Tree(1);
		root.left.right.left = new Tree(1);
//		root.left.right.right = new Tree(12);

		root.right = new Tree(-1);
		root.right.left = new Tree(4);
		root.right.left.left = new Tree(1);
		root.right.left.right = new Tree(2);

		root.right.right = new Tree(5);
		root.right.right.right = new Tree(6);
		
		findKSumPaths(root, 5);
	}
	static Map<Integer, List<StringBuilder>> findKSumPaths(Tree root, int k) {
		if(root==null)
			return new TreeMap<>();
		Map<Integer, List<StringBuilder>> left = findKSumPaths(root.left, k);
		Map<Integer, List<StringBuilder>> right = findKSumPaths(root.right, k);
		Map<Integer, List<StringBuilder>> combined = new TreeMap<>();
		
		for(Map.Entry<Integer, List<StringBuilder>> e1: left.entrySet()) {
			int key = e1.getKey()+root.data;
			
			List<StringBuilder> str1 = combined.get(key);
			List<StringBuilder> str = e1.getValue();
			if(str1==null) {
				str1 = new ArrayList<>();
			}
			for(int i=0;i<str.size();i++) {
				str.get(i).append(root.data);
				str1.add(str.get(i));
				if(key==k) {
					System.out.println(str.get(i));
				}
			}
			if(str.isEmpty()) {
				str.add(new StringBuilder(e1.getKey()+""+root.data));
			}
			combined.put(key, str);
		}
		for(Map.Entry<Integer, List<StringBuilder>> e: right.entrySet()) {
			int key = e.getKey()+root.data;
			List<StringBuilder> str1 = combined.get(key);
			List<StringBuilder> str = e.getValue();
			if(str1==null) {
				str1 = new ArrayList<>();
			}
			for(int i=0;i<str.size();i++) {
				str.get(i).append(root.data);
				str1.add(str.get(i));
				if(key==k) {
					System.out.println(str.get(i));
				}
			}
			if(str.isEmpty()) {
				str.add(new StringBuilder(e.getKey()+""+root.data));
			}
			combined.put(key, str1);
		}
		if(root.data==k) {
			System.out.println(root.data);
		}
		List<StringBuilder> str =new ArrayList<>(100);
		str.add(new StringBuilder(""+root.data));
		combined.put(root.data, str);
		return combined;
	}
}
