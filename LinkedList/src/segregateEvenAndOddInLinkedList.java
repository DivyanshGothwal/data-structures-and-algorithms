
public class segregateEvenAndOddInLinkedList {
	private static LL head = null;

	private static LL tempHead = null;
	static int isNotPossible = 0;

	public static void main(String ar[]) {
		head = new LL(5);
		head.next = new LL(6);
		head.next.next = new LL(7);
		head.next.next.next = new LL(8);
		head.next.next.next.next = new LL(3);
		head.next.next.next.next.next = new LL(7);
		head.next.next.next.next.next.next = new LL(44);
		head.next.next.next.next.next.next.next = new LL(5);
		tempHead = head;
		segregateLL(head.next);
		printLL(head);
	}

	private static void segregateLL(LL temp) {
		if (temp != null) {
			segregateLL(temp.next);
			if (tempHead != temp && isNotPossible == 0) {
				while (tempHead.data % 2 != 0 && tempHead.next != null) {
					tempHead = tempHead.next;
				}
				if (temp.data % 2 != 0) {
					int tempData = tempHead.data;
					tempHead.data = temp.data;
					temp.data = tempData;
					if (tempHead.next != null) {
						tempHead = tempHead.next;
					}
				}
				return;
			} else if (tempHead == temp) {
				isNotPossible = 1;
			}
		}
	}

	private static void printLL(LL head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
