package src;

import java.util.*;

import java.util.Stack;

public class FindNextSmallerElement {
	public static void main(String ar[]) {
		List<Integer> a = Arrays.asList(4, 1, 8, 6, 5, 2, 5, 25);
		findNextSmallElement(a);
	}

	static void findNextSmallElement(List<Integer> a) {
		Stack<Tuple1> s = new Stack<Tuple1>();

		int k = 1, j = 0;
		s.push(new Tuple1(j, a.get(j)));
		while (k < a.size()) {
			if (!s.isEmpty() && a.get(k) < s.peek().ele) {
				while (!s.isEmpty() && a.get(k) < s.peek().ele) {
					System.out.println(s.peek().ele + " ----->  " + a.get(k));
					s.pop();
				}
				s.push(new Tuple1(k, a.get(k)));
			} else {
				s.push(new Tuple1(k, a.get(k)));
			}
			k++;
		}
		while (!s.isEmpty()) {
			System.out.println(s.peek().ele + " index: " + s.peek().i + " ----> " + "-1");
			s.pop();
		}
	}
}

class Tuple1 {
	int i;
	int ele;

	Tuple1(int i, int ele) {
		this.i = i;
		this.ele = ele;
	}
}