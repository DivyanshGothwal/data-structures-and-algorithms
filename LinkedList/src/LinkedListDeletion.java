
import java.util.*;

public class LinkedListDeletion {
	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LL head = null;
		while (n-- > 0) {
			int element = sc.nextInt();
			head = insertAtHead(element, head);
		}
		int elementToDelete = sc.nextInt();
		printLL(head);
		head = deleteElement(elementToDelete, head);
		printLL(head);
	}

	private static LL deleteElement(int elementToDelete, LL head) {
		if ((head == null) || (head.next == null && head.data == elementToDelete)) {
			return null;
		}
		LL temp = head;
		LL prev = head;
		LL reqNode = null;
		while (temp != null) {
			if (temp.data == elementToDelete) {
				reqNode = temp;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		if (reqNode == null) {
			System.out.println("Not Found");
			return head;
		}
		if (reqNode == head) {
			head = head.next;
		} else {
			prev.next = reqNode.next;
		}
		return head;

	}

	private static void printLL(LL head) {
		LL temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static LL insertAtHead(int element, LL head) {
		LL newNode = new LL(element);
		if (head == null) {
			return newNode;
		}
		LL temp = head;
		head = newNode;
		newNode.next = temp;
		return head;
	}
}