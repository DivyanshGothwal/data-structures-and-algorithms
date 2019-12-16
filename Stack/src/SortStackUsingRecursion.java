package src;

import java.util.Stack;
import java.util.*;

public class SortStackUsingRecursion {

	public static void main(String ar[]) {
		Stack<Integer> s = new Stack<>();
		s.push(3);
		s.push(10);
		s.push(13);
		s.push(20);
		s.push(43);
		s.push(1);
		s.push(4);
		s.push(5);
		s.push(12);
		s.push(54);
		sortStack(s);
		System.out.println(s);
	}
	public static void sortStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		int top = sortStackUtil(s, null);
		s.pop();
		sortStack(s);
		s.push(top);
	}
	public static int sortStackUtil(Stack<Integer> s, Integer prevEle){
		Integer top = s.pop();
		if(s.isEmpty()) {
			if(prevEle == null) {
				s.push(top);
				return top;
			}
			if(prevEle < top) {
				s.push(prevEle);
				return top;
			}
			else {
				s.push(top);
				return prevEle;
			}
			
		}
		top = sortStackUtil(s, top);
		if(prevEle == null) {
			s.push(top);
			return top;
		}
		if(top > prevEle) {
			s.push(prevEle);
			return top;
		}
		else {
			s.push(top);
			return prevEle;
		}
	}
}
