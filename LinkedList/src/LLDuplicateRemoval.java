
import java.util.*;


public class LLDuplicateRemoval {
	public static void main(String ar[]) {
		LL head = null;
		head = insertLL(4, head);
		head = insertLL(4, head);
		head = insertLL(2, head);
		head = insertLL(3, head);
		head = insertLL(3, head);
		head = insertLL(6, head);
		head = insertLL(6, head);
		head = insertLL(7, head);
		head = insertLL(3, head);
		head = removeDuplicates(head);
		printLL(head);
	}
	
	private static void printLL(LL head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	private static LL removeDuplicates(LL head) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		LL temp = head;
		while(temp!=null) {
			Integer i = hash.get(temp.data);
			hash.put(temp.data,  i!= null?i+1:0);
			temp=temp.next;
		}
		LL newHead = null;
		LL prevNode = null;
		for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			LL newNode = new LL(entry.getKey());
			if(newHead == null) {
				newHead = newNode;
				prevNode = newHead;
			}
			else {
				prevNode.next = newNode;
				prevNode = newNode;
			}
		}
		
		hash.forEach((k,v)->{
			
		});
		return newHead;
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
