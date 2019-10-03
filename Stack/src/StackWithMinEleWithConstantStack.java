package src;

public class StackWithMinEleWithConstantStack {

	public static void main(String[] args) {
		CustomMinStack s = new CustomMinStack();
		s.push(10);
		s.push(20);
		s.push(5);
		s.push(6);
		s.push(12);
		s.push(7);
		s.push(4);
		s.push(20);
		s.push(2);
		System.out.println("Min "+s.getMin());
		System.out.println(s.pop());
		System.out.println("Min "+s.getMin());
		System.out.println(s.pop());
		System.out.println("Min "+s.getMin());
	}
}

class CustomMinStack {
	private Stack<Integer> s;
	private int min = Integer.MAX_VALUE;

	CustomMinStack() {
		s = new Stack<>();
	}

	public Integer push(Integer data) {
		s.push(2 * data - min);
		if (data < min) {
			min = data;
		}
		return data;
	}

	public Integer pop() {
		int top = s.getTop();
		s.pop();
		if (top < min) {
			int newMin = min;
			min = 2 * min - top;
			return newMin;
		} else {
			return (top + min) / 2;
		}
	}

	public Integer getMin() {
		return this.min;
	}
}
