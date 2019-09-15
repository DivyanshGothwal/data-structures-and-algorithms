
public class LLLoopDetection {
	public static void main(String ar[]) {
		LL head = null;
		// LL with loop
		head = new LL(5);
		head.next = new LL(7);
		head.next.next = new LL(6);
		head.next.next.next = new LL(9);
		head.next.next.next.next = new LL(3);
		head.next.next.next.next.next = new LL(2);
		head.next.next.next.next.next.next = new LL(12);
		head.next.next.next.next.next.next =  head.next.next.next;// new LL(12);

		System.out.println(isLoopPresent(head));
	}

	private static boolean isLoopPresent(LL head) {
		LL slow = head;
		if (slow == null) {
			return false;
		}
		LL fast = head.next;
		if (fast == null) {
			return false;
		}
		while (slow != fast && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			} else {
				return false;
			}
		}
		if (slow == fast) {
			return true;
		}
		return false;
	}
}
