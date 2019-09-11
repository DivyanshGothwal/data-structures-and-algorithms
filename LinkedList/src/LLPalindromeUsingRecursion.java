
import java.util.*;

public class LLPalindromeUsingRecursion {
	private static LL head = null;

	public static void main(String ar[]) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();

		head = insertLL(4, head);
		head = insertLL(2, head);
		head = insertLL(3, head);
		head = insertLL(2, head);
		head = insertLL(4, head);
		head = insertLL(4, head);
		head = insertLL(2, head);
		head = insertLL(3, head);
		head = insertLL(2, head);
		head = insertLL(4, head);
		LL headStatic  = head;
		if (isPalindrome(head)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static void printLL(LL head) {
		LL temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static boolean isPalindrome(LL temp) {
		if (temp != null) {
			boolean isPalindrome = isPalindrome(temp.next);
			if (head.data == temp.data) {
				if (head.next != null) {
					head = head.next;
				}
				return isPalindrome && true;
			}
			head = head.next;
			return false;
		}
		return true;
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
