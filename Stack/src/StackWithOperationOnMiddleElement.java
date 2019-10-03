package src;


public class StackWithOperationOnMiddleElement {
	public static void main(String ar[]) {
		customStack cs = new customStack();
//		cs.push(10);
//		cs.push(20);
		cs.push(30);
		cs.push(40);
		cs.push(50);
//		cs.pop();
//		cs.pop();
		System.out.println(cs.getMiddle());
		System.out.println(cs.deleteMiddle());
	}
}

class customStack {
	private DLLL head = null;
	private DLLL middle = null;
	private int size = 0;

	private class DLLL {
		private int data;
		private DLLL prev;
		private DLLL next;

		private DLLL(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public int push(int data) {
		DLLL newDlll = new DLLL(data);
		if (head != null) {
			newDlll.next = head;
			head.prev = newDlll;
		} else {
			middle = newDlll;
		}
		head = newDlll;
		size++;
		if (size % 2 == 0) {
			middle = middle.prev;
		}
		return data;
	}

	public int pop() {
		if (head == null) {
			throw new RuntimeException("");
		}
		int data = head.data;
		if (head != null) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		}
		size--;
		if (size % 2 != 0 || size == 0) {
			middle = middle.next;
		}
		return data;
	}

	public int getMiddle() {
		if (middle == null) {
			throw new RuntimeException("");
		}
		return middle.data;
	}

	public int deleteMiddle() {
		if (middle == null) {
			throw new RuntimeException("");
		}
		int deletedMiddle = middle.data;
		if (middle.prev != null) {
			middle.prev.next = middle.next;
		}
		if (middle.next != null) {
			middle.next.prev = middle.prev;
		}
		if (head == middle) {
			head = null;
		}
		size--;
		middle = middle.prev;
		return deletedMiddle;
	}
}