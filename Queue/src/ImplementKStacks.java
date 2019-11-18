package src;

import java.util.Arrays;
import java.util.LinkedList;

public class ImplementKStacks {
	public static void main(String[] ar) {
		KQueue k = new KQueue(20, 7);
		k.enQueue(20, 4);
		k.enQueue(2, 3);
		k.enQueue(45, 3);
		k.enQueue(87, 3);
		k.enQueue(34, 6);
		k.enQueue(34, 4);
//		k.enQueue(23, 3);
		k.enQueue(67, 2);
		k.enQueue(89, 6);
		System.out.println(k.deQueue(3));
		System.out.println(k.deQueue(2));
		System.out.println(k.deQueue(3));
	}
}

class KQueue {
	int a[];
	int k;
	int currIndex = 0;
	LinkedList<Integer> list[];

	KQueue(int n, int q) {
		this.a = new int[n];
		this.k = q;
		this.list = new LinkedList[k + 1];
		Arrays.fill(this.list, new LinkedList<Integer>());
	}

	void enQueue(int x, int q) {
		if (currIndex >= a.length) {
			throw new RuntimeException("filled");
		}
		LinkedList<Integer> l = this.list[q];
		if (l.isEmpty()) {
			l = new LinkedList<>();
		}
		l.addLast(currIndex);
		a[currIndex]=x;
		this.currIndex++;
		this.list[q]=l;
	}

	int deQueue(int q) {
		if (q > k) {
			throw new RuntimeException("Queue doesnot exists");
		}
		LinkedList<Integer> l = this.list[q];
		if (l.isEmpty()) {
			throw new RuntimeException("No element exists in passed queue");
		}
		this.currIndex--;
		return a[l.removeLast()];
	}
}