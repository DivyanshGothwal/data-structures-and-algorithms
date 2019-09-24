
import static java.util.Objects.*;
public class LLReverse {

	public static void main(String[] args) {
		LL head = null;
		head = new LL(5);
		head.next = new LL(3);
		head.next.next = new LL(2);
		head.next.next.next = new LL(51);
		head.next.next.next.next = new LL(25);
		head.next.next.next.next.next = new LL(12);
		printLL(head);
		head = reverseLLUsingLoop(head);

		head = reverseLLUsingRecursion(head, null);
		System.out.println(head+" test");
		printLL(head);
	}
	public static void printLL(LL head) {
		LL temp = head;
		while(nonNull(temp)) {
			System.out.print(temp.data+" ");
			temp= temp.next;
		}
		System.out.println();
	}
	private static LL reverseLLUsingLoop(LL head) {
		if(isNull(head)) {
			return head;
		}
		LL prev = null, curr = head, next = head.next;
		while(nonNull(curr)) {
			curr.next = prev;
			LL temp = null;
			prev = curr;
			if(nonNull(next)) {
				temp = next.next;
				next.next = curr;
				
			}
			curr = next;
			next = temp;
		}
		return prev;
	}
	private static LL reverseLLUsingRecursion(LL head, LL prev) {
		if(isNull(head)) {
			return head;
		}
		LL temp = reverseLLUsingRecursion(head.next, head);

		head.next = prev;
		if(isNull(head.next)) {
			return head;
		}
		return temp;
	}
	
}
