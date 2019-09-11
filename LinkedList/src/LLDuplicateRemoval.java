
public class LLDuplicateRemoval {
	public static void main(String ar[]) {
		LL head = null;
		head = insertLL(4, head);
		head = insertLL(4, head);
		head = insertLL(4, head);
		head = insertLL(4, head);
		head = insertLL(4, head);
	}

	private static LL insertLL(int data, LL head) {
		LL newNode = new LL(data);
		if (head == null) {
			return newNode;
		}
		newNode.next = head;
		return newNode;
	}
}
