
import java.util.*;

public class LinkedListAddition {

	public static void main(String[] args) {

		// scanner class to take input from user
		Scanner sc = new Scanner(System.in);
		// number of element to be inserted
		int n = sc.nextInt();
		System.out.println("Please type 0 for isert at end and 1 for isert at head");
		int isInsertAtHead = sc.nextInt();
		LL head = null;
		for (int i = 0; i < n; i++) {
			// element to be inserted
			int element = sc.nextInt();
			// Always inserting at the end of the list
			head = isInsertAtHead == 1 ? insertAtHead(element, head) : insertAtEnd(element, head);
		}
		// print linked list to console.
		printLL(head);
		sc.close();
	}

	private static LL insertAtHead(int element, LL head) {
		LL newNode = new LL(element);
		// checking if head is present if not then return one node;
		if (head == null) {
			return newNode;
		}
		LL temp = head;
		// update head of the linked list.
		head = newNode;
		newNode.next = temp;
		// return updated head
		return head;
	}

	private static void printLL(LL head) {
		LL temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static LL insertAtEnd(int element, LL head) {
		LL newNode = new LL(element);
		// checking if head is present if not then return one node;
		if (head == null) {
			return newNode;
		}
		LL temp = head;

		// traversing till the end of the list then adding element last to it
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;

		// always returning head node
		return head;

	}

}

class LL {
	int data;
	LL next;

	LL(int data) {
		this.data = data;
		this.next = null;
	}
}