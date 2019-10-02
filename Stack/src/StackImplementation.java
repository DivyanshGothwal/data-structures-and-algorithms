package src;

public class StackImplementation {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
		s.push(10);
//		s.push(10);
//		s.push(10);
//		s.push(10);

		System.out.println(s.getTop());
		System.out.println(s.size());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
	}

}

class Stack<T> {
	private int MAX_SIZE = 10;
	private Object[] stack = null;
	private int top;

	Stack() {
		top = -1;
		stack = new Object[MAX_SIZE];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public int size() {
		return top + 1;
	}

	public void push(T data) {
		if (top < MAX_SIZE-1) {
			top++;
			stack[top] = data;
		} else {
			System.out.println("Stack OverFlow");
		}

	}

	public T getTop() {
		return (T) stack[top];
	}

	public void pop() {
		if (top >= 0) {
			stack[top] = -1;
			top--;
		} else {
			System.out.println("Stack UnderFlow");
		}
	}
}