import java.util.Scanner;

public class LLAdditionAtGivenPoint {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		LL head = null;
		int n = sc.nextInt();
		while (n-- > 0) {
			int ele = sc.nextInt();
			int pos = sc.nextInt();
			head = insertLL(ele, pos, head);
			printLL(head);
		}
		sc.close();
	}

	private static void printLL(LL head) {
		LL temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	private static LL insertLL(int ele, int pos, LL head) {

		LL newNode = new LL(ele);
		int i = 1;
		LL temp = head;
		LL prevNode = head;
		while (temp != null) {
			if (i == pos) {
				break;
			}
			i++;
			prevNode = temp;
			temp = temp.next;

		}
		if (head == null && pos == 1) {
			return newNode;
		} else {
			if (i < pos) {
				System.out.println("Can not insert");
				return head;
			}
			newNode.next = temp;
			if (pos != 1) {
				prevNode.next = newNode;
			} else {
				return newNode;
			}
		}
		return head;
	}
}