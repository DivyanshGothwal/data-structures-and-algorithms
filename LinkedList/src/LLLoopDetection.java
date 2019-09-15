
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
		head.next.next.next.next.next.next.next =  head;// new LL(12);

		LL loopStartPosition = isLoopPresent(head);
		if(loopStartPosition == null) {
			System.out.println("Loop is not present ");
		}
		else {
			LL temp = head;
			LL temp2 = head;			
			int lengthOfLoop = calculateLengthOfLoop(loopStartPosition);
			int i=0;
			System.out.println("length of loop : "+lengthOfLoop);
			while(i<lengthOfLoop) {
				temp = temp.next;
				i++;
			}
			while(temp2!=temp) {
				temp2 = temp2.next;
				temp = temp.next;
			}
			temp2= head;
			while(temp2.next != temp) {
				temp2 = temp2.next;
			}
			temp2.next = null;
			System.out.println("LL after loop removal");
		}
		
		printLL(head);
	}
	private static int calculateLengthOfLoop(LL loopStartPosition) {
		LL temp = loopStartPosition;
		LL temp2 = loopStartPosition.next;
		int k=1;
		while(temp != temp2) {
			temp2 = temp2.next;
			k++;
		}
		return k;
	}

	private static void printLL(LL head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}

	private static LL isLoopPresent(LL head) {
		LL slow = head;
		if (slow == null) {
			return null;
		}
		LL fast = head.next;
		if (fast == null) {
			return null;
		}
		while (slow != fast && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			} else {
				return null;
			}
		}
		if (slow == fast) {
			return slow;
		}
		return null;
	}
}
