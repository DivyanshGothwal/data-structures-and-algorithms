
import java.util.*;

public class LinkedListCreation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList head = null;
		for (int i = 0; i < n; i++) {
			int element = sc.nextInt();
			head = insertAtEnd(element, head);
		}
		printLinkedList(head);
		sc.close();
	}

	private static void printLinkedList(LinkedList head) {
		LinkedList temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static LinkedList insertAtEnd(int element, LinkedList head) {
		if (head == null) {
			return new LinkedList(element);
		}
		LinkedList temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new LinkedList(element);
		return head;

	}

}

class LinkedList {
	int data;
	LinkedList next;

	LinkedList(int data) {
		this.data = data;
		this.next = null;
	}
}