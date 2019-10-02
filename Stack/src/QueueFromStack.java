package src;

import java.util.Stack;
public class QueueFromStack {
	public static void main(String ar[]) {
		customQueue cq = new customQueue();
		cq.enqueue(10);
		cq.enqueue(20);
		cq.enqueue(30);
		cq.enqueue(40);
		cq.enqueue(50);
		cq.enqueue(15);
		cq.dequeue();
//		cq.dequeue();
		while(!cq.isEmpty()) {
			System.out.println(cq.dequeue());
		}
	}
}

class customQueue{
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	customQueue(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	public boolean isEmpty() {
		return s1.isEmpty();
	}
	public void enqueue(int data) {
		s1.push(data);
	}
	public int dequeue() {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		int l = s2.pop();
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return l;
	}
}
