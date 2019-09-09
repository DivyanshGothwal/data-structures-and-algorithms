
import java.util.*;

public class LinkedListAddition {

	public static void main(String[] args) {

		// scanner class to take input from user
		Scanner sc = new Scanner(System.in);
		// number of element to be inserted
		int n = sc.nextInt();
		LinkedList head = null;
		for (int i = 0; i < n; i++) {
			// element to be inserted
			int element = sc.nextInt();
			// Always inserting at the end of the list
			head = insertAtEnd(element, head);
		}
		// print linked list to console.
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
		// checking if head is present if not then return one node;
		if (head == null) {
			return new LinkedList(element);
		}
		LinkedList temp = head;

		// traversing till the end of the list then adding element last to it
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new LinkedList(element);

		// always returning head node
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