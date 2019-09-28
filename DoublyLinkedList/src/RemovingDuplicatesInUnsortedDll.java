package src;

import java.util.*;
import static java.util.Objects.*;

public class RemovingDuplicatesInUnsortedDll {

	public static void main(String[] args) {
		Dll head = new Dll(2);
		head.prev = null;
		head.next = new Dll(4);
		head.next.prev = head;
		head.next.next = new Dll(8);
		head.next.next.prev = head.next;
		head.next.next.next = new Dll(2);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new Dll(65);
		head.next.next.next.next.prev = head.next.next.next;
		head.next.next.next.next.next = new Dll(4);
		head.next.next.next.next.next.prev = head.next.next.next.next;
		head.next.next.next.next.next.next = new Dll(5);
		head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
		head.next.next.next.next.next.next.next = new Dll(65);
		head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;
		head.next.next.next.next.next.next.next.next = new Dll(5);
		head.next.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next.next;
		printDll(head);
		System.out.println();
		printDllReverse(head.next.next.next.next.next.next.next.next);
		removeDuplicates(head);
		System.out.println();
		printDll(head);
	}
	public static void printDllReverse(Dll head) {
		Dll temp = head;
		while (nonNull(temp)) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
	}
	public static void printDll(Dll head) {
		Dll temp = head;
		while (nonNull(temp)) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	private static Dll removeDuplicates(Dll head) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Dll temp = head;
		while (nonNull(temp)) {
			if(nonNull(map.get(temp.data))) {
				temp.prev.next = temp.next;
				if(nonNull(temp.next)) {
					temp.next.prev = temp.prev;
				}
				map.put(temp.data, map.get(temp.data)+1);
			}
			else {
				map.put(temp.data, 1);
			}
			temp = temp.next;			
		}
		return head;
	}
}
