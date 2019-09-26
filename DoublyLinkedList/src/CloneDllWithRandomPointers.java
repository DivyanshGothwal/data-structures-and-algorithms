package src;

public class CloneDllWithRandomPointers {
	public static void main(String ar[]) {
		Dll head = new Dll(4);
		head.next = new Dll(9);
		head.next.next = new Dll(7);
		head.next.next.next = new Dll(4);
		head.next.next.next.next = new Dll(6);

		head.prev = head.next.next.next;
		head.next.prev = head.next.next.next.next;
		head.next.next.prev = head;
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next.prev = head.next;
		Dll newHead = cloneDll(head);// O(n)
		System.out.println(newHead);
	}

	private static Dll cloneDll(Dll head) {
		Dll temp = head;
		Dll newHead = null, newEle = null;
		int i = 0;
		while (temp != null) {
			Dll temp1 = temp.prev;
			if (i == 0) {
				newEle = createNode(newEle, temp.data, temp1);
				newHead = newEle;
				i++;
			} else {
				newEle = createNode(newEle, temp.data, temp1);
			}
			temp = temp.next;
		}
		return newHead;
	}

	private static Dll createNode(Dll head, int data, Dll prev) {
		Dll newNode = new Dll(data);
		newNode.prev = prev;
		if (head == null) {
			return newNode;
		}
		head.next = newNode;
		return newNode;
	}
}
